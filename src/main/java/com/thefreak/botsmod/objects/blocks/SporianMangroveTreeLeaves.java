package com.thefreak.botsmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.minecraft.block.AbstractBlock.Properties;

public class SporianMangroveTreeLeaves extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public SporianMangroveTreeLeaves(Properties properties) {
        super(properties);
    }

    

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.causeFallDamage(fallDistance, 0.0F);
        super.fallOn(worldIn, pos, entityIn, fallDistance);
    }

    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.setDeltaMovement(new Vector3d(0D,0.75D,0D));
        super.stepOn(worldIn, pos, entityIn);
    }
}
