package com.thefreak.botsmod.objects.blocks;

import com.thefreak.botsmod.init.BlockInitNew;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class SporianDandelion extends BushBlock {
    public static final BooleanProperty POLLEN = BooleanProperty.create("pollen");
    public static VoxelShape SHAPE = Block.box(1,0,1,15,12,15);
    public SporianDandelion(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POLLEN, true));
    }

    Random rand = new Random();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(POLLEN));
    }

    @Override
    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        boolean a = state.getValue(POLLEN) == false;
        if (!a) {
            double x = pos.getX() + 0.5D;
            double y = pos.getY() + 0.5D;
            double z = pos.getZ() + 0.5D;
            worldIn.addParticle(ParticleTypes.CLOUD, x, y, z, 0D, 0.3D, 0);
            worldIn.setBlock(pos, state.setValue(POLLEN, false), 2);
            worldIn.playSound((PlayerEntity)null, pos, SoundEvents.WOOL_FALL, SoundCategory.BLOCKS, 1F, 0.25F);

            if (rand.nextInt(10) == 0) {
                worldIn.destroyBlock(pos,false);
            }
        }
        super.entityInside(state, worldIn, pos, entityIn);
    }

    @Override
    public void onProjectileHit(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
        boolean a = state.getValue(POLLEN) == false;
        if (!a) {
            double x = projectile.getX() + 0.5D;
            double y = projectile.getY() + 0.5D;
            double z = projectile.getZ() + 0.5D;
            worldIn.addParticle(ParticleTypes.CLOUD, x, y, z, 0D, 0.3D, 0);
            worldIn.setBlock(projectile.blockPosition(), state.setValue(POLLEN, false), 2);
            worldIn.playSound((PlayerEntity)null, projectile.blockPosition(), SoundEvents.WOOL_FALL, SoundCategory.BLOCKS, 1F, 0.25F);
            if (rand.nextInt(10) == 0) {
            worldIn.destroyBlock(projectile.blockPosition(),false);
            }

        }
        super.onProjectileHit(worldIn, state, hit, projectile);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.PODZOL) || state.is(Blocks.FARMLAND) || state.is(BlockInitNew.SPORIAN_MOSS_GRASS.get());
    }
}
