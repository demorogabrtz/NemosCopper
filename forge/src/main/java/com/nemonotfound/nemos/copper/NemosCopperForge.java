package com.nemonotfound.nemos.copper;

import com.nemonotfound.nemos.copper.block.ModBlocks;
import com.nemonotfound.nemos.copper.client.renderer.entity.CopperMinecartRenderer;
import com.nemonotfound.nemos.copper.entities.ModEntityTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import static com.nemonotfound.nemos.copper.Constants.MOD_ID;

@Mod(MOD_ID)
public class NemosCopperForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MOD_ID);

    public NemosCopperForge(FMLJavaModLoadingContext context) {
        final IEventBus modEventBus = context.getModEventBus();
        NemosCopperCommon.init();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        ENTITIES.register(modEventBus);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_ACTIVATOR_RAIL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_POWERED_RAIL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_DETECTOR_RAIL.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_RAIL.get(), RenderType.cutout());

            EntityRenderers.register(ModEntityTypes.COPPER_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_CHEST_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.CHEST_MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_COMMAND_BLOCK_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.COMMAND_BLOCK_MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_FURNACE_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.FURNACE_MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_HOPPER_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.HOPPER_MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_SPAWNER_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.SPAWNER_MINECART));
            EntityRenderers.register(ModEntityTypes.COPPER_TNT_MINECART.get(), context -> new CopperMinecartRenderer(context, ModelLayers.TNT_MINECART));
        }
    }
}