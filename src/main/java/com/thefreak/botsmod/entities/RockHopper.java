package com.thefreak.botsmod.entities;

import com.thefreak.botsmod.init.ModEntityTypes;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class RockHopper extends TameableEntity implements IAnimatedEntity {
	private final EntityAnimationManager manager = new EntityAnimationManager();
	private final AnimationController controller = new EntityAnimationController(this, "moveController", 15, this::animationPredicate);

	public RockHopper(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
		this.setTamed(false);
		registerAnimationControllers();
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		RockHopper entity = new RockHopper(ModEntityTypes.ROCK_HOPPER.get(), this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)),
				SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
		return entity;
	}
	@Override
	protected void registerGoals() {
		super.registerGoals();
	    this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.STONE), false));
	    this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
	    this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
	    this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	}

	@Override
	protected void updateAITasks() {
		
		super.updateAITasks();
	}
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
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	      if (this.isTamed()) {
	          this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	       } else {
	          this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
	       }
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
	private <E extends RockHopper> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (event.isWalking()) {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.rock_hopper.Walk", true));
		} else {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.rock_hopper.Idle", true));
		}

	return true; }
	private void registerAnimationControllers() {
		manager.addAnimationController(controller);
	}
}

