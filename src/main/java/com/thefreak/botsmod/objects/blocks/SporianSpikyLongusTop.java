package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SporianSpikyLongusTop extends AbstractTopPlantBlock implements IGrowable {
    int a;
    public static final VoxelShape SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);
    public static final BooleanProperty FRUIT = BooleanProperty.create("fruit");

    public SporianSpikyLongusTop(AbstractBlock.Properties properties) {
        super(properties, Direction.UP, SHAPE, false, 0.1D);
        this.setDefaultState(this.stateContainer.getBaseState().with(FRUIT, false));
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) { return true; }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        EntityType Entity = entityIn.getType();

        if (Entity == EntityType.PLAYER) {
            entityIn.attackEntityFrom(DamageSource.CACTUS, 1F);

        }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) { super.fillStateContainer(builder.add(FRUIT)); }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        boolean a = state.get(FRUIT);
        if (a == false && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(FRUIT, true), 2);
        }
        super.tick(state, worldIn, pos, rand);
    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (state.get(FRUIT) == true) {
            worldIn.setBlockState(pos, state.with(FRUIT, false), 2);
            spawnAsEntity(worldIn, pos, new ItemStack(ItemInitNew.SPORIAN_SPIKY_LONGUS_FRUIT.get(), 1));

        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    @Override
    protected int getGrowthAmount(Random rand) { return 0; }

    @Override
    protected boolean canGrowIn(BlockState state) { return PlantBlockHelper.isAir(state); }

    @Override
    protected Block getBodyPlantBlock() { return BlockInitNew.SPORIAN_SPIKY_LONGUS_PLANT.get(); }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(FRUIT) != true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {

        worldIn.setBlockState(pos, state.with(FRUIT, true), 2);
    }
}
