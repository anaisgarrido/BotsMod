package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class MogroveNutMushroom extends BushBlock implements IGrowable {
    public static IntegerProperty NUT = IntegerProperty.create("nut",0,1);
    public static VoxelShape FIRST_SHAPE = Block.box(2,0,2,14,15,14);
    public static VoxelShape SECOND_SHAPE = Block.box(2,0,2,14,19,14);
    public MogroveNutMushroom(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NUT, Integer.valueOf(0)));
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int i = state.getValue(NUT);
        boolean t = i == 1;
        if (!t && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return ActionResultType.PASS;
        } else if (i == 1) {
            popResource(worldIn, pos, new ItemStack(ItemInitNew.MOGROVE_NUT.get(), 1));
            worldIn.setBlock(pos, state.setValue(NUT, Integer.valueOf(0)), 2);
        }
            return super.use(state, worldIn, pos, player, handIn, hit);


    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        int i = state.getValue(NUT);
        if (i < 1 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0)) {
            worldIn.setBlock(pos, state.setValue(NUT, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }

    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(NUT)) {
            case 0:
            default:
                return FIRST_SHAPE;
            case 1:
                return SECOND_SHAPE;

        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NUT);
    }
    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(NUT) < 1;
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(1, state.getValue(NUT) + 1);
        worldIn.setBlock(pos, state.setValue(NUT, Integer.valueOf(i)), 2);
    }
}
