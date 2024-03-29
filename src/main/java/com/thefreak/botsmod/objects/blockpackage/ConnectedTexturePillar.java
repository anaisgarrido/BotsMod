package com.thefreak.botsmod.objects.blockpackage;



import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

import net.minecraft.block.AbstractBlock.Properties;

public class ConnectedTexturePillar extends RotatedPillarBlock {
    public static final BooleanProperty C_UP = BooleanProperty.create("c_up");
    public static final BooleanProperty C_DOWN = BooleanProperty.create("c_down");

    public ConnectedTexturePillar(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(C_UP, false).setValue(C_DOWN, false));
    }



    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

        boolean vertical = stateIn.getValue(AXIS) == Direction.Axis.Y;
        boolean horizontalx = stateIn.getValue(AXIS) == Direction.Axis.X;
        boolean horizontalz = stateIn.getValue(AXIS) == Direction.Axis.Z;


        BlockPos up = pos.above();
        BlockPos down = pos.below();
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();

        //                              Y-AXIS                                      //
        if (vertical && isConnectedAt(up,worldIn) && !isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, true), 2);
        } else if (vertical && !isConnectedAt(up, worldIn) && isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, true).setValue(C_DOWN, false), 2);
        } else if (vertical && !isConnectedAt(up, worldIn) && !isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        } else if (vertical && isConnectedAt(up, worldIn) && isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        }


        //                              Z-AXIS                                      //
        if (horizontalz && isConnectedAt(north,worldIn) && !isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, true), 2);
        } else if (horizontalz && !isConnectedAt(north, worldIn) && isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, true).setValue(C_DOWN, false), 2);
        } else if (horizontalz && !isConnectedAt(north, worldIn) && !isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        } else if (horizontalz && isConnectedAt(north, worldIn) && isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        }

        //                              X-AXIS                                      //
        if (horizontalx && isConnectedAt(east,worldIn) && !isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, true), 2);
        } else if (horizontalx && !isConnectedAt(east, worldIn) && isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, true).setValue(C_DOWN, false), 2);
        } else if (horizontalx && !isConnectedAt(east, worldIn) && !isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        } else if (horizontalx && isConnectedAt(east, worldIn) && isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlock(pos, stateIn.setValue(C_UP, false).setValue(C_DOWN, false), 2);
        }
        return super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos);
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(C_DOWN).add(C_UP).add(AXIS);
    }

    public static boolean isConnectedAt(BlockPos pos, IWorld worldIn) {
        boolean COnnect = worldIn.getBlockState(pos).getBlock() instanceof ConnectedTexturePillar;
        return COnnect;
    }


}
