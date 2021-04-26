package com.thefreak.botsmod.objects.blocks;


import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SproutedMud extends Block implements IGrowable {
    public static final BooleanProperty TRUFFLEHERE = BooleanProperty.create("truffle");
    public SproutedMud(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(TRUFFLEHERE, false));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack ItemHanded = player.getHeldItem(handIn);
        boolean nothingdown = worldIn.getBlockState(pos.down()).getBlock() instanceof AirBlock;
        if (ItemHanded.getItem() instanceof ShearsItem && state.get(TRUFFLEHERE) == true && worldIn.getBlockState(pos.down()).getBlock() instanceof AirBlock) {
            worldIn.setBlockState(pos, state.with(TRUFFLEHERE, false));
            worldIn.setBlockState(pos.down(), BlockInitNew.TRUFFLE_BLOCK.get().getDefaultState());
            worldIn.setBlockState(pos, BlockInitNew.WET_MUD_BLOCK2.get().getDefaultState());
        } else if (ItemHanded.getItem() instanceof ShearsItem && state.get(TRUFFLEHERE) == true && !nothingdown) {
            spawnAsEntity(worldIn, pos, new ItemStack(ItemInitNew.TRUFFLE.get()));
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(10) == 0)) {
            worldIn.setBlockState(pos, state.with(TRUFFLEHERE, true));
        }
        super.tick(state, worldIn, pos, rand);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(TRUFFLEHERE);
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}
