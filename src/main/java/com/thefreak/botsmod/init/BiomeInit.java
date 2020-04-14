package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.world.biomes.JadeCaveBiome;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, BotsMod.MOD_ID);
	
	public static final RegistryObject<Biome> JADE_CAVE_BIOME = BIOMES.register("jade_cave_biome", () -> new JadeCaveBiome(null));
}
