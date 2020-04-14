package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.world.dimension.BotsModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {

	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, BotsMod.MOD_ID);
	
	public static final RegistryObject<ModDimension> BOTSMOD_DIM = MOD_DIMENSIONS.register("botsmod_dim", () -> new BotsModDimension());
	
}
