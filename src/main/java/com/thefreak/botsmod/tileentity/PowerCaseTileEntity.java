package com.thefreak.botsmod.tileentity;

import com.thefreak.botsmod.init.ModTileEntityTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class PowerCaseTileEntity extends TileEntity {
    public PowerCaseTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
//My understanding now is that is to bind the tile with a block so it can become a TileEntity
    public PowerCaseTileEntity() { this(ModTileEntityTypes.POWER_CASE_BLOCK.get()); }


}
