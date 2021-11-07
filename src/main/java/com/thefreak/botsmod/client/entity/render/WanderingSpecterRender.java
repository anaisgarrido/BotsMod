package com.thefreak.botsmod.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.thefreak.botsmod.client.entity.model.GiantTardigradeModel;
import com.thefreak.botsmod.client.entity.model.WanderingSpecterModel;
import com.thefreak.botsmod.entities.GiantTardigradeEntity;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class WanderingSpecterRender extends GeoEntityRenderer<WanderingSpecterEntity> {
    public WanderingSpecterRender(EntityRendererManager renderManager) {
        super(renderManager, new WanderingSpecterModel());
        this.shadowSize = 0F;

    }

    @Override
    public RenderType getRenderType(WanderingSpecterEntity animatable, float partialTicks, MatrixStack stack,IRenderTypeBuffer renderTypeBuffer,IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return animatable.getSpecterTransparentState() == true ? RenderType.getEntityTranslucent(new ResourceLocation("botsmod:textures/entities/transparent_wandering_specter_texture.png")) : RenderType.getEntityCutout(new ResourceLocation("botsmod:textures/entities/wandering_specter_texture.png"));
    }


    @Override
    public ResourceLocation getEntityTexture(WanderingSpecterEntity entity) {
        return null;
    }

    @Override
    protected float getDeathMaxRotation(WanderingSpecterEntity entityLivingBaseIn) {
        return 0F;
    }
}
