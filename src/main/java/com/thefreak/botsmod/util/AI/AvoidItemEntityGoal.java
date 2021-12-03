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
    protected final Predicate<ItemEntity> predicateOnAvoidEntity;
    private final EntityPredicate builtTargetSelector;

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
        this(entityIn, classToAvoidIn, (p_200828_0_) -> {
            return true;
        }, avoidDistanceIn, farSpeedIn, nearSpeedIn, EntityPredicates.NO_CREATIVE_OR_SPECTATOR::test);
    }

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> avoidClass, Predicate<ItemEntity> targetPredicate, float distance, double nearSpeedIn, double farSpeedIn, Predicate<ItemEntity> p_i48859_9_) {
        this.entity = entityIn;
        this.classToAvoid = avoidClass;
        this.avoidTargetSelector = targetPredicate;
        this.avoidDistance = distance;
        this.farSpeed = nearSpeedIn;
        this.nearSpeed = farSpeedIn;
        this.predicateOnAvoidEntity = p_i48859_9_;
        this.navigation = entityIn.getNavigation();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        this.builtTargetSelector = (new ItemEntityPredicate()).range((double)distance).setCustomItemPredicate(p_i48859_9_.and(targetPredicate));
    }

    public AvoidItemEntityGoal(CreatureEntity entityIn, Class<T> avoidClass, float distance, double nearSpeedIn, double farSpeedIn, Predicate<ItemEntity> targetPredicate) {
        this(entityIn, avoidClass, (p_203782_0_) -> {
            return true;
        }, distance, nearSpeedIn, farSpeedIn, targetPredicate);
    }


    public boolean canUse() {
        this.avoidTarget = this.entity.level.getEntitiesOfClass(classToAvoid, this.entity.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
        for (ItemEntity itemEntity : this.avoidTarget) {
            if (itemEntity == null) {
                return false;
            } else {
                Vector3d vector3d = RandomPositionGenerator.getPosAvoid(this.entity, 16, 7, itemEntity.position());
                if (vector3d == null) {
                    return false;
                } else if (itemEntity.distanceToSqr(vector3d.x, vector3d.y, vector3d.z) < itemEntity.distanceToSqr(this.entity)) {
                    return false;
                } else {
                    this.path = this.navigation.createPath(vector3d.x, vector3d.y, vector3d.z, 0);
                    return this.path != null;
                }
            }

        }
    return false;
    }


    public boolean canContinueToUse() {
        return !this.navigation.isDone();
    }


    public void start() {
        this.navigation.moveTo(this.path, this.farSpeed);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void stop() {
        this.avoidTarget = null;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void tick() {
        for (ItemEntity itemEntity : this.avoidTarget) {
            if (this.entity.distanceToSqr(itemEntity) < 49.0D) {
                this.entity.getNavigation().setSpeedModifier(this.nearSpeed);
            } else {
                this.entity.getNavigation().setSpeedModifier(this.farSpeed);
            }
        }

    }
}