package com.thefreak.botsmod.objects.blocks;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class DustStoneBlock extends Block {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 2.0D, 2.0D, 16.0D, 12.0D, 16.0D);
    public DustStoneBlock(Properties properties) { super(properties); }


    @MethodsReturnNonnullByDefault
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
