package com.thefreak.botsmod.objects.items;

import com.thefreak.botsmod.entities.PinkPurifiedSaltItemEntity;
import com.thefreak.botsmod.entities.WanderingSpecterEntity;
import com.thefreak.botsmod.init.EffectInitNew;
import com.thefreak.botsmod.init.ItemInitNew;
import com.thefreak.botsmod.init.ModEntityTypes;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collection;

import net.minecraft.item.Item.Properties;

public class PinkPurifiedSalt extends Item {
    public PinkPurifiedSalt(Properties properties) {
        super(properties);
    }
    private static boolean entityHasEffect(LivingEntity entity, Effect effect) {
        Collection<EffectInstance> entityEffects = entity.getActiveEffects();
        for (EffectInstance entityEffect : entityEffects) {
            if (entityEffect.getEffect() == effect) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entityLiving) {
        BlockPos pos = entityLiving.blockPosition();
        if (entityHasEffect(entityLiving, EffectInitNew.POSSESION.get())) {
            WanderingSpecterEntity wanderingSpecterEntity = ModEntityTypes.WANDERING_SPECTER.get().create(world);
            wanderingSpecterEntity.setPos(pos.getX(),pos.getY(),pos.getZ());
            world.addFreshEntity(wanderingSpecterEntity);
            entityLiving.removeEffect(EffectInitNew.POSSESION.get());
        }
        return super.finishUsingItem(stack, world, entityLiving);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }



    public PinkPurifiedSaltItemEntity createEntity(World world, Entity location, ItemStack itemstack)
    {
        return new PinkPurifiedSaltItemEntity(world, location.getX(), location.getY(), location.getZ(), itemstack) {
            @Override
            public boolean hasPickUpDelay() {
                return true;
            }

        };
    }

}
