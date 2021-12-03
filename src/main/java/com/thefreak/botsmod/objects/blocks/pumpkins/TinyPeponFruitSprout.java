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

import net.minecraft.block.AbstractBlock.Properties;

public class TinyPeponFruitSprout extends DoublePlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty PUMPKIN = BooleanProperty.create("pumpkin");
    public TinyPeponFruitSprout(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(PUMPKIN, false));
    }


    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (worldIn.getBlockState(pos.above()).getBlock() == Blocks.AIR && state.getValue(PUMPKIN) == true && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            worldIn.setBlock(pos, state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(PUMPKIN, false), 5);
        }
        if (rand.nextInt(15) == 7) {
        if (worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock) {
            if ( state.getValue(PUMPKIN) == false && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlock(pos, state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(PUMPKIN, true), 5);
            }
            worldIn.setBlockAndUpdate(pos.above(), BlockInitNew.TINY_PEPON_FRUIT_GROWTH.get().defaultBlockState());
        } else if (worldIn.getBlockState(pos.above()).getBlock() == BlockInitNew.TINY_PEPON_FRUIT_HALF_GROWN.get()) {
            if ( state.getValue(PUMPKIN) == false && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlock(pos, state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(PUMPKIN, true), 5);
            }
        worldIn.setBlockAndUpdate(pos.above(), BlockInitNew.TINY_PEPON_FRUIT.get().defaultBlockState());
        }else if (worldIn.getBlockState(pos.above()).getBlock() == BlockInitNew.TINY_PEPON_FRUIT_GROWTH.get()) {
            if ( state.getValue(PUMPKIN) == false && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
                worldIn.setBlock(pos, state.setValue(HALF, DoubleBlockHalf.UPPER).setValue(PUMPKIN, true), 5);
            }
            worldIn.setBlockAndUpdate(pos.above(), BlockInitNew.TINY_PEPON_FRUIT_HALF_GROWN.get().defaultBlockState());
        }
        }



        super.tick(state, worldIn, pos, rand);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF, PUMPKIN);
    }
    public AbstractBlock.OffsetType getOffsetType() {
        return null;
    }


    @OnlyIn(Dist.CLIENT)
    public long getSeed(BlockState state, BlockPos pos) {
        return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }

}
