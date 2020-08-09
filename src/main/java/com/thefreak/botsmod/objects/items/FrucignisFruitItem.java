package com.thefreak.botsmod.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;

public class FrucignisFruitItem extends Item {
    public FrucignisFruitItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        entityLiving.setFire(200);
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
