package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;

import com.thefreak.botsmod.entities.GiantTardigradeEntity;
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

}
