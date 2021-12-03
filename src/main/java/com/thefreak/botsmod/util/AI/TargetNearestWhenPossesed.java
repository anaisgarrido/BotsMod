package com.thefreak.botsmod.util.AI;

import com.thefreak.botsmod.init.EffectInitNew;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.TargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.function.Predicate;

public class TargetNearestWhenPossesed<T extends LivingEntity> extends TargetGoal {
    protected final Class<T> targetClass;
    protected final int targetChance;
    protected LivingEntity nearestTarget;
    /** This filter is applied to the Entity search. Only matching entities will be targeted. */
    protected EntityPredicate targetEntitySelector;

    public TargetNearestWhenPossesed(MobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
        this(goalOwnerIn, targetClassIn, checkSight, false);
    }

    public TargetNearestWhenPossesed(MobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
        this(goalOwnerIn, targetClassIn, 10, checkSight, nearbyOnlyIn, (Predicate<LivingEntity>)null);
    }

    public TargetNearestWhenPossesed(MobEntity goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, checkSight, nearbyOnlyIn);
        this.targetClass = targetClassIn;
        this.targetChance = targetChanceIn;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        this.targetEntitySelector = (new EntityPredicate()).range(this.getFollowDistance()).selector(targetPredicate);
    }
    private static boolean entityHasEffect(LivingEntity entity, Effect effect) {
        Collection<EffectInstance> entityEffects = entity.getActiveEffects();
        for (EffectInstance entityEffect : entityEffects) {
            if (entityEffect.getEffect() == effect) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    public boolean canUse() {
        if (entityHasEffect((LivingEntity) this.mob.getEntity(), EffectInitNew.POSSESION.get())) {
            if (this.targetChance > 0 && this.mob.getRandom().nextInt(this.targetChance) != 0) {
                return false;
            } else {
                this.findNearestTarget();
                return this.nearestTarget != null;
            }
        } else return false;
    }

    protected AxisAlignedBB getTargetableArea(double targetDistance) {
        return this.mob.getBoundingBox().inflate(targetDistance, 4.0D, targetDistance);
    }

    protected void findNearestTarget() {
        if (this.targetClass != PlayerEntity.class && this.targetClass != ServerPlayerEntity.class) {
            this.nearestTarget = this.mob.level.getNearestLoadedEntity(this.targetClass, this.targetEntitySelector, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ(), this.getTargetableArea(this.getFollowDistance()));
        } else {
            this.nearestTarget = this.mob.level.getNearestPlayer(this.targetEntitySelector, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }

    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void start() {
        this.mob.setTarget(this.nearestTarget);
        super.start();
    }

    public void setNearestTarget(@Nullable LivingEntity target) {
        this.nearestTarget = target;
    }
}
