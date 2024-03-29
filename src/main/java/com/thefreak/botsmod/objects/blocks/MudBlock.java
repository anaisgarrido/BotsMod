package com.thefreak.botsmod.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.AbstractBlock.Properties;

public class MudBlock extends Block {
	   protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

	   		public MudBlock(Properties properties) {
	   			super(properties);
			}
	   public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		      return SHAPE;
		   }
	   		@Override
	   		public float getFriction() {
	   			return -10F;
	   		}

		   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		      BubbleColumnBlock.growColumn(worldIn, pos.above(), false);
		   }

		   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		      worldIn.getBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
		   }

		   public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		      return true;
		   }

		   /**
		    * How many world ticks before ticking
		    */
		   public int tickRate(IWorldReader worldIn) {
		      return 20;
		   }

		   public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		      worldIn.getBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
		   }

		   public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		      return false;
		   }

		   public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		      return true;
		   }

		   @OnlyIn(Dist.CLIENT)
		   public boolean isViewBlocking(BlockState state, IBlockReader worldIn, BlockPos pos) {
		      return true;
		   }

}
