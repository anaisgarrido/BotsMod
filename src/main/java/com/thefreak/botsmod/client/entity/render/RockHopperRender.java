package com.thefreak.botsmod.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.model.RockHopperEntityModel;
import com.thefreak.botsmod.entities.RockHopper;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RockHopperRender extends MobRenderer<RockHopper, RockHopperEntityModel> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(BotsMod.MOD_ID,
			"textures/entities/rock_hopper.png");
	
	public RockHopperRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RockHopperEntityModel(), 1f);

	}
	
	@Override
	public ResourceLocation getEntityTexture(RockHopper entity) {
		return TEXTURE;
	}

	@Override
	protected void preRenderCallback(RockHopper entitylivingbaseIn, MatrixStack matrixStackIn,
									 float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}
}
