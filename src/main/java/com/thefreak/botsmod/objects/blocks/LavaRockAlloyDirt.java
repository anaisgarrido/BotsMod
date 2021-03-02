package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class LavaRockAlloyDirt extends Block {
    public static final BooleanProperty ROCKY = BooleanProperty.create("rocky");
    public LavaRockAlloyDirt(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(ROCKY, false));

    }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(ROCKY));
    }


    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockPos pos1 = currentPos;
        BlockPos pos2 = currentPos.up();
        boolean rocky = stateIn.get(ROCKY);
        if (worldIn.getBlockState(pos2).getBlock() instanceof LavaRockAlloy && rocky == false) {
            worldIn.setBlockState(pos1, stateIn.with(ROCKY, true), 2);

        }
        if (worldIn.getBlockState(pos2).getBlock() instanceof AirBlock && rocky == true) {
            worldIn.setBlockState(pos1, stateIn.with(ROCKY, false), 2);

        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);

    }
}
