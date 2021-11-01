package com.thefreak.botsmod.init;

import java.util.function.Supplier;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.BotsMod.BotsItemGroup;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;



@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID,bus = Bus.MOD)
@ObjectHolder(BotsMod.MOD_ID)
public class ItemInit 
{
	public static final Item chisel = null;
	public static final Item long_root = null;
	public static final Item dry_wood_stick = null;
	public static final Item jade = null;
	
	public static final Item jade_pickaxe = null;
	public static final Item jade_axe = null;
	public static final Item jade_hoe = null;
	public static final Item jade_shovel = null;
	public static final Item jade_sword = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
			event.getRegistry().register(new Item(new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade"));
			
			//tools
			event.getRegistry().register(new SwordItem(ModItemTier.JADE, 5, 1.5F, new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade_sword"));
			event.getRegistry().register(new AxeItem(ModItemTier.JADE, 7, 1.5F, new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade_axe"));
			event.getRegistry().register(new PickaxeItem(ModItemTier.JADE, 2, 1.5F, new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade_pickaxe"));
			event.getRegistry().register(new HoeItem(ModItemTier.JADE, 1,1.5F, new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade_hoe"));
			event.getRegistry().register(new ShovelItem(ModItemTier.JADE, 2, 1.5F, new Item.Properties().group(BotsItemGroup.instance)).setRegistryName("jade_shovel"));

	}
	public enum ModItemTier implements IItemTier
	{
		// \int\ harvestLevel, \int\ maxUses, \float\ efficiency, \float\ attackDamage, \int\
        // enchantability, Supplier<Ingredient> repairMaterial
		JADE(4, 2500, 13.0F, 5.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.jade);
		}),
		DSTONE(3, 2000, 10.0F, 5.0F, 250, () -> {
			return Ingredient.fromItems(ItemInit.jade);
		});
		
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}


		@Override
		public int getMaxUses() {
			return this.maxUses;
		}


		@Override
		public float getEfficiency() {
			return this.efficiency;
		}


		@Override
		public float getAttackDamage() {
			return this.attackDamage;
		}


		@Override
		public int getHarvestLevel() {
			return this.harvestLevel;
		}


		@Override
		public int getEnchantability() {
			return this.enchantability;
		}


		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}
	}

}
