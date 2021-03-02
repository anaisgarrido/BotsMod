package com.thefreak.botsmod.objects.ister;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.data.EmptyModelData;
import java.util.Random;

public class DeltaCrystalISTER extends ItemStackTileEntityRenderer {
    public DeltaCrystalISTER() {
        super();
    }
    private Random random = new Random();

    @Override
    public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        super.func_239207_a_(stack, p_239207_2_, matrixStack, buffer, combinedLight, combinedOverlay);
        matrixStack.push();
        IBakedModel model = Minecraft.getInstance().getModelManager().getModel(new ResourceLocation("botsmod:item/delta_crystal_shard_model"));
        IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.getEntityTranslucentCull(PlayerContainer.LOCATION_BLOCKS_TEXTURE));
        MatrixStack.Entry entry = matrixStack.getLast();
        for (int i = 0; i < model.getQuads(null, null, random, EmptyModelData.INSTANCE).size(); i++) {
            vertexBuilder.addVertexData(entry, model.getQuads(null, null, random, EmptyModelData.INSTANCE).get(i), 1, 1, 1, 1, 2,1, true);
        }
        matrixStack.pop();
   }


}

