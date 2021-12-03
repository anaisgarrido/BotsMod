package com.thefreak.botsmod.objects.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import java.util.List;

public class PossesionEffect extends Effect {
    public PossesionEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {

        super.applyEffectTick(entityLivingBaseIn, amplifier);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return null;
    }
}
