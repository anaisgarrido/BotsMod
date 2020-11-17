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

public class TrappedAncientBricks extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public TrappedAncientBricks(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canProvidePower(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        BlockPos up = pos.up();
        boolean i = state.get(POWERED);
        if (worldIn.getBlockState(up).getBlock() instanceof AncientUrnCooked) {
            worldIn.setBlockState(pos, state.with(POWERED, true), 2);
        } else {
            worldIn.setBlockState(pos, state.with(POWERED, false), 2);
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2);
        }
        super.tick(state, worldIn, pos, rand);
    }
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(POWERED) ? 15 : 0;
    }

    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return blockState.get(POWERED) ? 15 : 0;
    }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(POWERED));
    }



    @Override
    public void updateNeighbors(BlockState stateIn, IWorld worldIn, BlockPos pos, int flags) {
        worldIn.notifyNeighbors(pos, this);
        super.updateNeighbors(stateIn, worldIn, pos, flags);
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos up = currentPos.up();
        if (worldIn.getBlockState(up).getBlock() instanceof AncientUrnCooked) {
            worldIn.setBlockState(currentPos, stateIn.with(POWERED, true), 2);
        } else {
            worldIn.setBlockState(currentPos, stateIn.with(POWERED, false), 2);
            worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 2);
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
}
