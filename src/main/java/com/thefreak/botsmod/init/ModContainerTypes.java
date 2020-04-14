package com.thefreak.botsmod.init;

import com.thefreak.botsmod.BotsMod;
import com.thefreak.botsmod.container.DeepWoodChestContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

	
		public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
				ForgeRegistries.CONTAINERS, BotsMod.MOD_ID);
		
		public static final RegistryObject<ContainerType<DeepWoodChestContainer>> DEEP_WOOD_CHEST = CONTAINER_TYPES
				.register("deep_wood_chest", () -> IForgeContainerType.create(DeepWoodChestContainer::new));
}
