package com.thefreak.botsmod.objects.blockpackage;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class HeatBlock extends Block {
    public static final IntegerProperty Heat = IntegerProperty.create("heat", 0,2);
    public HeatBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(Heat, 2));
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {

        if (worldIn.getBlockState(currentPos.up()).getBlock() instanceof HeatBlock) {
            int a;
            a = worldIn.getBlockState(currentPos.up()).get(Heat);
            System.out.println(a - 273);
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(Heat);
    }
}
