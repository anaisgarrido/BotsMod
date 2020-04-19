package com.thefreak.botsmod.objects.events;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.init.EffectInitNew;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ExplosiveEffectEvent {
    private static boolean entityHasEffect(LivingEntity entity, Effect effect) {
        Collection<EffectInstance> entityEffects = entity.getActivePotionEffects();
        for (EffectInstance entityEffect : entityEffects) {
            if (entityEffect.getPotion() == effect) {
                return true;
            }
        }
        return false;
    }
    @SubscribeEvent
    public static void testEvent(LivingDeathEvent event) {
        System.out.println("DIED !");
        LivingEntity livingEntity = event.getEntityLiving();
        World world = livingEntity.getEntityWorld();

        if (livingEntity.getType() == EntityType.PLAYER && entityHasEffect(livingEntity, EffectInitNew.EXPLOSIVE_EFFECT.get())) {
            System.out.println("EXPLODE !");
            System.out.println(livingEntity.getActivePotionEffects().contains(new EffectInstance(EffectInitNew.EXPLOSIVE_EFFECT.get())));
            world.createExplosion(livingEntity, livingEntity.lastTickPosX, livingEntity.lastTickPosY, livingEntity.lastTickPosZ, 10.0F, true, Explosion.Mode.BREAK);
        }
    }
}
