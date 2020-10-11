package com.thefreak.botsmod.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.client.entity.model.SoulEntityModel;
import com.thefreak.botsmod.entities.Soul;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

public class SoulRender extends MobRenderer<Soul, SoulEntityModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(BotsMod.MOD_ID,
			"textures/entities/soul_texture.png");

	public SoulRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SoulEntityModel(), 0f);

	}
	
	@Override
	public ResourceLocation getEntityTexture(Soul entity) {
		return TEXTURE;
	}

	@Override
	protected void preRenderCallback(Soul entitylivingbaseIn, MatrixStack matrixStackIn,
									 float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
	}


}
