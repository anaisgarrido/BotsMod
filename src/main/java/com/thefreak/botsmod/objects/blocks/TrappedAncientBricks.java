package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class TrappedAncientBricks extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public TrappedAncientBricks(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        BlockPos up = pos.above();
        boolean i = state.getValue(POWERED);
        if (worldIn.getBlockState(up).getBlock() instanceof AncientUrnCooked) {
            worldIn.setBlock(pos, state.setValue(POWERED, true), 2);
        } else {
            worldIn.setBlock(pos, state.setValue(POWERED, false), 2);
            worldIn.getBlockTicks().scheduleTick(pos, this, 2);
        }
        super.tick(state, worldIn, pos, rand);
    }

    protected void updateNeighborsInFront(World worldIn, BlockPos pos, BlockState state) {
        worldIn.neighborChanged(pos, this, pos);
    }

    @Override
    public void updateIndirectNeighbourShapes(BlockState state, IWorld worldIn, BlockPos pos, int flags, int recursionLeft) {
        super.updateIndirectNeighbourShapes(state, worldIn, pos, flags, recursionLeft);
    }

    public int getSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(POWERED) ? 15 : 0;
    }

    public int getDirectSignal(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(POWERED) ? 15 : 0;
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(POWERED));
    }



    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos up = currentPos.above();
        if (worldIn.getBlockState(up).getBlock() instanceof AncientUrnCooked) {
            worldIn.setBlock(currentPos, stateIn.setValue(POWERED, true), 2);
        } else {
            worldIn.setBlock(currentPos, stateIn.setValue(POWERED, false), 2);
            worldIn.getBlockTicks().scheduleTick(currentPos, this, 2);
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
