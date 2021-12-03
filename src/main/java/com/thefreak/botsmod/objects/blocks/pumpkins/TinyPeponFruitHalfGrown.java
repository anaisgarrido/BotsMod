package com.thefreak.botsmod.objects.blocks.pumpkins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import net.minecraft.block.AbstractBlock.Properties;

public class TinyPeponFruitHalfGrown extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.box(12.0D, 0.0D, 12.0D, 4.0D, 9, 4.0D);

    public TinyPeponFruitHalfGrown(Properties properties) {
        super(properties);

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return true;
    }

}
