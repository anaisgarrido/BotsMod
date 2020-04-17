package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.blocks.*;

import com.thefreak.botsmod.util.ModdedMaterials;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class BlockInitNew {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, BotsMod.MOD_ID);
	
	public static final RegistryObject<Block> DEEP_WOOD_CHEST = BLOCKS.register("deep_wood_chest", () -> new DeepWoodChestBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)));

	public static final RegistryObject<Block> MUD_BLOCK = BLOCKS.register("mud_block", () -> new MudBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f).speedFactor(0.2F)));

	public static final RegistryObject<Block> CHAINED_DEEP_WOOD_BRICKS = BLOCKS.register("chained_deep_wood_bricks", () -> new ChainedDeepWoodBricksBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)));

	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block", () -> new FallingBlock(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.SAND).hardnessAndResistance(1F, 2F).harvestTool(ToolType.SHOVEL)));

	public static final RegistryObject<Block> ASH_STONE = BLOCKS.register("ash_stone", () -> new Block(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.STONE).hardnessAndResistance(3F, 2F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> COMPACTED_ASH_BLOCK = BLOCKS.register("compacted_ash_block", () -> new Block(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.SAND).hardnessAndResistance(3F, 5F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> HOT_ASH_BLOCK = BLOCKS.register("hot_ash_block", () -> new MagmaBlock(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.SAND).hardnessAndResistance(2F, 15F).harvestTool(ToolType.SHOVEL)));

	public static final RegistryObject<Block> DUST_BLOCK = BLOCKS.register("dust_block", () -> new DustBlock(Block.Properties.create(ModdedMaterials.DUST).hardnessAndResistance(1.5F, 2F).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL)));

	public static final RegistryObject<Block> ASH_STONE_BRICKS = BLOCKS.register("ash_stone_bricks", () -> new Block(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.STONE).hardnessAndResistance(3F, 12F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> CHISELED_ASH_STONE_BRICKS = BLOCKS.register("chiseled_ash_stone_bricks", () -> new Block(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.STONE).hardnessAndResistance(3F, 12F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> DUST_STONE = BLOCKS.register("dust_stone", () -> new DustStoneBlock(Block.Properties.create(ModdedMaterials.DUST).sound(SoundType.STONE).hardnessAndResistance(2F,12F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> CRACKED_ASH_STONE_BRICKS = BLOCKS.register("cracked_ash_stone_bricks", () -> new Block(Block.Properties.create(ModdedMaterials.ASH).sound(SoundType.STONE).hardnessAndResistance(2F, 12F).harvestTool(ToolType.PICKAXE)));

    public static final RegistryObject<Block> SULFUR_POWDER_BLOCK = BLOCKS.register("sulfur_powder_block", () -> new Block(Block.Properties.create(ModdedMaterials.SULFUR).sound(SoundType.STONE).hardnessAndResistance(1F, 20F).harvestTool(ToolType.SHOVEL)));

	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur_block", () -> new Block(Block.Properties.create(ModdedMaterials.SULFUR).hardnessAndResistance(2F, 15F).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> SULFUR_GLASS = BLOCKS.register("sulfur_glass", () -> new Block(Block.Properties.create(ModdedMaterials.SULFUR).sound(SoundType.GLASS).hardnessAndResistance(0.5F, 3F)));


}
