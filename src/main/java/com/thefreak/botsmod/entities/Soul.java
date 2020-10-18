package com.thefreak.botsmod.entities;

import com.thefreak.botsmod.init.ModEntityTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.brain.task.FleeTask;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class Soul extends AnimalEntity implements IAnimatedEntity {
	private final EntityAnimationManager manager = new EntityAnimationManager();
	private final AnimationController controller = new EntityAnimationController(this,
			"moveController",
			15, this::animationPredicate);

	public Soul(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
	}
	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		Soul entity = new Soul(ModEntityTypes.SOUL.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(2, new FindWaterGoal(this));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new MoveThroughVillageAtNightGoal(this, 5));
		this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
	}

	@Override
	protected void updateAITasks() { super.updateAITasks(); }

	@Override
	public void livingTick() {
		super.livingTick();
	}

	@Override
	 public boolean processInteract(PlayerEntity player, Hand hand) {
	      @SuppressWarnings("unused")
		ItemStack itemstack = player.getHeldItem(hand);
	         return super.processInteract(player, hand);

	   }
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	          this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
	      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}
	   public void writeAdditional(CompoundNBT compound) {
		      super.writeAdditional(compound);
		      compound.putBoolean("Angry", this.isAggressive());

	}

    @Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	private <E extends Soul> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (event.isWalking()) {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.soul.walk", true));
		} else {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.soul.idle", true));
		}

	return true; }
	private void registerAnimationControllers() {
		manager.addAnimationController(controller);
	}
}

