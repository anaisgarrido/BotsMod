package com.thefreak.botsmod.objects.ister;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DeltaCrystalISTER extends ItemStackTileEntityRenderer {
    public DeltaCrystalISTER() {
        super();
    }

    @Override
    public void render(ItemStack itemStackIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

        super.render(itemStackIn, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
        Minecraft.getInstance().getModelManager();
        Minecraft.getInstance().getItemRenderer().renderItem(itemStackIn, ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND ,true,matrixStackIn,bufferIn,0,1,);


    }


}

