package com.thefreak.botsmod.objects.blockpackage;



import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class ConnectedTexturePillar extends RotatedPillarBlock {
    public static final BooleanProperty C_UP = BooleanProperty.create("cup");
    public static final BooleanProperty C_DOWN = BooleanProperty.create("cdown");

    public ConnectedTexturePillar(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(C_UP, false).with(C_DOWN, false));
    }



    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

        boolean vertical = stateIn.get(AXIS) == Direction.Axis.Y;
        boolean horizontalx = stateIn.get(AXIS) == Direction.Axis.X;
        boolean horizontalz = stateIn.get(AXIS) == Direction.Axis.Z;


        BlockPos up = pos.up();
        BlockPos down = pos.down();
        BlockPos north = pos.north();
        BlockPos south = pos.south();
        BlockPos east = pos.east();
        BlockPos west = pos.west();

        //                              Y-AXIS                                      //
        if (vertical && isConnectedAt(up,worldIn) && !isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, true), 2);
        } else if (vertical && !isConnectedAt(up, worldIn) && isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, true).with(C_DOWN, false), 2);
        } else if (vertical && !isConnectedAt(up, worldIn) && !isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        } else if (vertical && isConnectedAt(up, worldIn) && isConnectedAt(down, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        }


        //                              Z-AXIS                                      //
        if (horizontalz && isConnectedAt(north,worldIn) && !isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, true), 2);
        } else if (horizontalz && !isConnectedAt(north, worldIn) && isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, true).with(C_DOWN, false), 2);
        } else if (horizontalz && !isConnectedAt(north, worldIn) && !isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        } else if (horizontalz && isConnectedAt(north, worldIn) && isConnectedAt(south, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        }

        //                              X-AXIS                                      //
        if (horizontalx && isConnectedAt(east,worldIn) && !isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString()+ ": BOTTOM part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, true), 2);
        } else if (horizontalx && !isConnectedAt(east, worldIn) && isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": TOP part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, true).with(C_DOWN, false), 2);
        } else if (horizontalx && !isConnectedAt(east, worldIn) && !isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        } else if (horizontalx && isConnectedAt(east, worldIn) && isConnectedAt(west, worldIn)) {
            System.out.println(pos.toString() + ": MIDDLE part detected");
            worldIn.setBlockState(pos, stateIn.with(C_UP, false).with(C_DOWN, false), 2);
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(C_DOWN).add(C_UP).add(AXIS);
    }

    public static boolean isConnectedAt(BlockPos pos, IWorld worldIn) {
        boolean COnnect = worldIn.getBlockState(pos).getBlock() instanceof ConnectedTexturePillar;
        return COnnect;
    }


}
