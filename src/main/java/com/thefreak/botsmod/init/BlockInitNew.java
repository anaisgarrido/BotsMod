package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.blocks.ChainedDeepWoodBricksBlock;
import com.thefreak.botsmod.objects.blocks.DeepWoodChestBlock;
import com.thefreak.botsmod.objects.blocks.MudBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInitNew {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, BotsMod.MOD_ID);
	
	public static final RegistryObject<Block> DEEP_WOOD_CHEST = BLOCKS.register("deep_wood_chest", () -> new DeepWoodChestBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)));

	public static final RegistryObject<Block> MUD_BLOCK = BLOCKS.register("mud_block", () -> new MudBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f).speedFactor(0.2F)));

	public static final RegistryObject<Block> CHAINED_DEEP_WOOD_BRICKS = BLOCKS.register("chained_deep_wood_bricks", () -> new ChainedDeepWoodBricksBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(4f, 12.0f)));

}
