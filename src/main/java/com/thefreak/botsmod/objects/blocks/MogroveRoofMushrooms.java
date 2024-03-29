package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.objects.blockpackage.FallingBushBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class MogroveRoofMushrooms extends FallingBushBlock implements IGrowable {
    public static final IntegerProperty MUSHROOMS = IntegerProperty.create("mushrooms", 1, 3);
    protected static final VoxelShape ONE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape TWO_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape THREE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);


    public MogroveRoofMushrooms(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MUSHROOMS, Integer.valueOf(1)));

    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.getBlock() == this) {
            return blockstate.setValue(MUSHROOMS, Integer.valueOf(Math.min(3, blockstate.getValue(MUSHROOMS) + 1)));
        }
            return super.getStateForPlacement(context);

    }
    public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
        return useContext.getItemInHand().getItem() == this.asItem() && state.getValue(MUSHROOMS) < 3 ? true : super.canBeReplaced(state, useContext);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(MUSHROOMS)) {
            case 1:
            default:
                return ONE_SHAPE;
            case 2:
                return TWO_SHAPE;
            case 3:
                return THREE_SHAPE;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(MUSHROOMS);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}
