package com.thefreak.botsmod.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GiantTardigradeEntity extends CreatureEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("animation.giant_tardigrade.idle");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("animation.giant_tardigrade.walk");
    public static AnimationBuilder JUMP = new AnimationBuilder().addAnimation("animation.giant_tardigrade.jump");
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
        pathNavigator = new GroundPathNavigator(this, this.world);


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

    public boolean shouldRepathfind() {
        return this.ticksExisted % 200 <= 10;
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
