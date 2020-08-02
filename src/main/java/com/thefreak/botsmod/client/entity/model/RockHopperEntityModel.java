// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.thefreak.botsmod.client.entity.model;

import com.thefreak.botsmod.entities.RockHopper;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class RockHopperEntityModel extends AnimatedEntityModel<RockHopper> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Mask;
	private final AnimatedModelRenderer Mask2;
	private final AnimatedModelRenderer rightleg;
	private final AnimatedModelRenderer rightleg2;
	private final AnimatedModelRenderer leftleg;
	private final AnimatedModelRenderer leftleg2;
	private final AnimatedModelRenderer hair;

    public RockHopperEntityModel()
    {
        textureWidth = 64;
        textureHeight = 64;
    	Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Mask = new AnimatedModelRenderer(this);
		Mask.setRotationPoint(0.0182F, -11.25F, -2.5909F);
		Body.addChild(Mask);
		setRotationAngle(Mask, 0.0F, 0.6109F, 0.0F);
		Mask.setTextureOffset(8, 34).addBox(-3.3486F, -4.0F, -2.3784F, 5.0F, 10.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(0, 14).addBox(-7.5925F, -8.0F, -1.9974F, 9.0F, 14.0F, 0.0F, 0.0F, false);
		Mask.setModelRendererName("Mask");
		this.registerModelRenderer(Mask);

		Mask2 = new AnimatedModelRenderer(this);
		Mask2.setRotationPoint(-0.6767F, 10.0F, 5.3248F);
		Mask.addChild(Mask2);
		setRotationAngle(Mask2, 0.0F, -1.2217F, 0.0F);
		Mask2.setTextureOffset(8, 48).addBox(-6.4414F, -14.0F, -4.8267F, 5.0F, 10.0F, 1.0F, 0.0F, false);
		Mask2.setTextureOffset(18, 18).addBox(-6.1878F, -18.0F, -4.3766F, 9.0F, 14.0F, 0.0F, 0.0F, false);
		Mask2.setModelRendererName("Mask2");
		this.registerModelRenderer(Mask2);

		rightleg = new AnimatedModelRenderer(this);
		rightleg.setRotationPoint(-2.0F, -6.5F, 0.25F);
		Body.addChild(rightleg);
		setRotationAngle(rightleg, -0.3491F, 0.0F, 0.1745F);
		rightleg.setTextureOffset(22, 33).addBox(-0.7547F, -0.512F, -0.9637F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		rightleg.setModelRendererName("rightleg");
		this.registerModelRenderer(rightleg);

		rightleg2 = new AnimatedModelRenderer(this);
		rightleg2.setRotationPoint(0.6226F, 3.0465F, 0.0935F);
		rightleg.addChild(rightleg2);
		setRotationAngle(rightleg2, 0.4363F, 0.0873F, -0.1745F);
		rightleg2.setTextureOffset(29, 10).addBox(-1.6674F, -0.5139F, -1.5698F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		rightleg2.setModelRendererName("rightleg2");
		this.registerModelRenderer(rightleg2);

		leftleg = new AnimatedModelRenderer(this);
		leftleg.setRotationPoint(2.0F, -6.25F, 0.0F);
		Body.addChild(leftleg);
		setRotationAngle(leftleg, -0.3491F, 0.0F, -0.1745F);
		leftleg.setTextureOffset(30, 33).addBox(-1.2019F, -0.8289F, -0.813F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		leftleg.setModelRendererName("leftleg");
		this.registerModelRenderer(leftleg);

		leftleg2 = new AnimatedModelRenderer(this);
		leftleg2.setRotationPoint(-0.3292F, 2.9797F, -0.0057F);
		leftleg.addChild(leftleg2);
		setRotationAngle(leftleg2, 0.4363F, -0.0873F, 0.1745F);
		leftleg2.setTextureOffset(29, 10).addBox(-1.5201F, -0.5732F, -1.2271F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		leftleg2.setModelRendererName("leftleg2");
		this.registerModelRenderer(leftleg2);

		hair = new AnimatedModelRenderer(this);
		hair.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(hair);
		setRotationAngle(hair, -0.1745F, 0.0F, 0.0F);
		hair.setTextureOffset(0, 34).addBox(-1.0F, -19.8698F, -0.7386F, 2.0F, 8.0F, 0.0F, 0.0F, false);
		hair.setTextureOffset(0, 20).addBox(0.0F, -20.0F, -1.25F, 0.0F, 8.0F, 6.0F, 0.0F, false);
		hair.setModelRendererName("hair");
		this.registerModelRenderer(hair);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("botsmod", "animations/rock_hopper_idle.json");
    }
}