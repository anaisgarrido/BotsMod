package com.thefreak.botsmod.objects.blocks;

import com.mojang.datafixers.kinds.IdF;
import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.BlockEvent;
import sun.security.provider.SHA;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class MudReeds extends RotatedPillarBlock implements IGrowable, IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty BRANCHES = IntegerProperty.create("branches", 0, 2);
    protected static final VoxelShape SHAPE_NORMAL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    protected static final VoxelShape SHAPE_X = Block.box(0.0D, 5.0D, 5.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape SHAPE_Z = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 16.0D);
    public MudReeds(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.valueOf(true)).setValue(BRANCHES, 0));
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        boolean vertical = state.getValue(AXIS) == Direction.Axis.Y;
        boolean HorizontalX = state.getValue(AXIS) == Direction.Axis.X;
        boolean HorizontalZ = state.getValue(AXIS) == Direction.Axis.Z;
        BlockPos down = pos.below();
        BlockPos up = pos.above();
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();
        BlockPos down1 = pos.below(2);
        BlockPos up1 = pos.above(2);
        BlockPos north1 = pos.north(2);
        BlockPos south1 = pos.south(2);
        BlockPos east1 = pos.east(2);
        BlockPos west1 = pos.west(2);
        boolean SmthHereDown = worldIn.getBlockState(down).getBlock() instanceof AirBlock ;
        boolean SmthHereUp = worldIn.getBlockState(up).getBlock() instanceof AirBlock ;
        boolean SmthHereFoward = worldIn.getBlockState(north).getBlock() instanceof AirBlock ;
        boolean SmthHereBackward = worldIn.getBlockState(south).getBlock() instanceof AirBlock ;
        boolean SmthHereRight = worldIn.getBlockState(east).getBlock() instanceof AirBlock ;
        boolean SmthHereLeft = worldIn.getBlockState(west).getBlock() instanceof AirBlock ;
        if (vertical && !SmthHereDown && !HorizontalX && !HorizontalZ) {
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.above(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.below(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.above(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.above(2), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.above(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.below(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        } else if (vertical && !SmthHereUp && !HorizontalX && !HorizontalZ){
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.below()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.below(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.above(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.below(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.below(2), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.below(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.above(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        } else if (HorizontalZ && !SmthHereFoward && !HorizontalX && !vertical){
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.south()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.south(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.north(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.south(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.south(2), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.south(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.north(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        } else if (HorizontalZ && !SmthHereBackward && !HorizontalX && !vertical){
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.north()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.north(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.south(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.north(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.north(2), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.north(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.south(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        } else if (HorizontalX && !SmthHereRight && !HorizontalZ && !vertical){
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.west()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.west(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.east(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.west(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.west(2),BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.west(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.east(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        } else if (HorizontalX && !SmthHereLeft && !HorizontalZ && !vertical){
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.east()).getBlock() instanceof AirBlock && worldIn.getBlockState(pos.east(2)).getBlock() instanceof AirBlock) {
                if (worldIn.getBlockState(pos.west(5)).getBlock() instanceof MudReeds && rand.nextInt(5) == 0) {
                    worldIn.setBlockAndUpdate(pos.east(), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                    worldIn.setBlockAndUpdate(pos.east(2), BlockInitNew.MUD_REED_LEAVES.get().defaultBlockState());
                } else {
                    worldIn.setBlock(pos.east(), state.setValue(AXIS, state.getValue(AXIS)), 2);
                }
            }
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) == 1) &&  worldIn.getBlockState(pos.west(6)).getBlock() instanceof MudReeds) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 2), 2);
            }
        }
        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0 && state.getValue(BRANCHES) != 2) ) {
            worldIn.setBlock(pos, state.setValue(BRANCHES, 1), 2);
        }

            super.tick(state, worldIn, pos, rand);
    }


    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack handItem = player.getItemInHand(handIn);
        Random rand = new Random();
        int a =  rand.nextInt(3);
        if (handItem.getItem() instanceof AxeItem && state.getValue(BRANCHES) == 1) {
            worldIn.setBlock(pos, state.setValue(BRANCHES, 0), 2);
            popResource(worldIn, pos, new ItemStack(Items.STICK, a + 1));
        }

        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(AXIS)) {
            case X:
            default:
                return SHAPE_X;
            case Z:
                return SHAPE_Z;
            case Y:
                return SHAPE_NORMAL;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(WATERLOGGED).add(BRANCHES).add(AXIS);
    }





    public static boolean isInstanceOf(BlockPos pos, IWorld world) {
        boolean yesornolol = world.getBlockState(pos).getBlock() instanceof MudReeds;
        return yesornolol;
    }


    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        boolean vertical = state.getValue(AXIS) == Direction.Axis.Y;
        boolean HorizontalX = state.getValue(AXIS) == Direction.Axis.X;
        boolean HorizontalZ = state.getValue(AXIS) == Direction.Axis.Z;
        BlockPos down = pos.below();
        BlockPos up = pos.above();
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();
        boolean SmthHereDown = worldIn.getBlockState(down).getBlock() instanceof AirBlock;
        boolean SmthHereUp = worldIn.getBlockState(up).getBlock() instanceof AirBlock;
        boolean SmthHereFoward = worldIn.getBlockState(north).getBlock() instanceof AirBlock;
        boolean SmthHereBackward = worldIn.getBlockState(south).getBlock() instanceof AirBlock;
        boolean SmthHereRight = worldIn.getBlockState(east).getBlock() instanceof AirBlock;
        boolean SmthHereLeft = worldIn.getBlockState(west).getBlock() instanceof AirBlock;
        if (vertical && !SmthHereDown || vertical && !SmthHereUp) {
            return true;
        } else if (HorizontalZ && !SmthHereFoward || HorizontalZ && !SmthHereBackward) {

            return true;
        } else if (HorizontalX && !SmthHereRight || HorizontalX && !SmthHereLeft) {
            return true;
        } else {
            return false;

        }
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
        boolean vertical = state.getValue(AXIS) == Direction.Axis.Y;
        if (vertical) {
            if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(5) == 0) && worldIn.getBlockState(pos.above()).getBlock() instanceof AirBlock) {
                worldIn.setBlockAndUpdate(pos.above(), this.defaultBlockState());
            }
            if (worldIn.getBlockState(pos.below(5)).getBlock() instanceof MudReeds && state.getValue(BRANCHES) == 0) {
                worldIn.setBlock(pos, state.setValue(BRANCHES, 1), 2);
            }
        }
    }
}

