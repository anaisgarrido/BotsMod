package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class SporianMangroveTreeLog extends RotatedPillarBlock {
    public SporianMangroveTreeLog(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack HeldItemIn = player.getHeldItem(handIn);
        if (HeldItemIn.getItem() instanceof AxeItem  ) {
        worldIn.setBlockState(pos, BlockInitNew.STRIPPED_SPORIAN_MANGROVE_TREE_LOG.get().getDefaultState());
        worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1F, 1F);
        spawnAsEntity(worldIn,pos, new ItemStack(ItemInitNew.SPORIAN_MANGROVE_TREE_BARK.get(), 1));
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
