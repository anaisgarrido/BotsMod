package com.thefreak.botsmod;

import com.thefreak.botsmod.entities.GiantTardigradeEntity;
import com.thefreak.botsmod.init.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("botsmod")
@Mod.EventBusSubscriber(modid = BotsMod.MOD_ID, bus = Bus.MOD)
public class BotsMod
{
    //aa
    // Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "botsmod";
    public static BotsMod instance;

    public BotsMod() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
        EffectInitNew.EFFECTS.register(modEventBus);
    	BlockInitNew.BLOCKS.register(modEventBus);
        ItemInitNew.ITEMS.register(modEventBus);
    	ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    	ModEntityTypes.ENTITY.register(modEventBus);
    	


        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.GIANT_TARDIGRADE.get(), GiantTardigradeEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInitNew.MOGROVE_BUBBLE_MUSHROOM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORE_PAD.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.MOGROVE_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.BRONZE_ALLOY_CRYSTAL.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_SPIKY_LONGUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_SPIKY_LONGUS_PLANT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_MOSS_GRASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_MANGROVE_BULB.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_MANGROVE_TREE_VINES_TOP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInitNew.SPORIAN_MANGROVE_TREE_VINES.get(), RenderType.getCutout());
        ModelLoader.addSpecialModel(new ResourceLocation("botsmod:item/delta_crystal_shard_model"));
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }


    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(BotsItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("Registered BlockItems!");
    }
    
    public static class BotsItemGroup extends ItemGroup
    {
    	public static final BotsItemGroup instance = new BotsItemGroup(ItemGroup.GROUPS.length, "botstab");
    	
    	private BotsItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    
    	@Override
    	public ItemStack createIcon()
    	{
    		return new ItemStack(BlockInitNew.BRONZE_ALLOY_BRICKS.get());
    	}
    }

}
