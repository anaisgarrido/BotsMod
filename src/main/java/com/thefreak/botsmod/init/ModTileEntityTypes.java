package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.tileentity.DeepWoodChestTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, BotsMod.MOD_ID);
			

	
	public static final RegistryObject<TileEntityType<DeepWoodChestTileEntity>> DEEP_WOOD_CHEST = TILE_ENTITY_TYPES.register(
			"deep_wood_chest", () -> TileEntityType.Builder.create(
					DeepWoodChestTileEntity::new, BlockInitNew.DEEP_WOOD_CHEST.get()).build(null));
}
