
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.praepositi.fossilsorigins.client.gui.InchubatorInterfaceScreen;
import com.praepositi.fossilsorigins.client.gui.DNAmodifierGUIScreen;
import com.praepositi.fossilsorigins.client.gui.AnalyzerInterfaceScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FossilsoriginsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(FossilsoriginsModMenus.ANALYZER_INTERFACE.get(), AnalyzerInterfaceScreen::new);
			MenuScreens.register(FossilsoriginsModMenus.INCHUBATOR_INTERFACE.get(), InchubatorInterfaceScreen::new);
			MenuScreens.register(FossilsoriginsModMenus.DN_AMODIFIER_GUI.get(), DNAmodifierGUIScreen::new);
		});
	}
}
