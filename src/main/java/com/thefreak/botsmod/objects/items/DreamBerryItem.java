package com.thefreak.botsmod.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class DreamBerryItem extends Item {
    public DreamBerryItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.startSleeping(entityLiving.getPosition());
        entityLiving.isSleeping();
        worldIn.setGameTime(6000);
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
