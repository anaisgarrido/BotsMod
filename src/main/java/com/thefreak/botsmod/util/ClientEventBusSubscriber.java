package com.thefreak.botsmod.util;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.render.GiantTardigradeRender;
import com.thefreak.botsmod.init.ModContainerTypes;

import com.thefreak.botsmod.init.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup (FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GIANT_TARDIGRADE.get(), GiantTardigradeRender::new);
    }

	
}
