package com.thefreak.botsmod.client.entity.render;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.model.PoisonBullEntityModel;
import com.thefreak.botsmod.entities.PoisonBull;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PoisonBullRender extends MobRenderer<PoisonBull, PoisonBullEntityModel<PoisonBull>> {

	public PoisonBullRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PoisonBullEntityModel<PoisonBull>(), 0.5f);

	}
	protected static final ResourceLocation TEXTURE = new ResourceLocation(BotsMod.MOD_ID,
			"textures/entities/poison_bull.png");
	@Override
	public ResourceLocation getEntityTexture(PoisonBull entity) {
		return TEXTURE;
	}
	

}
