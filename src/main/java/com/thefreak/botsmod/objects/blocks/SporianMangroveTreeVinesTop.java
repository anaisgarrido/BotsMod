package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.*;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import java.util.Random;

public class SporianMangroveTreeVinesTop extends AbstractTopPlantBlock {
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 9.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public SporianMangroveTreeVinesTop(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return type == PathType.AIR && !this.canCollide ? true : super.allowsMovement(state, worldIn, pos, type);
    }

    protected int getGrowthAmount(Random rand) {
        return PlantBlockHelper.getGrowthAmount(rand);
    }

    protected boolean canGrowIn(BlockState state) {
        return PlantBlockHelper.isAir(state);
    }

    protected Block getBodyPlantBlock() {
        return BlockInitNew.SPORIAN_MANGROVE_TREE_VINES.get();
    }


}
