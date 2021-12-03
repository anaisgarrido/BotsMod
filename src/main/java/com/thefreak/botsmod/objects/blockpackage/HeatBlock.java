package com.thefreak.botsmod.objects.blockpackage;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import net.minecraft.block.AbstractBlock.Properties;

public class HeatBlock extends Block {
    public static final IntegerProperty Heat = IntegerProperty.create("heat", 0,2);
    public HeatBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(Heat, 2));
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {

        if (worldIn.getBlockState(currentPos.above()).getBlock() instanceof HeatBlock) {
            int a;
            a = worldIn.getBlockState(currentPos.above()).getValue(Heat);
            System.out.println(a - 273);
        }
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(Heat);
    }
}
