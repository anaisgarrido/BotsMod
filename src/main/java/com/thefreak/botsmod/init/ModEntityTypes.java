package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;

import com.thefreak.botsmod.entities.BansheeScreamEntity;
import com.thefreak.botsmod.entities.GiantTardigradeEntity;
import com.thefreak.botsmod.entities.PinkPurifiedSaltItemEntity;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, BotsMod.MOD_ID);

	public static final RegistryObject<EntityType<GiantTardigradeEntity>> GIANT_TARDIGRADE = ENTITY.register("giant_tardigrade", () ->
			EntityType.Builder.<GiantTardigradeEntity>create(GiantTardigradeEntity::new, EntityClassification.WATER_AMBIENT).size(4.5F,4F).build(new ResourceLocation(BotsMod.MOD_ID,"giant_tardigrade").toString()));

	public static final RegistryObject<EntityType<WanderingSpecterEntity>> WANDERING_SPECTER = ENTITY.register("wandering_specter", () ->
			EntityType.Builder.<WanderingSpecterEntity>create(WanderingSpecterEntity::new, EntityClassification.MONSTER).size(0.8F,2.1F).build(new ResourceLocation(BotsMod.MOD_ID,"wandering_specter").toString()));
	//MISC_ITEMS
	public static final RegistryObject<EntityType<PinkPurifiedSaltItemEntity>> PINK_PURIFIED_SALT_ITEM_ENTITY = ENTITY.register("pink_purified_salt_item_entity", () ->
			EntityType.Builder.<PinkPurifiedSaltItemEntity>create(PinkPurifiedSaltItemEntity::new, EntityClassification.MISC).size(0.1F,0.1F).build(new ResourceLocation(BotsMod.MOD_ID,"pink_purified_salt_item_entity").toString()));

	//MISC_SPECIAL

	public static final RegistryObject<EntityType<BansheeScreamEntity>> BANSHEE_SCREAM = ENTITY.register("banshee_scream", () ->
			EntityType.Builder.<BansheeScreamEntity>create(BansheeScreamEntity::new, EntityClassification.MISC).size(0.3F,0.3F).build(new ResourceLocation(BotsMod.MOD_ID,"banshee_scream").toString()));

}
