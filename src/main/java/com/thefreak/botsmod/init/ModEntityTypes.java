package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;

import com.thefreak.botsmod.entities.BansheeScreamEntity;
import com.thefreak.botsmod.entities.GiantTardigradeEntity;
import com.thefreak.botsmod.entities.PinkPurifiedSaltItemEntity;
import com.thefreak.botsmod.entities.Projectile.SaltedArrow;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, BotsMod.MOD_ID);

	public static final RegistryObject<EntityType<GiantTardigradeEntity>> GIANT_TARDIGRADE = ENTITY.register("giant_tardigrade", () ->
			EntityType.Builder.<GiantTardigradeEntity>of(GiantTardigradeEntity::new, EntityClassification.WATER_AMBIENT).sized(4.5F,4F).build(new ResourceLocation(BotsMod.MOD_ID,"giant_tardigrade").toString()));

	public static final RegistryObject<EntityType<WanderingSpecterEntity>> WANDERING_SPECTER = ENTITY.register("wandering_specter", () ->
			EntityType.Builder.<WanderingSpecterEntity>of(WanderingSpecterEntity::new, EntityClassification.MONSTER).sized(0.8F,2.1F).build(new ResourceLocation(BotsMod.MOD_ID,"wandering_specter").toString()));
	//MISC_ITEMS
	public static final RegistryObject<EntityType<PinkPurifiedSaltItemEntity>> PINK_PURIFIED_SALT_ITEM_ENTITY = ENTITY.register("pink_purified_salt_item_entity", () ->
			EntityType.Builder.<PinkPurifiedSaltItemEntity>of(PinkPurifiedSaltItemEntity::new, EntityClassification.MISC).sized(0.1F,0.1F).build(new ResourceLocation(BotsMod.MOD_ID,"pink_purified_salt_item_entity").toString()));

	//MISC_SPECIAL

	public static final RegistryObject<EntityType<BansheeScreamEntity>> BANSHEE_SCREAM = ENTITY.register("banshee_scream", () ->
			EntityType.Builder.<BansheeScreamEntity>of(BansheeScreamEntity::new, EntityClassification.MISC).sized(0.3F,0.3F).build(new ResourceLocation(BotsMod.MOD_ID,"banshee_scream").toString()));

	public static final RegistryObject<EntityType<SaltedArrow>> SALTED_ARROW = ENTITY.register("salted_arrow", () ->
			EntityType.Builder.<SaltedArrow>of(SaltedArrow::new, EntityClassification.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BotsMod.MOD_ID,"salted_arrow").toString()));

}
