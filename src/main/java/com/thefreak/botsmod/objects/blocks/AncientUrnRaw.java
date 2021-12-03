package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class AncientUrnRaw extends Block {
    public static VoxelShape BASE = Block.box(5,0,5,11,12,11);
    public AncientUrnRaw(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BASE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        BlockPos down = pos.below();
        BlockPos downplus = pos.below(2);
        if (worldIn.getBlockState(down).getBlock() instanceof FireBlock || worldIn.getBlockState(downplus).getBlock() instanceof FireBlock) {
        worldIn.setBlockAndUpdate(pos, BlockInitNew.ANCIENT_POTTERY_URN.get().defaultBlockState());
        }
        super.tick(state, worldIn, pos, rand);
    }
}
