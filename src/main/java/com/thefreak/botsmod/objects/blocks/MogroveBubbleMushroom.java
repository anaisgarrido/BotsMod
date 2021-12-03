package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class MogroveBubbleMushroom extends BushBlock implements IGrowable {
    public static IntegerProperty BERRY = IntegerProperty.create("berry",0,6);
    public static VoxelShape SHAPE_FIRST = box(5,0,5,11,17,11);

    public MogroveBubbleMushroom(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRY, Integer.valueOf(0)));
    }


    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.getValue(BERRY);
        boolean t = i == 6;
        boolean j = i == 0;

        if (!t && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (!j) {
            popResource(worldIn, pos, new ItemStack(ItemInitNew.MOGROVE_BUBBLE_BERRY.get(), 0 + i));
            worldIn.setBlock(pos, state.setValue(BERRY, Integer.valueOf(0)), 2);
        }
        return super.use(state, worldIn, pos, player, handIn, hit);


    }
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        int i = state.getValue(BERRY);
        boolean t = i == 6;
        if (!t && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0)) {
            worldIn.setBlock(pos, state.setValue(BERRY, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    @Override
    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        entityIn.causeFallDamage(fallDistance, 4.0F);
        super.fallOn(worldIn, pos, entityIn, fallDistance);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_FIRST;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(BERRY));
    }
    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(BERRY) < 6;
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(6, state.getValue(BERRY) + 1);
        worldIn.setBlock(pos, state.setValue(BERRY, Integer.valueOf(i)), 2);
    }
}
