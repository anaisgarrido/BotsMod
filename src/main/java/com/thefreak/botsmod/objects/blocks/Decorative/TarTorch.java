package com.thefreak.botsmod.objects.blocks.Decorative;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class TarTorch extends Block implements IWaterLoggable {

    public static final BooleanProperty LIGHTED = BooleanProperty.create("lighted");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected static final VoxelShape SHAPE = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 14.0D, 9.5D);


    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE;
    }

    public TarTorch(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIGHTED, false).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult traceResult) {
        if (playerEntity.getItemInHand(hand).getItem() instanceof FlintAndSteelItem) {
        world.setBlock(pos, state.setValue(LIGHTED, true), 1);
            return ActionResultType.SUCCESS;
        }
        if (playerEntity.getItemInHand(hand).getItem() instanceof ShovelItem && state.getValue(LIGHTED) == true) {
            world.setBlock(pos, state.setValue(LIGHTED, false), 1);
            return ActionResultType.SUCCESS;
        }

        return super.use(state, world, pos, playerEntity, hand, traceResult);

    }

    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        FluidState fluidstate = p_196258_1_.getLevel().getFluidState(p_196258_1_.getClickedPos());
        return super.getStateForPlacement(p_196258_1_).setValue(LIGHTED, false).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    public boolean canSurvive(BlockState p_196260_1_, IWorldReader p_196260_2_, BlockPos p_196260_3_) {
        return canSupportCenter(p_196260_2_, p_196260_3_.below(), Direction.UP);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(LIGHTED, WATERLOGGED));
    }

    @Override
    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.getValue(WATERLOGGED) == true && state.getValue(LIGHTED) == true && random.nextInt(7) == 5) {
            world.setBlock(pos, state.setValue(LIGHTED, false), 1);
        }

        super.tick(state, world, pos, random);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World p_180655_2_, BlockPos p_180655_3_, Random random) {
        double d0 = (double) p_180655_3_.getX() + 0.5D;
        double d1 = (double) p_180655_3_.getY() + 0.7D;
        double d2 = (double) p_180655_3_.getZ() + 0.5D;
        if (state.getValue(LIGHTED) == true) {
            p_180655_2_.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            if (state.getValue(WATERLOGGED) == false) {
                p_180655_2_.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
