package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.objects.blockpackage.FallingBushBlock;
import net.minecraft.block.*;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class AncientUrnCooked extends FallingBlock {
    public static VoxelShape BASE = Block.makeCuboidShape(5,0,5,11,12,11);
    public AncientUrnCooked(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BASE;
    }

    @Override
    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
        super.onEndFalling(worldIn, pos, fallingState, hitState, fallingBlock);
        FallingBlockEntity Entity = fallingBlock;
            if (Entity.fallTime > 10){


            worldIn.destroyBlock(pos, false);
            }
    }

    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtEntities(true);
    }


}
