package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;

import com.thefreak.botsmod.tileentity.PowerCaseTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
			ForgeRegistries.TILE_ENTITIES, BotsMod.MOD_ID);
			



	public static final RegistryObject<TileEntityType<PowerCaseTileEntity>> POWER_CASE_BLOCK = TILE_ENTITY_TYPES.register("power_case", () -> TileEntityType.Builder.create(PowerCaseTileEntity::new, BlockInitNew.POWER_CASE_BLOCK.get()).build(null));
}

