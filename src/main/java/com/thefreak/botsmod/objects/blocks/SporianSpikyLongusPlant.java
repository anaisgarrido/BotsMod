package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.minecraft.block.AbstractBlock.Properties;

public class SporianSpikyLongusPlant extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public SporianSpikyLongusPlant(Properties properties) {
        super(properties, Direction.UP, SHAPE, false);
    }
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BlockInitNew.SPORIAN_SPIKY_LONGUS.get());
    }
    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.removeVehicle();
        super.stepOn(worldIn, pos, entityIn);
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        EntityType Entity = entityIn.getType();

        if (Entity == EntityType.PLAYER) {
            entityIn.hurt(DamageSource.CACTUS, 1F);

        }
        super.entityInside(state, worldIn, pos, entityIn);
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BlockInitNew.SPORIAN_SPIKY_LONGUS.get();
    }
}
