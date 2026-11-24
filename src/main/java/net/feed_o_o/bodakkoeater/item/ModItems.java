package net.feed_o_o.bodakkoeater.item;

import net.feed_o_o.bodakkoeater.BodakkoEater;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BodakkoEater.MOD_ID);

    public static final RegistryObject<Item> COOKED_BODAKKO = ITEMS.register("cooked_bodakko",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_BODAKKO)));

    public static final RegistryObject<Item> BODAKKO = ITEMS.register("bodakko",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BODAKKO)));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
