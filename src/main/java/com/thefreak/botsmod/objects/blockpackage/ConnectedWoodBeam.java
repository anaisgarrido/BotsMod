package com.thefreak.botsmod.objects.blockpackage;



import net.minecraft.block.AirBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ConnectedWoodBeam extends RotatedPillarBlock {
    public static final BooleanProperty C_UP = BooleanProperty.create("c_up");
    public static final BooleanProperty C_DOWN = BooleanProperty.create("c_down");
    public static final BooleanProperty ATTACH = BooleanProperty.create("attach");
    protected static final VoxelShape SHAPE_Y = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    protected static final VoxelShape SHAPE_X = Block.makeCuboidShape(0.0D, 5.0D, 4.0D, 16.0D, 15.0D, 12.0D);
    protected static final VoxelShape SHAPE_Z = Block.makeCuboidShape(4.0D, 5.0D, 0.0D, 12.0D, 15.0D, 16.0D);

    public ConnectedWoodBeam(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(C_UP, false).with(C_DOWN, false).with(ATTACH, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(AXIS)) {
            case X:
            default:
                return SHAPE_X;

            case Y:
                return SHAPE_Y;

            case Z:
                return SHAPE_Z;
        }
    }



    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

        boolean vertical = stateIn.get(AXIS) == Direction.Axis.Y;
        boolean horizontalx = stateIn.get(AXIS) == Direction.Axis.X;
        boolean horizontalz = stateIn.get(AXIS) == Direction.Axis.Z;
        boolean cup = stateIn.get(C_UP);
        boolean cdown = stateIn.get(C_DOWN);

        BlockPos up = pos.up();
        BlockPos down = pos.down();
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();

        updateDiagonalNeighbors(stateIn,worldIn,pos,2,1);

        //                  ATTACHEMENT           Y-AXIS                            //
        if (vertical && isConnectedAt(north,worldIn)
                || isConnectedAt(south,worldIn)
                || isConnectedAt(east,worldIn)
                || isConnectedAt(west,worldIn)) {

            worldIn.setBlockState(pos, stateIn.with(ATTACH, true),2);


        }
        if (vertical && !isConnectedAt(north,worldIn)
                ) {
            if (!isConnectedAt(south,worldIn)) {
                if (!isConnectedAt(east,worldIn)) {
                    if (!isConnectedAt(west,worldIn)) {

                        worldIn.setBlockState(pos, stateIn.with(ATTACH, false), 2);
                    }
                }
            }
        }



        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
    }



    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(C_DOWN).add(C_UP).add(ATTACH).add(AXIS);
    }

    public static boolean isConnectedAt(BlockPos pos, IWorld worldIn) {
        boolean COnnect = worldIn.getBlockState(pos).getBlock() instanceof ConnectedWoodBeam;
        return COnnect;
    }
    public static boolean isAttachedAt(BlockPos pos, IWorld worldIn) {
        boolean COnnect = worldIn.getBlockState(pos).getBlock() instanceof ConnectedWoodBeam;
        boolean ConnectedAir = worldIn.getBlockState(pos).getBlock() instanceof AirBlock;
        boolean ConeCt = !COnnect && !ConnectedAir;
        return ConeCt;
    }


}
