package net.feed_o_o.bodakkoeater.item;

import net.feed_o_o.bodakkoeater.BodakkoEater;
import net.feed_o_o.bodakkoeater.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BodakkoEater.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BODAKKO_TAB = CREATIVE_MODE_TAB.register("bodakko_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COOKED_BODAKKO.get()))
                    .title(Component.translatable("creativetab.bodakkoeater.bodakko_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COOKED_BODAKKO.get());
                        output.accept(ModItems.BODAKKO.get());
                        output.accept(ModItems.SALT.get());
                        output.accept(ModBlocks.BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.DOUBLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.TRIPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.QUADRUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.QUINTUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.SEXTUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.SEPTUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.OCTUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.NONUPLE_BLOCK_BODAKKO.get());
                        output.accept(ModBlocks.NUTRIENT_DEVICE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
