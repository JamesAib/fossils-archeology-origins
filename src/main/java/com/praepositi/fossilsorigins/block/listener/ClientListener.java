package com.praepositi.fossilsorigins.block.listener;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import com.praepositi.fossilsorigins.block.renderer.DNAModifierTileRenderer;
import com.praepositi.fossilsorigins.block.renderer.DNAInjectorBlockTileRenderer;
import com.praepositi.fossilsorigins.block.registry.TileRegistry;
import com.praepositi.fossilsorigins.block.registry.DisplayRegistry;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

@Mod.EventBusSubscriber(modid = FossilsoriginsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(TileRegistry.DNA_INJECTOR_BLOCK.get(), DNAInjectorBlockTileRenderer::new);
		event.registerBlockEntityRenderer(TileRegistry.DNA_MODIFIER.get(), DNAModifierTileRenderer::new);
	}

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			TileRegistry.TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
			DisplayRegistry.DISPLAY.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}
}
