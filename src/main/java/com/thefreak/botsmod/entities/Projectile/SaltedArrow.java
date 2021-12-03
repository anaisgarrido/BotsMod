package com.thefreak.botsmod.entities.Projectile;

import com.thefreak.botsmod.init.ItemInitNew;
import com.thefreak.botsmod.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SaltedArrow extends AbstractArrowEntity {


    public SaltedArrow(EntityType<? extends SaltedArrow> p_i50158_1_, World p_i50158_2_) {
        super(p_i50158_1_, p_i50158_2_);
    }

    public SaltedArrow(World p_i46768_1_, LivingEntity p_i46768_2_) {
        super(ModEntityTypes.SALTED_ARROW.get(), p_i46768_2_, p_i46768_1_);
    }

    public SaltedArrow(World p_i46769_1_, double p_i46769_2_, double p_i46769_4_, double p_i46769_6_) {
        super(ModEntityTypes.SALTED_ARROW.get(), p_i46769_2_, p_i46769_4_, p_i46769_6_, p_i46769_1_);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemInitNew.SALTED_ARROW.get());
    }
}
