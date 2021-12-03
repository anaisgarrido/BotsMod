package com.thefreak.botsmod.objects.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.world.IWorld;

import javax.swing.text.Position;

import net.minecraft.block.AbstractBlock.Properties;

public class SulfurGlassBlock extends AbstractGlassBlock implements IBeaconBeamColorProvider {
    public SulfurGlassBlock(Properties p_i49999_1_) {
        super(p_i49999_1_);
    }

    @Override
    public DyeColor getColor() {
        return null;
    }

}
