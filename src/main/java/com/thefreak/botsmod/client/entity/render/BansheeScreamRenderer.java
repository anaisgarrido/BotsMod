package com.thefreak.botsmod.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefreak.botsmod.client.entity.model.BansheeScreamModel;
import com.thefreak.botsmod.client.entity.model.WanderingSpecterModel;
import com.thefreak.botsmod.entities.BansheeScreamEntity;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class BansheeScreamRenderer extends GeoEntityRenderer<BansheeScreamEntity> {
    public BansheeScreamRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BansheeScreamModel());
        this.shadowSize = 0F;

    }


    @Override
    public RenderType getRenderType(BansheeScreamEntity animatable, float partialTicks, MatrixStack stack,IRenderTypeBuffer renderTypeBuffer,IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.getEyes(new ResourceLocation("botsmod:textures/entities/banshee_scream.png"));
    }


    @Override
    public ResourceLocation getEntityTexture(BansheeScreamEntity entity) {
        return null;
    }

    @Override
    protected float getDeathMaxRotation(BansheeScreamEntity entityLivingBaseIn) {
        return 0F;
    }
}
