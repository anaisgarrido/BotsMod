package com.thefreak.botsmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import net.minecraft.block.AbstractBlock.Properties;

public class BronzeAlloyCrystal extends DirectionalBlock {
    protected static final VoxelShape SHAPE_VERTICAL = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 22.0D, 12.0D);
    protected static final VoxelShape SHAPE1 = Block.box(4.0D, 4.0D, 0.0D, 12.0D, 12.0D, 16.0D);
    protected static final VoxelShape SHAPE2 = Block.box(0.0D, 4.0D, 4.0D, 16.0D, 12.0D, 12.0D);

    public BronzeAlloyCrystal(Properties properties) {
        super(properties);
    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(FACING).getAxis()) {
            case X:
            default:
                return SHAPE2;
            case Z:
                return SHAPE1;
            case Y:
                return SHAPE_VERTICAL;
        }
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getClickedFace();
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
        return blockstate.getBlock() == this && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()) : this.defaultBlockState().setValue(FACING, direction);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
