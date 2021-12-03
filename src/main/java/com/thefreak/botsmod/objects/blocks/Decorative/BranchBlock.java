package com.thefreak.botsmod.objects.blocks.Decorative;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BranchBlock extends DirectionalBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape Y_AXIS_AABB = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.5D, 13.0D, 3.0D, 9.5D, 16D, 16.0D);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 13.0D, 6.5D, 13.0D, 16D, 9.5D);

    protected static final VoxelShape Z_AXIS_AABB_MIRROR = Block.box(6.5D, 16.0D, 0D, 9.5D, 13D, 13.0D);
    protected static final VoxelShape X_AXIS_AABB_MIRROR = Block.box(3D, 16.0D, 6.5D, 16.0D, 13D, 9.5D);


    public BranchBlock(Properties p_i48415_1_) {
        super(p_i48415_1_);
    }
    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING))).setValue(WATERLOGGED, Boolean.valueOf(false));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.setValue(FACING, p_185471_2_.mirror(p_185471_1_.getValue(FACING))).setValue(WATERLOGGED, Boolean.valueOf(false));
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch(p_220053_1_.getValue(FACING)) {
            case EAST:
            default:
                return X_AXIS_AABB;
            case WEST:
                return X_AXIS_AABB_MIRROR;
            case NORTH:
                return Z_AXIS_AABB;
            case SOUTH:
                return Z_AXIS_AABB_MIRROR;
            case UP:
                return Y_AXIS_AABB;
            case DOWN:
                return Y_AXIS_AABB;
        }
    }
    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        FluidState fluidstate = p_196258_1_.getLevel().getFluidState(p_196258_1_.getClickedPos());
        Direction direction = p_196258_1_.getClickedFace();
        BlockState blockstate = p_196258_1_.getLevel().getBlockState(p_196258_1_.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER)) : this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING, WATERLOGGED);
    }

    public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
        return PushReaction.NORMAL;
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }
}
