package com.thefreak.botsmod.objects.blocks.pumpkins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class TinyPeponFruit extends FallingBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(13.0D, 0.0D, 13.0D, 3.0D, 13, 3.0D);

    public TinyPeponFruit(Properties properties) {
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
