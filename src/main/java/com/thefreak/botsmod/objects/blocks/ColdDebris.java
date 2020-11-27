package com.thefreak.botsmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nullable;
import java.util.Random;

public class ColdDebris extends Block {

    public ColdDebris(Properties properties) {
        super(properties);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
            player.addPotionEffect(new EffectInstance(Effects.HASTE,100,2));
        super.onBlockHarvested(worldIn, pos, state, player);
    }

}
