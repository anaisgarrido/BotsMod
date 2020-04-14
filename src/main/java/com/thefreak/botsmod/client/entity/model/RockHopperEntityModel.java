package com.thefreak.botsmod.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefreak.botsmod.entities.RockHopper;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class RockHopperEntityModel<T extends RockHopper> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Mask;
	private final ModelRenderer Mask2;
	private final ModelRenderer rightleg;
	private final ModelRenderer rightleg2;
	private final ModelRenderer leftleg;
	private final ModelRenderer leftleg2;
	private final ModelRenderer hair;

	public RockHopperEntityModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0,0).addBox(-3.0f, -12.0f, -3.0f, 6, 6, 6, 0.0f, false);

		Mask = new ModelRenderer(this);
		Mask.setRotationPoint(0.0182F, -11.25F, -2.5909F);
		setRotationAngle(Mask, 0.0F, 0.6109F, 0.0F);
		Body.addChild(Mask);
		Mask.setTextureOffset(8,34).addBox( -3.3486F, -4.0F, -2.3784F, 5, 10, 1, 0.0F, false);
		Mask.setTextureOffset(0,14).addBox(-7.5925F, -8.0F, -1.9974F, 9, 14, 0, 0.0F, false);

		Mask2 = new ModelRenderer(this);
		Mask2.setRotationPoint(-0.6767F, 10.0F, 5.3248F);
		setRotationAngle(Mask2, 0.0F, -1.2217F, 0.0F);
		Mask.addChild(Mask2);
		Mask2.setTextureOffset(8,48).addBox(-6.4414f, -14.0f, -4.8267f, 5, 10, 1, 0.0f, false);
		Mask2.setTextureOffset(18,18).addBox(-6.1878F, -18.0F, -4.3766F, 9, 14, 0, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -6.5F, 0.25F);
		setRotationAngle(rightleg, -0.3491F, 0.0F, 0.1745F);
		Body.addChild(rightleg);
		rightleg.setTextureOffset(22,33).addBox(-0.7547F, -0.512F, -0.9637F, 2, 4, 2, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(0.6226F, 3.0465F, 0.0935F);
		setRotationAngle(rightleg2, 0.4363F, 0.0873F, -0.1745F);
		rightleg.addChild(rightleg2);
		rightleg2.setTextureOffset(29,10).addBox(-1.6674F, -0.5139F, -1.5698F, 3, 4, 3, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -6.25F, 0.0F);
		setRotationAngle(leftleg, -0.3491F, 0.0F, -0.1745F);
		Body.addChild(leftleg);
		leftleg.setTextureOffset(30,33).addBox(-1.2019F, -0.8289F, -0.813F, 2, 4, 2, 0.0F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(-0.3292F, 2.9797F, -0.0057F);
		setRotationAngle(leftleg2, 0.4363F, -0.0873F, 0.1745F);
		leftleg.addChild(leftleg2);
		leftleg2.setTextureOffset(29,10).addBox(-1.5201F, -0.5732F, -1.2271F, 3, 4, 3, 0.0F, false);

		hair = new ModelRenderer(this);
		hair.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(hair, -0.1745F, 0.0F, 0.0F);
		Body.addChild(hair);
		hair.setTextureOffset(0,34).addBox(-1.0F, -19.8698F, -0.7386F, 2, 8, 0, 0.0F, false);
		hair.setTextureOffset(0,20).addBox(0.0F, -20.0F, -1.25F, 0, 8, 6, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		
	}
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
}
