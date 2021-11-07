package com.thefreak.botsmod.objects.blocks.pumpkins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class TinyPeponFruitGrowth extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(10.5D, 0.0D, 10.5D, 5.5D, 6, 5.5D);

    public TinyPeponFruitGrowth(Properties properties) {
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
