package net.feed_o_o.bodakkoeater.menu;

import net.feed_o_o.bodakkoeater.BodakkoEater;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BodakkoEater.MOD_ID);

    public static final RegistryObject<MenuType<NutrientDeviceMenu>> NUTRIENT_DEVICE =
            MENUS.register("nutrient_device",
                    () -> new MenuType<>(NutrientDeviceMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
