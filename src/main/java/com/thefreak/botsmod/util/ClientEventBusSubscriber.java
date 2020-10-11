package com.thefreak.botsmod.util;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.render.PoisonBullRender;
import com.thefreak.botsmod.client.entity.render.RockHopperRender;
import com.thefreak.botsmod.client.entity.render.SoulRender;
import com.thefreak.botsmod.client.gui.DeepWoodChestScreen;
import com.thefreak.botsmod.init.ModContainerTypes;
import com.thefreak.botsmod.init.ModEntityTypes;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ModContainerTypes.DEEP_WOOD_CHEST.get(), DeepWoodChestScreen::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCK_HOPPER.get(), RockHopperRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POISON_BULL.get(), PoisonBullRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SOUL.get(), SoulRender::new);
	}
	
}
