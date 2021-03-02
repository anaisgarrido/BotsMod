package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import java.util.Random;

public class SporianMangroveTreeVines extends AbstractBodyPlantBlock  {
    public static final VoxelShape SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SporianMangroveTreeVines(AbstractBlock.Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BlockInitNew.SPORIAN_MANGROVE_TREE_VINES_TOP.get());
    }
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return type == PathType.AIR && !this.canCollide ? true : super.allowsMovement(state, worldIn, pos, type);
    }


    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) BlockInitNew.SPORIAN_MANGROVE_TREE_VINES_TOP.get();
    }

}
