package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.effect.ExplosiveEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectInitNew {
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, BotsMod.MOD_ID);

    public static final RegistryObject<Effect> EXPLOSIVE_EFFECT = EFFECTS.register("explosive_effect", () -> new ExplosiveEffect(EffectType.NEUTRAL, 0x0256));
}
