package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.objects.items.DreamBerryItem;
import com.thefreak.botsmod.objects.items.PiloveFruitItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInitNew {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BotsMod.MOD_ID);

    public static final RegistryObject<Item> ASH = ITEMS.register("ash", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> COOKED_PILOVE_FRUIT = ITEMS.register("cooked_pilove_fruit", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(7).saturation(5F).build())));

    public static final RegistryObject<Item> PILOVE_FRUIT = ITEMS.register("pilove_fruit", () -> new PiloveFruitItem(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(5).saturation(3F).effect( () -> new EffectInstance(EffectInitNew.EXPLOSIVE_EFFECT.get(), 400, 1),1.0F).fastToEat().build())));

    public static final RegistryObject<Item> DREAM_BERRY = ITEMS.register("dream_berry", () -> new DreamBerryItem(new Item.Properties().group(BotsMod.BotsItemGroup.instance).food(new Food.Builder().hunger(4).saturation(5F).setAlwaysEdible().build())));

    public static final RegistryObject<Item> MOGROVE_NUT = ITEMS.register("mogrove_nut", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance).maxStackSize(16)));

    public static final RegistryObject<Item> MOGROVE_BUBBLE_BERRY = ITEMS.register("mogrove_bubble_berry", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> MOGROVE_VIOLET = ITEMS.register("mogrove_violet", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> SPORIAN_MANGROVE_TREE_BARK = ITEMS.register("sporian_mangrove_tree_bark", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> SPORIAN_SPIKY_LONGUS_FRUIT = ITEMS.register("sporian_spiky_longus_fruit", () -> new Item(new Item.Properties().group(BotsMod.BotsItemGroup.instance)));

    public static final RegistryObject<Item> TRUFFLE = ITEMS.register("truffle", () -> new Item(new Item.Properties()
            .group(BotsMod.BotsItemGroup.instance)
            .food(new Food.Builder().hunger(2).saturation(0.5F)
                    .effect(() -> new EffectInstance(Effects.ABSORPTION, 200, 2 ), 3).build())));

    public static final RegistryObject<Item> TUBER_BERRIES = ITEMS.register("tuber_berries", () -> new Item(new Item.Properties()
            .group(BotsMod.BotsItemGroup.instance)
            .food(new Food.Builder().hunger(5).saturation(0.5F)
                    .effect(() -> new EffectInstance(Effects.NAUSEA, 600, 3 ), 3).build())));

    public static final RegistryObject<Item> BRUTE_CHALK = ITEMS.register("brute_chalk", () -> new Item(new Item.Properties()
            .group(BotsMod.BotsItemGroup.instance)
            .food(new Food.Builder().hunger(0).saturation(1.0F)
                    .build())));


}

