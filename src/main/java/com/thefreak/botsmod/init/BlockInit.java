package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.BotsMod.BotsItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(BotsMod.MOD_ID)
public class BlockInit {
	
	public static final Block dry_wood_log = null;
	public static final Block deep_stone = null;
	public static final Block deep_grass = null;
	public static final Block jade_ore = null;
	public static final Block dry_wood_planks = null;
	public static final Block deep_coblestone = null;
	public static final Block deep_wood_log = null;
	public static final Block deep_wood_bricks = null;
	public static final Block mud_stone = null;
	public static final Block mud_grass = null;
	public static final Block cold_deep_stone = null;
	public static final Block cold_deep_coblestone = null;
	public static final Block deep_wood_leaves = null;
	public static final Block root_wood_log = null;
	public static final Block root_wood_log_full = null;
	public static final Block root_core = null;
	public static final Block deep_wood_log_full = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new LogBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 12.0f)).setRegistryName("dry_wood_log"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10.5f, 12.0f)).setRegistryName("deep_stone"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10.5f, 12.0f)).setRegistryName("deep_grass"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(11f, 12.0f)).setRegistryName("jade_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 12.0f)).setRegistryName("dry_wood_planks"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(9.5f, 12.0f)).setRegistryName("deep_coblestone"));
		event.getRegistry().register(new LogBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 12.0f)).setRegistryName("deep_wood_log"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 12.0f)).setRegistryName("deep_wood_bricks"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(11f, 12.0f)).setRegistryName("mud_stone"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.PLANT).hardnessAndResistance(11f, 12.0f)).setRegistryName("mud_grass"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10.5f, 12.0f)).setRegistryName("cold_deep_stone"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(9.5f, 12.0f)).setRegistryName("cold_deep_coblestone"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ORGANIC).sound(SoundType.PLANT).hardnessAndResistance(9.5f, 12.0f)).setRegistryName("deep_wood_leaves"));
		event.getRegistry().register(new LogBlock(MaterialColor.BROWN, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)).setRegistryName("root_wood_log"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)).setRegistryName("root_wood_log_full"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)).setRegistryName("root_core"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)).setRegistryName("deep_wood_log_full"));





	}
	
	@SubscribeEvent
	public static void registerItemBlock(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(dry_wood_log, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("dry_wood_log"));
		event.getRegistry().register(new BlockItem(deep_stone, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_stone"));
		event.getRegistry().register(new BlockItem(deep_grass, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_grass"));
		event.getRegistry().register(new BlockItem(jade_ore, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("jade_ore"));
		event.getRegistry().register(new BlockItem(dry_wood_planks, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("dry_wood_planks"));
		event.getRegistry().register(new BlockItem(deep_coblestone, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_coblestone"));
		event.getRegistry().register(new BlockItem(deep_wood_log, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_wood_log"));
		event.getRegistry().register(new BlockItem(deep_wood_bricks, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_wood_bricks"));
		event.getRegistry().register(new BlockItem(mud_stone, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("mud_stone"));
		event.getRegistry().register(new BlockItem(mud_grass, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("mud_grass"));
		event.getRegistry().register(new BlockItem(cold_deep_stone, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("cold_deep_stone"));
		event.getRegistry().register(new BlockItem(cold_deep_coblestone, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("cold_deep_coblestone"));
		event.getRegistry().register(new BlockItem(deep_wood_leaves, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_wood_leaves"));
		event.getRegistry().register(new BlockItem(root_wood_log, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("root_wood_log"));
		event.getRegistry().register(new BlockItem(root_wood_log_full, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("root_wood_log_full"));
		event.getRegistry().register(new BlockItem(root_core, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("root_core"));
		event.getRegistry().register(new BlockItem(deep_wood_log_full, new Item.Properties().group(BotsItemGroup.instance).maxStackSize(64)).setRegistryName("deep_wood_log_full"));





	}

}
