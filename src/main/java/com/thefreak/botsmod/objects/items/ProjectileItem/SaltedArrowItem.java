package com.thefreak.botsmod.objects.items.ProjectileItem;

import com.thefreak.botsmod.entities.Projectile.SaltedArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SaltedArrowItem extends ArrowItem {
    public SaltedArrowItem(Properties p_i48531_1_) {
        super(p_i48531_1_);
    }

    @Override
    public AbstractArrowEntity createArrow(World p_200887_1_, ItemStack p_200887_2_, LivingEntity p_200887_3_) {
        return new SaltedArrow(p_200887_1_, p_200887_3_);
    }
}
