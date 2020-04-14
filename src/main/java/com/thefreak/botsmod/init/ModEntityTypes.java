package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.entities.PoisonBull;
import com.thefreak.botsmod.entities.RockHopper;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, BotsMod.MOD_ID);
	
	public static final RegistryObject<EntityType<RockHopper>> ROCK_HOPPER = ENTITY_TYPES
			.register("rock_hopper",
			() -> EntityType.Builder.<RockHopper>create(RockHopper::new, EntityClassification.CREATURE)
			.size(0.5f, 1f)
			.build(new ResourceLocation(BotsMod.MOD_ID, "rock_hopper").toString()));
	
	public static final RegistryObject<EntityType<PoisonBull>> POISON_BULL = ENTITY_TYPES
			.register("poison_bull",
					() -> EntityType.Builder.<PoisonBull>create(PoisonBull::new, EntityClassification.CREATURE)
					.size(0.5f, 1f)
					.build(new ResourceLocation(BotsMod.MOD_ID, "poison_bull").toString()));
}
