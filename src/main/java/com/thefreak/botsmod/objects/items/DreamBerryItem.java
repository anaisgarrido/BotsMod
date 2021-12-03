package com.thefreak.botsmod.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class DreamBerryItem extends Item {
    public DreamBerryItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.startSleeping(entityLiving.blockPosition());
        entityLiving.isSleeping();
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
}
