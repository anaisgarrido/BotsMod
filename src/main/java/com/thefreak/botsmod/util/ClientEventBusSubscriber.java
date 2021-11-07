package com.thefreak.botsmod.util;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.render.BansheeScreamRenderer;
import com.thefreak.botsmod.client.entity.render.GiantTardigradeRender;
import com.thefreak.botsmod.client.entity.render.WanderingSpecterRender;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import com.thefreak.botsmod.init.ModContainerTypes;

import com.thefreak.botsmod.init.ModEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    private static final EntityRendererManager renderManager = Minecraft.getInstance().getRenderManager();

    @SubscribeEvent
    public static void clientSetup (FMLClientSetupEvent event) {
                                         //      MOBS       //
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GIANT_TARDIGRADE.get(), GiantTardigradeRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WANDERING_SPECTER.get(), WanderingSpecterRender::new);


                                        //      SPECIAL       //
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BANSHEE_SCREAM.get(), BansheeScreamRenderer::new);


                                        //      ITEMS       //

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PINK_PURIFIED_SALT_ITEM_ENTITY.get(), (renderManager) -> new ItemRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
    }


	
}
