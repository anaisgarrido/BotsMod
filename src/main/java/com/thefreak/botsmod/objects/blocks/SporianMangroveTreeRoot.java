package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

public class SporianMangroveTreeRoot extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public SporianMangroveTreeRoot(Properties properties) {
        super(properties, Direction.UP, SHAPE, false);
    }
    public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BlockInitNew.SPORIAN_MANGROVE_TREE_ROOT_TOP.get());
    }
    @Override
    public void stepOn(World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.removeVehicle();
        super.stepOn(worldIn, pos, entityIn);
    }


    @Override
    protected AbstractTopPlantBlock getHeadBlock() {
        return (AbstractTopPlantBlock) BlockInitNew.SPORIAN_MANGROVE_TREE_ROOT_TOP.get();
    }
}
