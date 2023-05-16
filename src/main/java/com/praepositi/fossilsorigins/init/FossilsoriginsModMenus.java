
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.praepositi.fossilsorigins.world.inventory.InchubatorInterfaceMenu;
import com.praepositi.fossilsorigins.world.inventory.DNAmodifierGUIMenu;
import com.praepositi.fossilsorigins.world.inventory.AnalyzerInterfaceMenu;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class FossilsoriginsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FossilsoriginsMod.MODID);
	public static final RegistryObject<MenuType<AnalyzerInterfaceMenu>> ANALYZER_INTERFACE = REGISTRY.register("analyzer_interface", () -> IForgeMenuType.create(AnalyzerInterfaceMenu::new));
	public static final RegistryObject<MenuType<InchubatorInterfaceMenu>> INCHUBATOR_INTERFACE = REGISTRY.register("inchubator_interface", () -> IForgeMenuType.create(InchubatorInterfaceMenu::new));
	public static final RegistryObject<MenuType<DNAmodifierGUIMenu>> DN_AMODIFIER_GUI = REGISTRY.register("dn_amodifier_gui", () -> IForgeMenuType.create(DNAmodifierGUIMenu::new));
}
