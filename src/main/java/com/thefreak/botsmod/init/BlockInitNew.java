package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.blockpackage.ConnectedTexturePillar;
import com.thefreak.botsmod.objects.blockpackage.ConnectedWoodBeam;
import com.thefreak.botsmod.objects.blockpackage.HeatBlock;
import com.thefreak.botsmod.objects.blockpackage.SustainablePlantType;
import com.thefreak.botsmod.objects.blocks.*;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;


public class BlockInitNew {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BotsMod.MOD_ID);

	public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.STONE).hardnessAndResistance(3F, 6F)));

	public static final RegistryObject<Block> MOGROVE_ROCK = BLOCKS.register("mogrove_rock", () -> new SustainablePlantType(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> DRIPPING_MOGROVE_ROCK = BLOCKS.register("dripping_mogrove_rock", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_ROCK_NEST = BLOCKS.register("mogrove_rock_nest", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_ROCK_NEST_NECTAR_FULL = BLOCKS.register("mogrove_rock_nest_nectar_full", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.SLIME).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_ROCK_NEST_BUILD = BLOCKS.register("mogrove_rock_nest_build", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_DIRT = BLOCKS.register("mogrove_dirt", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_WOOD = BLOCKS.register("mogrove_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_STRIPPED_WOOD = BLOCKS.register("mogrove_stripped_wood", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_GRASS_BLOCK = BLOCKS.register("mogrove_grass_block", () -> new SustainablePlantType(Block.Properties.create(Material.ROCK).sound(SoundType.SLIME).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_GRASS_BLOCK_FULL = BLOCKS.register("mogrove_grass_block_full", () -> new SustainablePlantType(Block.Properties.create(Material.ORGANIC).sound(SoundType.SLIME).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_WOOD_PLANKS = BLOCKS.register("mogrove_wood_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOGROVE_MUSHROOM = BLOCKS.register("mogrove_mushroom", () -> new MogroveRoofMushrooms(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.2F, 0.3F).tickRandomly()));

	public static final RegistryObject<Block> MOGORVE_NUT_MUSHROOM = BLOCKS.register("mogrove_nut_mushroom", () -> new MogroveNutMushroom(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(0.2F, 0.2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> MOGROVE_BUBBLE_MUSHROOM = BLOCKS.register("mogrove_bubble_mushroom", () -> new MogroveBubbleMushroom(Block.Properties.create(Material.ORGANIC).sound(SoundType.BAMBOO).hardnessAndResistance(2F, 2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> SPORE_BULB = BLOCKS.register("spore_bulb", () -> new SporeBulb(Block.Properties.create(Material.ORGANIC).sound(SoundType.CORAL).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> SPORE_PAD = BLOCKS.register("spore_pad", () -> new SporePad(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(0.2F, 0.2F).notSolid()));

	public static final RegistryObject<Block> MOGROVE_BUSH = BLOCKS.register("mogrove_bush", () -> new MogroveBush(Block.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).hardnessAndResistance(0.3F, 0.3F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> RAW_ANCIENT_POTTERY_POT = BLOCKS.register("raw_ancient_pottery_pot", () -> new RawAncientPotteryPot(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_POTTERY_POT = BLOCKS.register("ancient_pottery_pot", () -> new RawAncientPotteryPot(Block.Properties.create(Material.CLAY).sound(SoundType.GLASS).hardnessAndResistance(1.5F, 2F).notSolid()));

	public static final RegistryObject<Block> RAW_ANCIENT_POTTERY_URN = BLOCKS.register("raw_ancient_pottery_urn", () -> new AncientUrnRaw(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_POTTERY_URN = BLOCKS.register("ancient_pottery_urn", () -> new AncientUrnCooked(Block.Properties.create(Material.CLAY).sound(SoundType.GLASS).hardnessAndResistance(1.5F, 2F).notSolid()));

	public static final RegistryObject<Block> ANCIENT_BRICKS = BLOCKS.register("ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> ANCIENT_PILLAR = BLOCKS.register("ancient_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> CRACKED_ANCIENT_BRICKS = BLOCKS.register("cracked_ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> MOSSY_ANCIENT_BRICKS = BLOCKS.register("mossy_ancient_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> TRAPPED_ANCIENT_BRICKS = BLOCKS.register("trapped_ancient_bricks", () -> new TrappedAncientBricks(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F).tickRandomly()));

	public static final RegistryObject<Block> ANCIENT_SMOOTH_BRICKS = BLOCKS.register("ancient_smooth_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> ANCIENT_SMOOTH_PILLAR = BLOCKS.register("ancient_smooth_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> ANCIENT_CHISELED_SMOOTH_BRICKS = BLOCKS.register("ancient_chiseled_smooth_bricks", () -> new Block(Block.Properties.create(Material.CLAY).sound(SoundType.STONE).hardnessAndResistance(2F, 4F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHUNK = BLOCKS.register("bronze_alloy_chunk", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F, 5.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BRICKS = BLOCKS.register("bronze_alloy_bricks", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F, 7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHISELED_BRICKS = BLOCKS.register("bronze_alloy_chiseled_bricks", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F, 7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BRICKS_HORIZONTAL = BLOCKS.register("bronze_alloy_bricks_horizontal", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F, 7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_BLOCK = BLOCKS.register("bronze_alloy_block", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F, 7.5F)));

	public static final RegistryObject<Block> BRONZE_ALLOY_CRYSTAL = BLOCKS.register("bronze_alloy_crystal", () -> new BronzeAlloyCrystal(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(4.5F, 7.5F).tickRandomly()));

	public static final RegistryObject<Block> BRONZE_ALLOY_CHUNK_CRACKED = BLOCKS.register("bronze_alloy_chunk_cracked", () -> new Block(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F, 5.5F).tickRandomly()));

	public static final RegistryObject<Block> LAVA_ROCK_ALLOY = BLOCKS.register("lava_rock_alloy", () -> new LavaRockAlloy(Block.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.5F, 0.5F)));

	public static final RegistryObject<Block> LAVA_ROCK_ALLOY_BRICKS = BLOCKS.register("lava_rock_alloy_bricks", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(2.5F, 2F)));

	public static final RegistryObject<Block> LAVA_ROCK_ALLOY_PILLAR = BLOCKS.register("lava_rock_alloy_pillar", () -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.5F, 0.5F)));

	public static final RegistryObject<Block> COAL_LAVA_ROCK_ALLOY = BLOCKS.register("coal_lava_rock_alloy", () -> new CoalLavaRockAlloy(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> POLISHED_LAVA_ROCK_ALLOY = BLOCKS.register("polished_lava_rock_alloy", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> CHISELED_LAVA_ROCK_ALLOY = BLOCKS.register("chiseled_lava_rock_alloy", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> CHISELED_LAVA_ROCK_ALLOY_BRICKS = BLOCKS.register("chiseled_lava_rock_alloy_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F)));

	public static final RegistryObject<Block> CHISELED_POLISHED_LAVA_ROCK_ALLOY = BLOCKS.register("chiseled_polished_lava_rock_alloy", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F)));

	public static final RegistryObject<Block> POLISHED_LAVA_ROCK_ALLOY_PILLAR = BLOCKS.register("polished_lava_rock_alloy_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F)));

	public static final RegistryObject<Block> LAVA_ROCK_ALLOY_DIRT = BLOCKS.register("lava_rock_alloy_dirt", () -> new LavaRockAlloyDirt(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.SAND).hardnessAndResistance(1F, 0.6F)));

	public static final RegistryObject<Block> COAL_LAVA_ROCK_ALLOY_DIRT = BLOCKS.register("coal_lava_rock_alloy_dirt", () -> new CoalLavaRockAlloyDirt(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.SAND).hardnessAndResistance(1F, 0.6F)));

	public static final RegistryObject<Block> COAL_LAVA_ROCK_ALLOY_PILLAR = BLOCKS.register("coal_lava_rock_alloy_pillar", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1F, 0.6F)));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_LOG = BLOCKS.register("sporian_mangrove_tree_log", () -> new SporianMangroveTreeLog(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F)));

	public static final RegistryObject<Block> STRIPPED_SPORIAN_MANGROVE_TREE_LOG = BLOCKS.register("stripped_sporian_mangrove_tree_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F)));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_PLANKS = BLOCKS.register("sporian_mangrove_tree_planks", () -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_SPIKY_LONGUS = BLOCKS.register("sporian_spiky_longus", () -> new SporianSpikyLongusTop(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0F, 0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_SPIKY_LONGUS_PLANT = BLOCKS.register("sporian_spiky_longus_plant", () -> new SporianSpikyLongusPlant(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0F, 0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_DANDELION = BLOCKS.register("sporian_dandelion", () -> new SporianDandelion(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0F, 0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MOSS_GRASS = BLOCKS.register("sporian_moss_grass", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_BULB = BLOCKS.register("sporian_mangrove_bulb", () -> new SporianMangroveBulb(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BASALT).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_ROOT = BLOCKS.register("sporian_mangrove_tree_root", () -> new SporianMangroveTreeRoot(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_ROOT_TOP = BLOCKS.register("sporian_mangrove_tree_root_top", () -> new SporianMangroveTreeRootTop(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.7F, 0.6F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_VINES_TOP = BLOCKS.register("sporian_mangrove_tree_vines_top", () -> new SporianMangroveTreeVinesTop(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0F, 0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_VINES = BLOCKS.register("sporian_mangrove_tree_vines", () -> new SporianMangroveTreeVines(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).doesNotBlockMovement().hardnessAndResistance(0F, 0F).tickRandomly()));

	public static final RegistryObject<Block> SPORIAN_MANGROVE_TREE_LEAVES = BLOCKS.register("sporian_mangrove_tree_leaves", () -> new SporianMangroveTreeLeaves(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(1.0F, 1.0F)));

	public static final RegistryObject<Block> WET_MUD_BLOCK1 = BLOCKS.register("wet_mud_block1", () -> new Block(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> WET_MUD_BLOCK2 = BLOCKS.register("wet_mud_block2", () -> new Block(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> WET_MUD_BLOCK2_GLIDED = BLOCKS.register("wet_mud_block2_glided", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> WET_MUD_BLOCK2_BRICKS = BLOCKS.register("wet_mud_block2_bricks", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> CHISELED_WET_MUD_BLOCK2 = BLOCKS.register("chiseled_wet_mud_block2", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> POLISHED_WET_MUD_BLOCK2 = BLOCKS.register("polished_wet_mud_block2", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> DOUBLED_WET_MUD_BLOCK2 = BLOCKS.register("doubled_wet_mud_block2", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> WET_MUD_BLOCK2_PILLAR = BLOCKS.register("wet_mud_block2_pillar", () -> new ConnectedTexturePillar(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> DRY_MUD_BLOCK1 = BLOCKS.register("dry_mud_block1", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> DRY_MUD_BLOCK1_GLIDED = BLOCKS.register("dry_mud_block1_glided", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> CHISELED_DRY_MUD_BLOCK1 = BLOCKS.register("chiseled_dry_mud_block1", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> DRY_MUD_BLOCK1_BRICKS = BLOCKS.register("dry_mud_block1_bricks", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> DRY_MUD_BLOCK1_TILE = BLOCKS.register("dry_mud_block1_tile", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> FRAMED_DRY_MUD_BLOCK1_TILE = BLOCKS.register("framed_dry_mud_block1_tile", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> POLISHED_DRY_MUD_BLOCK1_TILE = BLOCKS.register("polished_dry_mud_block1_tile", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> CHISELED_DRY_MUD_BLOCK1_TILE = BLOCKS.register("chiseled_dry_mud_block1_tile", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

			public static final RegistryObject<Block> DRY_MUD_BLOCK1_PILLAR = BLOCKS.register("dry_mud_block1_pillar", () -> new ConnectedTexturePillar(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> DRY_MUD_BLOCK2 = BLOCKS.register("dry_mud_block2", () -> new Block(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> DRY_MUD_BLOCK3 = BLOCKS.register("dry_mud_block3", () -> new Block(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> DRY_MUD_BLOCK4 = BLOCKS.register("dry_mud_block4", () -> new Block(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(4f, 1.0f)));

	public static final RegistryObject<Block> MUD_REED = BLOCKS.register("mud_reed", () -> new MudReeds(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.BAMBOO).hardnessAndResistance(2F, 1F).tickRandomly()));

    public static final RegistryObject<Block> MUD_REED_LEAVES = BLOCKS.register("mud_reed_leaves", () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).hardnessAndResistance(0.5F, 0F).notSolid()));

    public static final RegistryObject<Block> MUD_REED_PLANKS = BLOCKS.register("mud_reed_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F, 1F).notSolid()));

	public static final RegistryObject<Block> MUD_REED_PLANKS_SLAB = BLOCKS.register("mud_reed_slab", () -> new SlabBlock(AbstractBlock.Properties.from(MUD_REED_PLANKS.get())));

	public static final RegistryObject<Block> MUD_REED_PLANKS_STAIRS = BLOCKS.register("mud_reed_stairs", () -> new StairsBlock(MUD_REED_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(MUD_REED_PLANKS.get())));

	public static final RegistryObject<Block> MUD_REED_DOOR = BLOCKS.register("mud_reed_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F, 1F).notSolid()));

	public static final RegistryObject<Block> MUD_REED_TRAPDOOR = BLOCKS.register("mud_reed_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F, 1F).notSolid()));

	public static final RegistryObject<Block> MUD_REED_EMPTY_BOOKSHELF = BLOCKS.register("mud_reed_empty_bookshelf", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F, 1F).notSolid()));

	public static final RegistryObject<Block> MUD_REED_BOOKSHELF = BLOCKS.register("mud_reed_bookshelf", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.5F, 1F).notSolid()));

	public static final RegistryObject<Block> CATTAIL = BLOCKS.register("cattail", () -> new Cattail(AbstractBlock.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0F, 0F).notSolid().doesNotBlockMovement()));

	public static final RegistryObject<Block> SPROUTED_MUD = BLOCKS.register("sprouted_mud", () -> new SproutedMud(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> LONG_SPROUTED_MUD = BLOCKS.register("long_sprouted_mud", () -> new LongSproutedMud(AbstractBlock.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> TRUFFLE_BLOCK = BLOCKS.register("truffle_block", () -> new Truffle(AbstractBlock.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.25F, 0F).notSolid()));

	public static final RegistryObject<Block> TUBER_CROP = BLOCKS.register("tuber_crop", () -> new TuberCrop(AbstractBlock.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.25F, 0F).notSolid().doesNotBlockMovement().tickRandomly()));

	public static final RegistryObject<Block> TUBER_BUSH = BLOCKS.register("tuber_bush", () -> new TuberBush(AbstractBlock.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.25F, 0F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> TUBER_LOG = BLOCKS.register("tuber_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> STRIPPED_TUBER_LOG = BLOCKS.register("stripped_tuber_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> TUBER_PLANKS = BLOCKS.register("tuber_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2F, 0.5F).notSolid().tickRandomly()));

	public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> LIMESTONE_SLAB = BLOCKS.register("limestone_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

	public static final RegistryObject<Block> LIMESTONE_STAIRS = BLOCKS.register("limestone_stairs", () -> new StairsBlock(LIMESTONE.get().getDefaultState(), AbstractBlock.Properties.from(LIMESTONE.get())));


	public static final RegistryObject<Block> LIMESTONE_BRICKS = BLOCKS.register("limestone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> LIMESTONE_BRICKS_SLAB = BLOCKS.register("limestone_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

	public static final RegistryObject<Block> LIMESTONE_BRICKS_STAIRS = BLOCKS.register("limestone_bricks_stairs", () -> new StairsBlock(LIMESTONE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(LIMESTONE_BRICKS.get())));


	public static final RegistryObject<Block> LIMESTONE_PILLAR = BLOCKS.register("limestone_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> COBBLED_LIMESTONE = BLOCKS.register("cobbled_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> LIMESTONE_TILES = BLOCKS.register("limestone_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> POLISHED_LIMESTONE = BLOCKS.register("polished_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

    public static final RegistryObject<Block> SMOOTH_LIMESTONE = BLOCKS.register("smooth_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 6.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE = BLOCKS.register("slightly_weathered_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

    public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE_SLAB = BLOCKS.register("slightly_weathered_limestone_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESTONE_STAIRS = BLOCKS.register("slightly_weathered_limestone_stairs", () -> new StairsBlock(SLIGHTLY_WEATHERED_LIMESOTNE.get().getDefaultState(), AbstractBlock.Properties.from(SLIGHTLY_WEATHERED_LIMESOTNE.get())));


	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE_BRICKS = BLOCKS.register("slightly_weathered_limestone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

    public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE_BRICKS_SLAB = BLOCKS.register("slightly_weathered_limestone_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESTONE_BRICKS_STAIRS = BLOCKS.register("slightly_weathered_limestone_bricks_stairs", () -> new StairsBlock(SLIGHTLY_WEATHERED_LIMESOTNE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(SLIGHTLY_WEATHERED_LIMESOTNE_BRICKS.get())));


	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE_TILES = BLOCKS.register("slightly_weathered_limestone_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_SMOOTH_LIMESOTNE = BLOCKS.register("slightly_weathered_smooth_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_POLISHED_LIMESOTNE = BLOCKS.register("slightly_weathered_polished_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_COBBLED_LIMESOTNE = BLOCKS.register("slightly_weathered_cobbled_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> SLIGHTLY_WEATHERED_LIMESOTNE_PILLAR = BLOCKS.register("slightly_weathered_limestone_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 4.0F)));

	public static final RegistryObject<Block> WEATHERED_LIMESOTNE = BLOCKS.register("weathered_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

    public static final RegistryObject<Block> WEATHERED_LIMESOTNE_SLAB = BLOCKS.register("weathered_limestone_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_LIMESTONE_STAIRS = BLOCKS.register("weathered_limestone_stairs", () -> new StairsBlock(WEATHERED_LIMESOTNE.get().getDefaultState(), AbstractBlock.Properties.from(WEATHERED_LIMESOTNE.get())));


	public static final RegistryObject<Block> WEATHERED_LIMESOTNE_BRICKS = BLOCKS.register("weathered_limestone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

    public static final RegistryObject<Block> WEATHERED_LIMESOTNE_BRICKS_SLAB = BLOCKS.register("weathered_limestone_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_LIMESTONE_BRICKS_STAIRS = BLOCKS.register("weathered_limestone_bricks_stairs", () -> new StairsBlock(WEATHERED_LIMESOTNE_BRICKS.get().getDefaultState(), AbstractBlock.Properties.from(WEATHERED_LIMESOTNE_BRICKS.get())));


	public static final RegistryObject<Block> WEATHERED_LIMESOTNE_TILES = BLOCKS.register("weathered_limestone_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_SMOOTH_LIMESOTNE = BLOCKS.register("weathered_smooth_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_POLISHED_LIMESOTNE = BLOCKS.register("weathered_polished_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_COBBLED_LIMESOTNE = BLOCKS.register("weathered_cobbled_limestone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> WEATHERED_LIMESOTNE_PILLAR = BLOCKS.register("weathered_limestone_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5F, 2.0F)));

	public static final RegistryObject<Block> MOLDENWOOD_LOG = BLOCKS.register("moldenwood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> MOLDENWOOD_PLANKS = BLOCKS.register("moldenwood_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> MOLDENWOOD_SLAB = BLOCKS.register("moldenwood_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> MOLDENWOOD_STAIRS = BLOCKS.register("moldenwood_stairs", () -> new StairsBlock(MOLDENWOOD_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(MOLDENWOOD_PLANKS.get())));

    public static final RegistryObject<Block> MOLDENWOOD_BEAM = BLOCKS.register("moldenwood_beam", () -> new ConnectedWoodBeam(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F).notSolid()));

	public static final RegistryObject<Block> MOLDENWOOD_DOOR = BLOCKS.register("moldenwood_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2F).notSolid()));

	public static final RegistryObject<Block> MOLDENWOOD_TRAPDOOR = BLOCKS.register("moldenwood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2F).notSolid()));

	public static final RegistryObject<Block> STRIPPED_MOLDENWOOD_LOG = BLOCKS.register("stripped_moldenwood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> DARK_PEGMATITE_STONE = BLOCKS.register("dark_pegmatite_stone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> DARK_PEGMATITE_STONE_BRICKS = BLOCKS.register("dark_pegmatite_stone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> DARK_PEGMATITE_STONE_TILES = BLOCKS.register("dark_pegmatite_stone_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> DARK_PEGMATITE_STONE_VERTICAL_BRICKS = BLOCKS.register("dark_pegmatite_stone_vertical_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> DARK_PEGMATITE_STONE_PILLAR = BLOCKS.register("dark_pegmatite_stone_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2F,4F)));

	public static final RegistryObject<Block> CHALK_ORE = BLOCKS.register("chalk_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.5F,1F)));

	public static final RegistryObject<Block> CHALK_BLOCK = BLOCKS.register("chalk_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.BONE).hardnessAndResistance(1F,1F)));

	public static final RegistryObject<Block> GOLD_BRICKS = BLOCKS.register("gold_bricks", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> GOLD_BRICKS_SLAB = BLOCKS.register("gold_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> POLISHED_GOLD_BLOCK = BLOCKS.register("polished_gold_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> CHISELED_GOLD_BLOCK = BLOCKS.register("chiseled_gold_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> GOLD_PILLAR = BLOCKS.register("gold_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GOLD).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.METAL)));

	public static final RegistryObject<Block> BRIMSTONE = BLOCKS.register("brimstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SLIGHTLY_RUSTED_BRIMSTONE = BLOCKS.register("slightly_rusted_brimstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> RUSTED_BRIMSTONE = BLOCKS.register("rusted_brimstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SULFURIC_DIRT = BLOCKS.register("sulfuric_dirt", () -> new Block(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> EMPTY_SULFURIC_DIRT = BLOCKS.register("empty_sulfuric_dirt", () -> new Block(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> SULFUR_ORE = BLOCKS.register("sulfur_ore", () -> new Block(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> BRIMSTONE_BRICKS = BLOCKS.register("brimstone_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> POLISHED_BRIMSTONE = BLOCKS.register("polished_brimstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CHISELED_BRIMSTONE = BLOCKS.register("chiseled_brimstone", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BRIMSTONE_PILLAR = BLOCKS.register("brimstone_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BRIMSTONE_STAIRS = BLOCKS.register("brimstone_stairs", () -> new StairsBlock(BRIMSTONE.get().getDefaultState(), AbstractBlock.Properties.from(BRIMSTONE.get())));

	public static final RegistryObject<Block> BRIMSTONE_SLAB = BLOCKS.register("brimstone_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BRIMSTONE_BRICKS_STAIRS = BLOCKS.register("brimstone_bricks_stairs", () -> new StairsBlock(BRIMSTONE.get().getDefaultState(), AbstractBlock.Properties.from(BRIMSTONE.get())));

	public static final RegistryObject<Block> BRIMSTONE_BRICKS_SLAB = BLOCKS.register("brimstone_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE = BLOCKS.register("blue_slate", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_SLAB = BLOCKS.register("blue_slate_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_STAIRS = BLOCKS.register("blue_slate_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> BLUE_SLATE_BRICKS = BLOCKS.register("blue_slate_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_BRICKS_SLAB = BLOCKS.register("blue_slate_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_BRICKS_STAIRS = BLOCKS.register("blue_slate_bricks_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_BRICKS = BLOCKS.register("slightly_dirty_blue_slate_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_BRICKS_SLAB = BLOCKS.register("slightly_dirty_blue_slate_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_BRICKS_STAIRS = BLOCKS.register("slightly_dirty_blue_slate_bricks_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_BRICKS = BLOCKS.register("dirty_blue_slate_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_BRICKS_SLAB = BLOCKS.register("dirty_blue_slate_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_BRICKS_STAIRS = BLOCKS.register("dirty_blue_slate_bricks_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> CHISELED_BLUE_SLATE = BLOCKS.register("chiseled_blue_slate", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> POLISHED_BLUE_SLATE = BLOCKS.register("polished_blue_slate", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_TILES = BLOCKS.register("blue_slate_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_TILES_SLAB = BLOCKS.register("blue_slate_tiles_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLUE_SLATE_TILES_STAIRS = BLOCKS.register("blue_slate_tiles_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_TILES = BLOCKS.register("slightly_dirty_blue_slate_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_TILES_SLAB = BLOCKS.register("slightly_dirty_blue_slate_tiles_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SLIGHTLY_DIRTY_BLUE_SLATE_TILES_STAIRS = BLOCKS.register("slightly_dirty_blue_slate_tiles_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_TILES = BLOCKS.register("dirty_blue_slate_tiles", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_TILES_SLAB = BLOCKS.register("dirty_blue_slate_tiles_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> DIRTY_BLUE_SLATE_TILES_STAIRS = BLOCKS.register("dirty_blue_slate_tiles_stairs", () -> new StairsBlock(BLUE_SLATE.get().getDefaultState(), AbstractBlock.Properties.from(BLUE_SLATE.get())));

	public static final RegistryObject<Block> BLUE_SLATE_PILLAR = BLOCKS.register("blue_slate_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));


    public static final RegistryObject<Block> SHALE_ROCK = BLOCKS.register("shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SHALE_ROCK_SLAB = BLOCKS.register("shale_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SHALE_ROCK_STAIRS = BLOCKS.register("shale_rock_stairs", () -> new StairsBlock(SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(SHALE_ROCK.get())));

	public static final RegistryObject<Block> COBBLED_SHALE_ROCK = BLOCKS.register("cobbled_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBBLED_SHALE_ROCK_SLAB = BLOCKS.register("cobbled_shale_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBBLED_SHALE_ROCK_STAIRS = BLOCKS.register("cobbled_shale_rock_stairs", () -> new StairsBlock(SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(SHALE_ROCK.get())));

    public static final RegistryObject<Block> SHALE_ROCK_BRICKS = BLOCKS.register("shale_rock_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SHALE_ROCK_BRICKS_SLAB = BLOCKS.register("shale_rock_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SHALE_ROCK_BRICKS_STAIRS = BLOCKS.register("shale_rock_bricks_stairs", () -> new StairsBlock(SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(SHALE_ROCK.get())));

    public static final RegistryObject<Block> POLISHED_SHALE_ROCK = BLOCKS.register("polished_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> CHISELED_SHALE_ROCK = BLOCKS.register("chiseled_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SHALE_ROCK_PILLAR = BLOCKS.register("shale_rock_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));


	public static final RegistryObject<Block> OILY_SHALE_ROCK = BLOCKS.register("oily_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_SLAB = BLOCKS.register("oily_shale_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_STAIRS = BLOCKS.register("oily_shale_rock_stairs", () -> new StairsBlock(OILY_SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(OILY_SHALE_ROCK.get())));

	public static final RegistryObject<Block> COBBLED_OILY_SHALE_ROCK = BLOCKS.register("cobbled_oily_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBBLED_OILY_SHALE_ROCK_SLAB = BLOCKS.register("cobbled_oily_shale_rock_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBBLED_OILY_SHALE_ROCK_STAIRS = BLOCKS.register("cobbled_oily_shale_rock_stairs", () -> new StairsBlock(OILY_SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(OILY_SHALE_ROCK.get())));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_BRICKS = BLOCKS.register("oily_shale_rock_bricks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_BRICKS_SLAB = BLOCKS.register("oily_shale_rock_bricks_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_BRICKS_STAIRS = BLOCKS.register("oily_shale_rock_bricks_stairs", () -> new StairsBlock(OILY_SHALE_ROCK.get().getDefaultState(), AbstractBlock.Properties.from(OILY_SHALE_ROCK.get())));

	public static final RegistryObject<Block> POLISHED_OILY_SHALE_ROCK = BLOCKS.register("polished_oily_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CHISELED_OILY_SHALE_ROCK = BLOCKS.register("chiseled_oily_shale_rock", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> OILY_SHALE_ROCK_PILLAR = BLOCKS.register("oily_shale_rock_pillar", () -> new ConnectedTexturePillar(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));


	public static final RegistryObject<Block> AUTUMN_TREE_LOG = BLOCKS.register("autumn_tree_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> STRIPPED_AUTUMN_TREE_LOG = BLOCKS.register("stripped_autumn_tree_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 2.0F)));

	public static final RegistryObject<Block> AUTUMN_TREE_PLANKS = BLOCKS.register("autumn_tree_planks", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> AUTUMN_TREE_LEAVES = BLOCKS.register("autumn_tree_leaves", () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).hardnessAndResistance(0.5F, 0F).notSolid()));

	public static final RegistryObject<Block> DEAD_AUTUMN_GRASS_BLOCK = BLOCKS.register("dead_autumn_grass_block", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.BROWN_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> BROWN_OCHER_DIRT = BLOCKS.register("brown_ocher_dirt", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> ROOTED_BROWN_OCHER_DIRT = BLOCKS.register("rooted_brown_ocher_dirt", () -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.ORANGE_TERRACOTTA).setRequiresTool().hardnessAndResistance(3.0F, 6.0F).sound(SoundType.GROUND)));


}
