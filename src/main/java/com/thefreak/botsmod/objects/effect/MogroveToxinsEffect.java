package com.thefreak.botsmod.objects.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class MogroveToxinsEffect extends Effect {
    public MogroveToxinsEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {

        super.performEffect(entityLivingBaseIn, amplifier);
    }
}
