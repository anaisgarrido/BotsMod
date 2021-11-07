package com.thefreak.botsmod.objects.blocks.pumpkins;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.*;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class TinyPeponFruitSprout extends DoublePlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty PUMPKIN = BooleanProperty.create("pumpkin");
    public TinyPeponFruitSprout(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(PUMPKIN, false));
    }


    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && state.get(PUMPKIN) == true && state.get(HALF) == DoubleBlockHalf.UPPER) {
            worldIn.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER).with(PUMPKIN, false), 5);
        }
        if (rand.nextInt(15) == 7) {
        if (worldIn.getBlockState(pos.up()).getBlock() instanceof AirBlock) {
            if ( state.get(PUMPKIN) == false && state.get(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER).with(PUMPKIN, true), 5);
            }
            worldIn.setBlockState(pos.up(), BlockInitNew.TINY_PEPON_FRUIT_GROWTH.get().getDefaultState());
        } else if (worldIn.getBlockState(pos.up()).getBlock() == BlockInitNew.TINY_PEPON_FRUIT_HALF_GROWN.get()) {
            if ( state.get(PUMPKIN) == false && state.get(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER).with(PUMPKIN, true), 5);
            }
        worldIn.setBlockState(pos.up(), BlockInitNew.TINY_PEPON_FRUIT.get().getDefaultState());
        }else if (worldIn.getBlockState(pos.up()).getBlock() == BlockInitNew.TINY_PEPON_FRUIT_GROWTH.get()) {
            if ( state.get(PUMPKIN) == false && state.get(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlockState(pos, state.with(HALF, DoubleBlockHalf.UPPER).with(PUMPKIN, true), 5);
            }
            worldIn.setBlockState(pos.up(), BlockInitNew.TINY_PEPON_FRUIT_HALF_GROWN.get().getDefaultState());
        }
        }



        super.tick(state, worldIn, pos, rand);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, PUMPKIN);
    }
    public AbstractBlock.OffsetType getOffsetType() {
        return null;
    }


    @OnlyIn(Dist.CLIENT)
    public long getPositionRandom(BlockState state, BlockPos pos) {
        return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

}
