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

public class SporianSpikyLongusPlant extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public SporianSpikyLongusPlant(Properties properties) {
        super(properties, Direction.UP, SHAPE, false);
    }
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BlockInitNew.SPORIAN_SPIKY_LONGUS.get());
    }
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.dismount();
        super.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        EntityType Entity = entityIn.getType();

        if (Entity == EntityType.PLAYER) {
            entityIn.attackEntityFrom(DamageSource.CACTUS, 1F);

        }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    protected AbstractTopPlantBlock getTopPlantBlock() {
        return (AbstractTopPlantBlock) BlockInitNew.SPORIAN_SPIKY_LONGUS.get();
    }
}
