package net.feed_o_o.bodakkoeater;

import net.feed_o_o.bodakkoeater.block.ModBlocks;
import net.feed_o_o.bodakkoeater.block.entity.ModBlockEntities;
import net.feed_o_o.bodakkoeater.client.NutrientDeviceScreen;
import net.feed_o_o.bodakkoeater.menu.ModMenuTypes;
import net.feed_o_o.bodakkoeater.item.ModCreativeModeTabs;
import net.feed_o_o.bodakkoeater.item.ModItems;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BodakkoEater.MOD_ID)
public class BodakkoEater {
    public static final String MOD_ID = "bodakkoeater";

    // Forge 1.20.1: the mod event bus is obtained from FMLJavaModLoadingContext (no constructor injection).
    // FMLJavaModLoadingContext.get() / ModLoadingContext.get() are marked for removal in newer Forge,
    // but they keep working on every 1.20.1 Forge (47.x). The new constructor-parameter style needs Forge 47.4.0+.
    @SuppressWarnings({"deprecation", "removal"})
    public BodakkoEater() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the items and blocks to the ingredients tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.COOKED_BODAKKO);
            event.accept(ModItems.BODAKKO);
            event.accept(ModItems.SALT);
            event.accept(ModBlocks.BLOCK_BODAKKO);
            event.accept(ModBlocks.DOUBLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.TRIPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.QUADRUPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.QUINTUPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.SEXTUPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.SEPTUPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.OCTUPLE_BLOCK_BODAKKO);
            event.accept(ModBlocks.NONUPLE_BLOCK_BODAKKO);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = BodakkoEater.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.NUTRIENT_DEVICE.get(), NutrientDeviceScreen::new));
        }
    }
}
