package com.praepositi.fossilsorigins.entity.spawneggs;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import com.praepositi.fossilsorigins.init.FossilsoriginsModTabs;
import com.praepositi.fossilsorigins.init.FossilsoriginsModEntities;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

public class GeckoLibSpawnEggs {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FossilsoriginsMod.MODID);

	public static final RegistryObject<Item> BRACHIOSAURUS = REGISTRY.register("brachiosaurus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.BRACHIOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> ANKYLOSAURUS = REGISTRY.register("ankylosaurus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.ANKYLOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> CARNOTAURUS = REGISTRY.register("carnotaurus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.CARNOTAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> COMPSOGNATHUS = REGISTRY.register("compsognathus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.COMPSOGNATHUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> CRYOLOPHOSAURUS = REGISTRY.register("cryolophosaurus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.CRYOLOPHOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> DILOPHOSAURUS = REGISTRY.register("dilophosaurus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.DILOPHOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> DIMETRODON = REGISTRY.register("dimetrodon_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.DIMETRODON, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> DRYOSAURUS = REGISTRY.register("dryosaurus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.DRYOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> GALIMIMUS = REGISTRY.register("galimimus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.GALIMIMUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> MOSASAURUS = REGISTRY.register("mosasaurus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.MOSASAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> OVIRAPTOR = REGISTRY.register("oviraptor_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.OVIRAPTOR, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> PACHYCEPHALOSAURUS = REGISTRY.register("pachycephalosaurus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.PACHYCEPHALOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> PLESIOSUARUS = REGISTRY.register("plesiosuarus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.PLESIOSUARUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> PTERANODON = REGISTRY.register("pteranodon_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.PTERANODON, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> SPINOSAURUS = REGISTRY.register("spinosaurus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.SPINOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> STEGOSAURUS = REGISTRY.register("stegosaurus_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.STEGOSAURUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> TYRANNOSAURAUS = REGISTRY.register("tyrannosauraus_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.TYRANNOSAURAUS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> TRICERATOPS = REGISTRY.register("triceratops_spawn_egg", () -> new ForgeSpawnEggItem(FossilsoriginsModEntities.TRICERATOPS, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
	public static final RegistryObject<Item> VELOCIRAPTOR = REGISTRY.register("velociraptor_spawn_egg",
			() -> new ForgeSpawnEggItem(FossilsoriginsModEntities.VELOCIRAPTOR, -1, -1, new Item.Properties().tab(FossilsoriginsModTabs.TAB_FOSSILS_ORIGINS)));
}
