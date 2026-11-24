package net.feed_o_o.bodakkoeater.block;

import net.feed_o_o.bodakkoeater.BodakkoEater;
import net.feed_o_o.bodakkoeater.block.custom.NutrientDeviceBlock;
import net.feed_o_o.bodakkoeater.item.EatableBlockItem;
import net.feed_o_o.bodakkoeater.item.ModFoodProperties;
import net.feed_o_o.bodakkoeater.item.ModItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BodakkoEater.MOD_ID);

    public static final RegistryObject<Block> BLOCK_BODAKKO = registerEatableBlock("block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f, 10f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> DOUBLE_BLOCK_BODAKKO = registerEatableBlock("double_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f, 15f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.DOUBLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> TRIPLE_BLOCK_BODAKKO = registerEatableBlock("triple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f, 20f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.TRIPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> QUADRUPLE_BLOCK_BODAKKO = registerEatableBlock("quadruple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f, 25f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.QUADRUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> QUINTUPLE_BLOCK_BODAKKO = registerEatableBlock("quintuple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(8f, 30f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.QUINTUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> SEXTUPLE_BLOCK_BODAKKO = registerEatableBlock("sextuple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(13f, 35f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.SEXTUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> SEPTUPLE_BLOCK_BODAKKO = registerEatableBlock("septuple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(21f, 40f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.SEPTUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> OCTUPLE_BLOCK_BODAKKO = registerEatableBlock("octuple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(34f, 45f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.OCTUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> NONUPLE_BLOCK_BODAKKO = registerEatableBlock("nonuple_block_bodakko",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(55f, 50f)
                    .sound(SoundType.STONE)),
            ModFoodProperties.NONUPLE_BLOCK_BODAKKO
    );

    public static final RegistryObject<Block> NUTRIENT_DEVICE = registerBlock("nutrient_device",
            () -> new NutrientDeviceBlock(BlockBehaviour.Properties.of()
                    .strength(3.5f, 5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            ));

    private static <T extends Block> RegistryObject<T> registerEatableBlock(String nameeat, Supplier<T> block, FoodProperties food) {
        RegistryObject<T> toReturn = BLOCKS.register(nameeat, block);
        registerEatableBlockItem(nameeat, toReturn, food);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerEatableBlockItem(String nameeat, RegistryObject<T> block, FoodProperties food) {
        ModItems.ITEMS.register(nameeat,
                () -> new EatableBlockItem(block.get(), new Item.Properties(), food));
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
