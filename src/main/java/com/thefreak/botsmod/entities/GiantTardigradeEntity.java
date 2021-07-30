package com.thefreak.botsmod.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;

public class GiantTardigradeEntity extends CreatureEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.giant_tardigrade.idle");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("animation.giant_tardigrade.walk");
    public static AnimationBuilder JUMP = new AnimationBuilder().addAnimation("animation.giant_tardigrade.jump");
    public static AnimationBuilder DEATH = new AnimationBuilder().addAnimation("animation.giant_tardigrade.death");
    //Inner Variables
    public static boolean Sleeping;
    public static double FoodLevel = 20.0D;
    public static boolean Flying;
    public static double MoveSpeed = 1.5D;
    //


    GroundPathNavigator pathNavigator;

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {

        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 320.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, MoveSpeed)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 0D);
    }

    public GiantTardigradeEntity(EntityType<? extends CreatureEntity> type, World worldIn) {

        super(type, worldIn);
        this.pathNavigator = new GroundPathNavigator(this, this.world);
        this.moveController = new FlyingMovementController(this, 1, true);


    }



    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }

    public boolean canCollide(Entity entity) {
        return func_242378_a(this, entity);
    }

    public static boolean func_242378_a(Entity p_242378_0_, Entity entity) {
        return (entity.func_241845_aY() || entity.canBePushed()) && !p_242378_0_.isRidingSameEntity(entity);
    }

    @Override
    protected void registerGoals() {
    }
    private <E extends GiantTardigradeEntity> PlayState predicate(AnimationEvent<E> event) {
        AnimationController controller = event.getController();
        AnimationBuilder anim = IDLE_ANIM;
        if (event.isMoving()) {
            anim = WALK_ANIM;
        }
        if ((this.dead || this.getHealth() < 0.01 || this.getShouldBeDead())) {
            anim = DEATH;
        }
        controller.setAnimation(anim);
        return PlayState.CONTINUE;
    }

    @Override
    protected void doBlockCollisions() {
        super.doBlockCollisions();
    }
    public boolean canBeCollidedWith() {
        return !this.removed;
    }
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean func_241845_aY() {
        return this.isAlive();
    }

    public void applyEntityCollision(Entity entityIn) {
        if (entityIn instanceof GiantTardigradeEntity) {
            if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
                super.applyEntityCollision(entityIn);
            }
        } else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
            super.applyEntityCollision(entityIn);
        }

    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    public boolean shouldRepathfind() {
        return this.ticksExisted % 200 <= 10;
    }


    @Override
    protected void onDeathUpdate() {
        super.onDeathUpdate();
        ++this.deathTime;
        if (this.deathTime == 200) {
            this.remove();
            for(int i = 0; i < 20; ++i) {
                double d0 = this.rand.nextGaussian() * 0.02D;
                double d1 = this.rand.nextGaussian() * 0.02D;
                double d2 = this.rand.nextGaussian() * 0.02D;
                this.world.addParticle(ParticleTypes.POOF, this.getPosXRandom(1.0D), this.getPosYRandom(), this.getPosZRandom(1.0D), d0, d1, d2);
            }
            for (int i = 0; i < 20; ++i) {

            }

        }
    }
    public boolean hasNoGravity() {
        return this.isAlive()? true : false;
    }


    @Override
    protected AxisAlignedBB getBoundingBox(Pose pose) {
        return super.getBoundingBox(pose);
    }

    @Override
    public void tick() {

        if (this.isAlive()) {

        } else {

        }

        doBlockCollisions();
        this.doBlockCollisions();

        super.tick();
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }



}
