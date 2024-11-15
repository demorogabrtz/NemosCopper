package com.nemonotfound.nemos.copper;


import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.copper.Constants.MOD_ID;

@Mod(MOD_ID)
public class NemosCopperNeoForge {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);

    public NemosCopperNeoForge(IEventBus eventBus) {
        NemosCopperCommon.init();

        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        ENTITIES.register(eventBus);
    }
}