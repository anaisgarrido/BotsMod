package com.thefreak.botsmod.util.AI;

import com.thefreak.botsmod.util.Predicate.ItemEntityPredicate;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AvoidItemEntityGoal<T extends ItemEntity> extends Goal {
    protected final CreatureEntity entity;
    private final double farSpeed;
    private final double nearSpeed;
    protected List<T> avoidTarget;
    protected final float avoidDistance;
    protected Path path;
    protected final PathNavigator navigation;
    /** Class of entity this behavior seeks to avoid */
    protected final Class<T> classToAvoid;
    protected final Predicate<ItemEntity> avoidTargetSelector;
    protected final Predicate<ItemEntity> field_203784_k;
    private final EntityPredicate builtTargetSelector;

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
        this(entityIn, classToAvoidIn, (p_200828_0_) -> {
            return true;
        }, avoidDistanceIn, farSpeedIn, nearSpeedIn, EntityPredicates.CAN_AI_TARGET::test);
    }

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> avoidClass, Predicate<ItemEntity> targetPredicate, float distance, double nearSpeedIn, double farSpeedIn, Predicate<ItemEntity> p_i48859_9_) {
        this.entity = entityIn;
        this.classToAvoid = avoidClass;
        this.avoidTargetSelector = targetPredicate;
        this.avoidDistance = distance;
        this.farSpeed = nearSpeedIn;
        this.nearSpeed = farSpeedIn;
        this.field_203784_k = p_i48859_9_;
        this.navigation = entityIn.getNavigator();
        this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        this.builtTargetSelector = (new ItemEntityPredicate()).setDistance((double)distance).setCustomItemPredicate(p_i48859_9_.and(targetPredicate));
    }

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> avoidClass, float distance, double nearSpeedIn, double farSpeedIn, Predicate<ItemEntity> targetPredicate) {
        this(entityIn, avoidClass, (p_203782_0_) -> {
            return true;
        }, distance, nearSpeedIn, farSpeedIn, targetPredicate);
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean shouldExecute() {
        this.avoidTarget = this.entity.world.getEntitiesWithinAABB(classToAvoid, this.entity.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
        for (ItemEntity itemEntity : this.avoidTarget) {
            if (itemEntity == null) {
                return false;
            } else {
                Vector3d vector3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.entity, 16, 7, itemEntity.getPositionVec());
                if (vector3d == null) {
                    return false;
                } else if (itemEntity.getDistanceSq(vector3d.x, vector3d.y, vector3d.z) < itemEntity.getDistanceSq(this.entity)) {
                    return false;
                } else {
                    this.path = this.navigation.getPathToPos(vector3d.x, vector3d.y, vector3d.z, 0);
                    return this.path != null;
                }
            }

        }
    return false;
    }



    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean shouldContinueExecuting() {
        return !this.navigation.noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.navigation.setPath(this.path, this.farSpeed);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask() {
        this.avoidTarget = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        for (ItemEntity itemEntity : this.avoidTarget) {
            if (this.entity.getDistanceSq(itemEntity) < 49.0D) {
                this.entity.getNavigator().setSpeed(this.nearSpeed);
            } else {
                this.entity.getNavigator().setSpeed(this.farSpeed);
            }
        }

    }
}