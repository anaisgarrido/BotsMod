package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SporianDandelion extends BushBlock {
    public static final BooleanProperty POLLEN = BooleanProperty.create("pollen");
    public static VoxelShape SHAPE = Block.makeCuboidShape(1,0,1,15,12,15);
    public SporianDandelion(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(POLLEN, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder.add(POLLEN));
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        boolean a = state.get(POLLEN) == false;
        if (!a) {
            double x = pos.getX() + 0.5D;
            double y = pos.getY() + 0.5D;
            double z = pos.getZ() + 0.5D;
            worldIn.addParticle(ParticleTypes.CLOUD, x, y, z, 0D, 0.3D, 0);
            worldIn.setBlockState(pos, state.with(POLLEN, false), 2);
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_WOOL_FALL, SoundCategory.BLOCKS, 1F, 0.25F);
        }
        super.onEntityCollision(state, worldIn, pos, entityIn);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(Blocks.GRASS_BLOCK) || state.isIn(Blocks.DIRT) || state.isIn(Blocks.COARSE_DIRT) || state.isIn(Blocks.PODZOL) || state.isIn(Blocks.FARMLAND) || state.isIn(BlockInitNew.SPORIAN_MOSS_GRASS.get());
    }
}
