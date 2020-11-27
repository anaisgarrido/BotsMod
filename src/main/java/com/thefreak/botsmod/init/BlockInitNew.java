package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.blockpackage.FallingBushBlock;
import com.thefreak.botsmod.objects.blockpackage.SustainablePlantType;
import com.thefreak.botsmod.objects.blocks.*;

import com.thefreak.botsmod.util.ModdedMaterials;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.audio.Sound;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.rmi.registry.Registry;

public class BlockInitNew {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BotsMod.MOD_ID);

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

	public static final RegistryObject<Block> SULFUR_GLASS = BLOCKS.register("sulfur_glass", () -> new SulfurGlassBlock(Block.Properties.create(ModdedMaterials.SULFUR).sound(SoundType.GLASS).hardnessAndResistance(0.5F, 3F).notSolid()));

	public static final RegistryObject<Block> SULFUR_CRYSTAL = BLOCKS.register("sulfur_crystal", () -> new SulfurCrystalBlock(Block.Properties.create(ModdedMaterials.SULFUR).sound(SoundType.GLASS).hardnessAndResistance(5F,-1F).notSolid().variableOpacity()));

	public static final RegistryObject<Block> ZINC_ORE = BLOCKS.register("zinc_ore", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F, 5F)));

	public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(3F, 6F)));

	public static final RegistryObject<Block> ARCH_BRICKS = BLOCKS.register("arch_bricks", () -> new ArchBricksBlock(Block.Properties.create(ModdedMaterials.ARCH_BLOCK).hardnessAndResistance(2F, -1F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> ARCH_LAMP = BLOCKS.register("arch_lamp", () -> new Block(Block.Properties.create(ModdedMaterials.DELTA_CRYSTAL).sound(SoundType.METAL).hardnessAndResistance(2F, -1F)));

	public static final RegistryObject<Block> POLISHED_ARCH_LAMP = BLOCKS.register("polished_arch_lamp", () -> new Block(Block.Properties.create(ModdedMaterials.DELTA_CRYSTAL).sound(SoundType.METAL).hardnessAndResistance(2F, -1F)));

	public static final RegistryObject<Block> POLISHED_ARCH_BRICKS = BLOCKS.register("polished_arch_bricks", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2F, -1F)));

    public static final RegistryObject<Block> CHISELED_ARCH_BRICKS = BLOCKS.register("chiseled_arch_bricks", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2F, 100F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> SWAMP_WOOD_PLANKS = BLOCKS.register("swamp_wood_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1F, 2F)));

    public static final RegistryObject<Block> POWER_CASE_BLOCK = BLOCKS.register("power_case", () -> new PowerCaseBlock(Block.Properties.create(ModdedMaterials.DELTA_CRYSTAL)));

	public static final RegistryObject<Block> COLD_DEBRIS = BLOCKS.register("cold_debris", () -> new ColdDebris(Block.Properties.create(Material.ROCK).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).hardnessAndResistance(7F, 3F)));

	public static final RegistryObject<Block> OLD_ORE = BLOCKS.register("old_ore", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,3F)));

	public static final RegistryObject<Block> OASIUM_OAK_PLANKS = BLOCKS.register("oasium_oak_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,1F)));

	public static final RegistryObject<Block> CHISELED_OASIUM_OAK_PLANKS = BLOCKS.register("chiseled_oasium_oak_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,1F)));

    public static final RegistryObject<Block> OASIUM_OAK_LOG = BLOCKS.register("oasium_oak_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,1F)));

	public static final RegistryObject<Block> OLD_CRYSTAL_BLOCK = BLOCKS.register("old_crystal_block", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> SNAKE_CHISELED_OLD_CRYSTAL_BLOCK = BLOCKS.register("snake_chiseled_old_crystal_block", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> CHISELED_OLD_CRYSTAL_BLOCK = BLOCKS.register("chiseled_old_crystal_block", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> SMOOTH_OLD_CRYSTAL_BLOCK = BLOCKS.register("smooth_old_crystal_block", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> OLD_CRYSTAL_PILLAR = BLOCKS.register("old_crystal_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> FAINT_CHISELED_OLD_CRYSTAL_BLOCK = BLOCKS.register("faint_chiseled_old_crystal_block", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GLASS).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_ROCK = BLOCKS.register("mogrove_rock", () -> new SustainablePlantType(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> DRIPPING_MOGROVE_ROCK = BLOCKS.register("dripping_mogrove_rock", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_ROCK_NEST = BLOCKS.register("mogrove_rock_nest", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

    public static final RegistryObject<Block> MOGROVE_ROCK_NEST_NECTAR_FULL = BLOCKS.register("mogrove_rock_nest_nectar_full", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.SLIME).hardnessAndResistance(2F,4F)));

    public static final RegistryObject<Block> MOGROVE_ROCK_NEST_BUILD = BLOCKS.register("mogrove_rock_nest_build", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

    public static final RegistryObject<Block> MOGROVE_DIRT = BLOCKS.register("mogrove_dirt", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_WOOD = BLOCKS.register("mogrove_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_STRIPPED_WOOD = BLOCKS.register("mogrove_stripped_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_GRASS_BLOCK = BLOCKS.register("mogrove_grass_block", () -> new SustainablePlantType(Block.Properties.create(Material.ROCK).sound(SoundType.SLIME).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_GRASS_BLOCK_FULL = BLOCKS.register("mogrove_grass_block_full", () -> new SustainablePlantType(Block.Properties.create(Material.ORGANIC).sound(SoundType.SLIME).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_WOOD_PLANKS = BLOCKS.register("mogrove_wood_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOGROVE_MUSHROOM = BLOCKS.register("mogrove_mushroom", () -> new MogroveRoofMushrooms(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.2F, 0.3F).tickRandomly()));

    public static final RegistryObject<Block> MOGORVE_NUT_MUSHROOM = BLOCKS.register("mogrove_nut_mushroom", () -> new MogroveNutMushroom(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.2F,0.2F).notSolid().tickRandomly()));

    public static final RegistryObject<Block> MOGROVE_BUBBLE_MUSHROOM = BLOCKS.register("mogrove_bubble_mushroom", () -> new MogroveBubbleMushroom(Block.Properties.create(Material.ORGANIC).sound(SoundType.BAMBOO).hardnessAndResistance(2F,2F).notSolid().tickRandomly()));

    public static final RegistryObject<Block> SPORE_BULB = BLOCKS.register("spore_bulb", () -> new SporeBulb(Block.Properties.create(Material.ORGANIC).sound(SoundType.CORAL).hardnessAndResistance(2F,0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> SPORE_PAD = BLOCKS.register("spore_pad", () -> new SporePad(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(0.2F,0.2F).notSolid()));

	public static final RegistryObject<Block> MOGROVE_BUSH = BLOCKS.register("mogrove_bush", () -> new MogroveBush(Block.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).hardnessAndResistance(0.3F,0.3F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> RAW_ANCIENT_POTTERY_POT = BLOCKS.register("raw_ancient_pottery_pot", () -> new RawAncientPotteryPot(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(1.5F,2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_POTTERY_POT = BLOCKS.register("ancient_pottery_pot", () -> new RawAncientPotteryPot(Block.Properties.create(Material.CLAY).sound(SoundType.GLASS).hardnessAndResistance(1.5F,2F).notSolid()));

	public static final RegistryObject<Block> RAW_ANCIENT_POTTERY_URN = BLOCKS.register("raw_ancient_pottery_urn", () -> new AncientUrnRaw(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(1.5F,2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_POTTERY_URN = BLOCKS.register("ancient_pottery_urn", () -> new AncientUrnCooked(Block.Properties.create(Material.CLAY).sound(SoundType.GLASS).hardnessAndResistance(1.5F,2F).notSolid()));

	public static final RegistryObject<Block> ANCIENT_BRICKS = BLOCKS.register("ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> ANCIENT_PILLAR = BLOCKS.register("ancient_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> CRACKED_ANCIENT_BRICKS = BLOCKS.register("cracked_ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> MOSSY_ANCIENT_BRICKS = BLOCKS.register("mossy_ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> TRAPPED_ANCIENT_BRICKS = BLOCKS.register("trapped_ancient_bricks", () -> new TrappedAncientBricks(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F).tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_SMOOTH_BRICKS = BLOCKS.register("ancient_smooth_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> ANCIENT_SMOOTH_PILLAR = BLOCKS.register("ancient_smooth_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> ANCIENT_CHISELED_SMOOTH_BRICKS = BLOCKS.register("ancient_chiseled_smooth_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHUNK = BLOCKS.register("bronze_alloy_chunk", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F,5.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BRICKS = BLOCKS.register("bronze_alloy_bricks", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHISELED_BRICKS = BLOCKS.register("bronze_alloy_chiseled_bricks", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BRICKS_HORIZONTAL = BLOCKS.register("bronze_alloy_bricks_horizontal", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BLOCK = BLOCKS.register("bronze_alloy_block", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CRYSTAL = BLOCKS.register("bronze_alloy_crystal", () -> new BronzeAlloyCrystal(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F).tickRandomly()));

	public static final RegistryObject<Block> BRONZE_ALLOY_CRYSTAL_TINY = BLOCKS.register("bronze_alloy_crystal_tiny", () -> new BronzeAlloyCrystal(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F,7.5F).tickRandomly()));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHUNK_CRACKED = BLOCKS.register("bronze_alloy_chunk_cracked", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F,5.5F).tickRandomly()));

    public static final RegistryObject<Block> LAVA_ROCK_ALLOY = BLOCKS.register("lava_rock_alloy", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1.5F,0.5F)));

    public static final RegistryObject<Block> LAVA_ROCK_ALLOY_BRICKS = BLOCKS.register("lava_rock_alloy_bricks", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(2.5F,2F)));

    public static final RegistryObject<Block> LAVA_ROCK_ALLOY_PILLAR = BLOCKS.register("lava_rock_alloy_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1.5F,0.5F)));

    public static final RegistryObject<Block> COAL_LAVA_ROCK_ALLOY = BLOCKS.register("coal_lava_rock_alloy", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1.7F,0.6F).tickRandomly()));
}

