package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, BotsMod.MOD_ID);

    public static final RegistryObject<Item> ASH = ITEMS.register("ash", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> RAW_POISON_BULL_MEAT = ITEMS.register("raw_poison_bull_meat", () -> new Item(new Item.Properties()
            .group(BotsMod.BotsItemGroup.instance)
            .food(new Food.Builder().hunger(2).saturation(0.5F)
                    .effect(new EffectInstance(Effects.POISON, 400, 2 ), 1F).build())));


    public static final RegistryObject<Item> COOKED_POISON_BULL_MEAT = ITEMS.register("cooked_poison_bull_meat", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(5).saturation(1.5F).build())));

    public static final RegistryObject<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> COOKED_PILOVE_FRUIT = ITEMS.register("cooked_pilove_fruit", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(2).saturation(2F).build())));

    public static final RegistryObject<Item> PILOVE_FRUIT = ITEMS.register("pilove_fruit", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(5).saturation(3F).build())));
}
