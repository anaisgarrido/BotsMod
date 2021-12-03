package com.thefreak.botsmod.tileentity;

import com.thefreak.botsmod.API.TileEntity.ITileEntityBase;
import com.thefreak.botsmod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CenoGoblinAnvilTileEntity extends TileEntity implements ITileEntityBase {
    public CenoGoblinAnvilTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public CenoGoblinAnvilTileEntity() {
        this(ModTileEntityTypes.CENO_GOBLIN_ANVIL_TILE_ENTITY.get());
    }


    @Override
    public void Activated(BlockState state, World world) {
        System.out.println("RUN !");
        return;
    }

    @Override
    public void Ticking(BlockState state, ServerWorld serverWorld, BlockPos pos, Random random) {
        System.out.println(random.nextInt(5));
    }
}
