package com.thefreak.botsmod.client.entity.render;

import com.thefreak.botsmod.entities.Projectile.SaltedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SaltedArrowRenderer extends ArrowRenderer<SaltedArrow> {
    public static final ResourceLocation SALTED_ARROW_TEXTURE = new ResourceLocation("botsmod:textures/entities/projectiles/salted_arrow_entity.png");

    public SaltedArrowRenderer(EntityRendererManager p_i46549_1_) {
        super(p_i46549_1_);
    }

    @Override
    public ResourceLocation getTextureLocation(SaltedArrow p_110775_1_) {
        return SALTED_ARROW_TEXTURE;
    }

}
