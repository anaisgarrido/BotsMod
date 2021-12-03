package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

import net.minecraft.block.AbstractBlock.Properties;

public class LongSproutedMud extends Block implements IGrowable {
    public static final BooleanProperty TRUFFLEHERE = BooleanProperty.create("truffle");
    public LongSproutedMud(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TRUFFLEHERE, false));
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack ItemHanded = player.getItemInHand(handIn);
        boolean nothingdown = worldIn.getBlockState(pos.below()).getBlock() instanceof AirBlock;
        if (ItemHanded.getItem() instanceof ShearsItem && state.getValue(TRUFFLEHERE) == true && worldIn.getBlockState(pos.below()).getBlock() instanceof AirBlock) {
            worldIn.setBlockAndUpdate(pos, state.setValue(TRUFFLEHERE, false));
            worldIn.setBlockAndUpdate(pos.below(), BlockInitNew.TRUFFLE_BLOCK.get().defaultBlockState());
            worldIn.setBlockAndUpdate(pos, BlockInitNew.WET_MUD_BLOCK2.get().defaultBlockState());
        } else if (ItemHanded.getItem() instanceof ShearsItem && state.getValue(TRUFFLEHERE) == true && !nothingdown) {
            popResource(worldIn, pos, new ItemStack(ItemInitNew.TRUFFLE.get()));
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(10) == 0)) {
            worldIn.setBlockAndUpdate(pos, state.setValue(TRUFFLEHERE, true));
        }
        super.tick(state, worldIn, pos, rand);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TRUFFLEHERE);
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}
