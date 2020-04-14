package com.thefreak.botsmod.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefreak.botsmod.entities.PoisonBull;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class PoisonBullEntityModel<T extends PoisonBull> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Body2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightFoot;
	private final ModelRenderer Toe1;
	private final ModelRenderer Toe4;
	private final ModelRenderer Toe2;
	private final ModelRenderer Toe5;
	private final ModelRenderer Toe3;
	private final ModelRenderer Toe6;
	private final ModelRenderer RightLeg3;
	private final ModelRenderer RightLeg4;
	private final ModelRenderer RightFoot2;
	private final ModelRenderer Toe7;
	private final ModelRenderer Toe8;
	private final ModelRenderer Toe9;
	private final ModelRenderer Toe10;
	private final ModelRenderer Toe11;
	private final ModelRenderer Toe12;
	private final ModelRenderer Body3;
	private final ModelRenderer Body4;
	private final ModelRenderer Head;
	private final ModelRenderer Head2;
	private final ModelRenderer PoisonGland;
	private final ModelRenderer PoisonGland2;
	private final ModelRenderer PoisonGland4;
	private final ModelRenderer PoisonGland5;
	private final ModelRenderer PoisonGland3;

	public PoisonBullEntityModel() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-0.25F, 9.0F, 0.0F);
		setRotationAngle(Body, 1.0472F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-6.75F, -14.5532F, 1.5886F, 13, 12, 8, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.25F, -2.75F, 5.0F);
		setRotationAngle(Body2, -0.3491F, 0.0F, 0.0F);
		Body.addChild(Body2);
		Body2.setTextureOffset(28, 28).addBox(-6.0F, -0.7576F, -2.7511F, 11, 6, 6, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.25F, 4.9272F, -2.6883F);
		setRotationAngle(RightLeg, 0.349F, 0.6108F, -0.6109F);
		Body2.addChild(RightLeg);
		RightLeg.setTextureOffset(42, 0).addBox(-5.2044F, -9.726F, -1.65F, 6, 13, 6, 0.0F, false);

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(-2.6213F, -7.9905F, -0.3912F);
		setRotationAngle(RightLeg2, 0.8727F, 3.1416F, 0.0F);
		RightLeg.addChild(RightLeg2);
		RightLeg2.setTextureOffset(23, 59).addBox(-2.2568F, -0.3726F, -2.0398F, 4, 13, 5, 0.0F, false);

		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(-0.2287F, 10.801F, 1.6959F);
		setRotationAngle(RightFoot, -1.6581F, 2.618F, -0.4363F);
		RightLeg2.addChild(RightFoot);
		RightFoot.setTextureOffset(35, 77).addBox(-2.8843F, -4.7513F, 0.4738F, 7, 9, 3, 0.0F, false);

		Toe1 = new ModelRenderer(this);
		Toe1.setRotationPoint(5.3562F, 4.1567F, -2.465F);
		setRotationAngle(Toe1, -1.2217F, 3.0543F, -0.3491F);
		RightFoot.addChild(Toe1);
		Toe1.setTextureOffset(63, 63).addBox(-1.386F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe4 = new ModelRenderer(this);
		Toe4.setRotationPoint(-0.4963F, 4.0273F, 3.0544F);
		setRotationAngle(Toe4, -1.4835F, 3.1416F, 0.0F);
		Toe1.addChild(Toe4);
		Toe4.setTextureOffset(77, 63).addBox(-2.4063F, 0.2254F, -2.5142F, 4, 4, 4, 0.0F, false);

		Toe2 = new ModelRenderer(this);
		Toe2.setRotationPoint(1.4787F, 5.0533F, -2.8671F);
		setRotationAngle(Toe2, -1.2217F, 3.0543F, -0.0873F);
		RightFoot.addChild(Toe2);
		Toe2.setTextureOffset(66, 0).addBox(-1.386F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe5 = new ModelRenderer(this);
		Toe5.setRotationPoint(-0.6745F, 3.9881F, 5.0972F);
		setRotationAngle(Toe5, -1.4835F, 3.1416F, 0.0F);
		Toe2.addChild(Toe5);
		Toe5.setTextureOffset(69, 74).addBox(-2.9512F, -1.5742F, -2.2381F, 4, 4, 4, 0.0F, false);

		Toe3 = new ModelRenderer(this);
		Toe3.setRotationPoint(-2.5213F, 5.5199F, -3.0455F);
		setRotationAngle(Toe3, -1.2217F, 3.0543F, 0.2618F);
		RightFoot.addChild(Toe3);
		Toe3.setTextureOffset(70, 44).addBox(-1.386F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe6 = new ModelRenderer(this);
		Toe6.setRotationPoint(-0.8457F, 3.9735F, 5.132F);
		setRotationAngle(Toe6, -1.4835F, 3.1416F, 0.0873F);
		Toe3.addChild(Toe6);
		Toe6.setTextureOffset(71, 55).addBox(-2.9409F, -1.5751F, -2.2387F, 4, 4, 4, 0.0F, false);

		RightLeg3 = new ModelRenderer(this);
		RightLeg3.setRotationPoint(5.25F, 4.6138F, -2.4253F);
		setRotationAngle(RightLeg3, 0.3491F, -0.2618F, 0.6109F);
		Body2.addChild(RightLeg3);
		RightLeg3.setTextureOffset(30, 40).addBox(-0.7956F, -9.726F, -1.65F, 6, 13, 6, 0.0F, false);

		RightLeg4 = new ModelRenderer(this);
		RightLeg4.setRotationPoint(2.6213F, -7.9905F, -0.3912F);
		setRotationAngle(RightLeg4, 0.8727F, -3.1416F, 0.0F);
		RightLeg3.addChild(RightLeg4);
		RightLeg4.setTextureOffset(0, 60).addBox(-1.7432F, -0.3726F, -2.0398F, 4, 13, 5, 0.0F, false);

		RightFoot2 = new ModelRenderer(this);
		RightFoot2.setRotationPoint(0.2287F, 10.801F, 0.6959F);
		setRotationAngle(RightFoot2, -1.3963F, -3.0543F, 0.4363F);
		RightLeg4.addChild(RightFoot2);
		RightFoot2.setTextureOffset(15, 77).addBox(-3.4229F, -3.7582F, 0.6573F, 7, 9, 3, 0.0F, false);

		Toe7 = new ModelRenderer(this);
		Toe7.setRotationPoint(-4.6634F, 5.1498F, -2.2815F);
		setRotationAngle(Toe7, -1.2217F, -3.0543F, 0.3491F);
		RightFoot2.addChild(Toe7);
		Toe7.setTextureOffset(55, 74).addBox(-1.6518F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe8 = new ModelRenderer(this);
		Toe8.setRotationPoint(0.4963F, 4.0273F, 3.0544F);
		setRotationAngle(Toe8, -1.4835F, -3.1416F, 0.0F);
		Toe7.addChild(Toe8);
		Toe8.setTextureOffset(80, 0).addBox(-1.64F, 0.2945F, -2.5288F, 4, 4, 4, 0.0F, false);

		Toe9 = new ModelRenderer(this);
		Toe9.setRotationPoint(-0.7859F, 6.0464F, -2.6836F);
		setRotationAngle(Toe9, -1.2217F, -3.0543F, 0.0873F);
		RightFoot2.addChild(Toe9);
		Toe9.setTextureOffset(56, 20).addBox(-1.6518F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe10 = new ModelRenderer(this);
		Toe10.setRotationPoint(0.6745F, 3.9881F, 5.0972F);
		setRotationAngle(Toe10, -1.4835F, -3.1416F, 0.0F);
		Toe9.addChild(Toe10);
		Toe10.setTextureOffset(81, 81).addBox(-1.077F, -1.5363F, -2.2453F, 4, 4, 4, 0.0F, false);

		Toe11 = new ModelRenderer(this);
		Toe11.setRotationPoint(3.2141F, 6.513F, -2.862F);
		setRotationAngle(Toe11, -1.2217F, -3.0543F, -0.2618F);
		RightFoot2.addChild(Toe11);
		Toe11.setTextureOffset(70, 11).addBox(-1.6518F, 2.4483F, -4.0603F, 3, 3, 8, 0.0F, false);

		Toe12 = new ModelRenderer(this);
		Toe12.setRotationPoint(0.8457F, 3.9735F, 5.132F);
		setRotationAngle(Toe12, -1.4835F, -3.1416F, -0.0873F);
		Toe11.addChild(Toe12);
		Toe12.setTextureOffset(84, 8).addBox(-1.1001F, -1.5362F, -2.2465F, 4, 4, 4, 0.0F, false);

		Body3 = new ModelRenderer(this);
		Body3.setRotationPoint(0.0F, 4.288F, 0.696F);
		Body2.addChild(Body3);
		Body3.setTextureOffset(0, 48).addBox(-5.0F, -3.0F, -3.0F, 9, 7, 5, 0.0F, false);

		Body4 = new ModelRenderer(this);
		Body4.setRotationPoint(0.0F, 4.4014F, -0.1498F);
		Body3.addChild(Body4);
		Body4.setTextureOffset(71, 35).addBox(-3.5F, -1.0F, -2.0F, 6, 4, 3, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -14.8058F, 7.1011F);
		setRotationAngle(Head, -0.8726F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 20).addBox(-4.75F, -0.2022F, -7.9549F, 9, 6, 8, 0.0F, false);

		Head2 = new ModelRenderer(this);
		Head2.setRotationPoint(0.0F, -14.3832F, 6.3691F);
		setRotationAngle(Head2, -1.1345F, 0.0F, 0.0F);
		Body.addChild(Head2);
		Head2.setTextureOffset(35, 19).addBox(-3.75F, -2.0F, -5.0F, 7, 2, 7, 0.0F, false);

		PoisonGland = new ModelRenderer(this);
		PoisonGland.setRotationPoint(0.0F, -6.6409F, 1.3102F);
		Body.addChild(PoisonGland);
		PoisonGland.setTextureOffset(0, 34).addBox(-4.1955F, -5.4211F, -5.5068F, 8, 7, 7, 0.0F, false);

		PoisonGland2 = new ModelRenderer(this);
		PoisonGland2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(PoisonGland2, 0.3491F, -0.8727F, -0.2618F);
		PoisonGland.addChild(PoisonGland2);
		PoisonGland2.setTextureOffset(41, 64).addBox(-0.75F, -2.4211F, -5.5068F, 4, 4, 7, 0.0F, false);

		PoisonGland4 = new ModelRenderer(this);
		PoisonGland4.setRotationPoint(-3.0F, 1.1472F, 1.6383F);
		setRotationAngle(PoisonGland4, 0.7854F, 0.2618F, 0.0F);
		PoisonGland.addChild(PoisonGland4);
		PoisonGland4.setTextureOffset(47, 52).addBox(-1.75F, -3.4211F, -5.5068F, 5, 5, 7, 0.0F, false);

		PoisonGland5 = new ModelRenderer(this);
		PoisonGland5.setRotationPoint(-1.0F, 1.3927F, 0.2455F);
		setRotationAngle(PoisonGland5, 0.7854F, -0.4363F, 0.0F);
		PoisonGland.addChild(PoisonGland5);
		PoisonGland5.setTextureOffset(54, 40).addBox(-1.75F, -3.4211F, -5.5068F, 5, 5, 7, 0.0F, false);

		PoisonGland3 = new ModelRenderer(this);
		PoisonGland3.setRotationPoint(-3.0F, -1.8838F, 2.5399F);
		setRotationAngle(PoisonGland3, 0.3491F, 0.7854F, -0.2618F);
		PoisonGland.addChild(PoisonGland3);
		PoisonGland3.setTextureOffset(71, 24).addBox(-0.75F, -2.4211F, -5.5068F, 4, 4, 7, 0.0F, false);
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
