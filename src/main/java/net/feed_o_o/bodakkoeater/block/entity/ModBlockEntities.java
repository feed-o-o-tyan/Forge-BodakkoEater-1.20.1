package net.feed_o_o.bodakkoeater.block.entity;

import net.feed_o_o.bodakkoeater.BodakkoEater;
import net.feed_o_o.bodakkoeater.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BodakkoEater.MOD_ID);

    public static final RegistryObject<BlockEntityType<NutrientDeviceBlockEntity>> NUTRIENT_DEVICE =
            BLOCK_ENTITIES.register("nutrient_device", () ->
                    BlockEntityType.Builder.of(NutrientDeviceBlockEntity::new,
                            ModBlocks.NUTRIENT_DEVICE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
