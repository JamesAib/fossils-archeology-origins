package com.praepositi.fossilsorigins.init;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import com.praepositi.fossilsorigins.entity.spawneggs.GeckoLibSpawnEggs;
import com.praepositi.fossilsorigins.entity.VelociraptorEntity;
import com.praepositi.fossilsorigins.entity.TyrannosaurausEntity;
import com.praepositi.fossilsorigins.entity.TriceratopsEntity;
import com.praepositi.fossilsorigins.entity.StegosaurusEntity;
import com.praepositi.fossilsorigins.entity.SpinosaurusEntity;
import com.praepositi.fossilsorigins.entity.PteranodonEntity;
import com.praepositi.fossilsorigins.entity.PlesiosuarusEntity;
import com.praepositi.fossilsorigins.entity.PachycephalosaurusEntity;
import com.praepositi.fossilsorigins.entity.OviraptorEntity;
import com.praepositi.fossilsorigins.entity.MosasaurusEntity;
import com.praepositi.fossilsorigins.entity.GalimimusEntity;
import com.praepositi.fossilsorigins.entity.DryosaurusEntity;
import com.praepositi.fossilsorigins.entity.DimetrodonEntity;
import com.praepositi.fossilsorigins.entity.DilophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CryolophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CompsognathusEntity;
import com.praepositi.fossilsorigins.entity.CarnotaurusEntity;
import com.praepositi.fossilsorigins.entity.BrachiosaurusEntity;
import com.praepositi.fossilsorigins.entity.AnkylosaurusEntity;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

@Mod.EventBusSubscriber(modid = FossilsoriginsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FossilsoriginsModGeckoLibEntities {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			GeckoLibSpawnEggs.REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BrachiosaurusEntity.init();
			AnkylosaurusEntity.init();
			CarnotaurusEntity.init();
			CompsognathusEntity.init();
			CryolophosaurusEntity.init();
			DilophosaurusEntity.init();
			DimetrodonEntity.init();
			DryosaurusEntity.init();
			GalimimusEntity.init();
			MosasaurusEntity.init();
			OviraptorEntity.init();
			PachycephalosaurusEntity.init();
			PlesiosuarusEntity.init();
			PteranodonEntity.init();
			SpinosaurusEntity.init();
			StegosaurusEntity.init();
			TyrannosaurausEntity.init();
			TriceratopsEntity.init();
			VelociraptorEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(FossilsoriginsModEntities.BRACHIOSAURUS.get(), BrachiosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.ANKYLOSAURUS.get(), AnkylosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.CARNOTAURUS.get(), CarnotaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.COMPSOGNATHUS.get(), CompsognathusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.CRYOLOPHOSAURUS.get(), CryolophosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.DILOPHOSAURUS.get(), DilophosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.DIMETRODON.get(), DimetrodonEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.DRYOSAURUS.get(), DryosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.GALIMIMUS.get(), GalimimusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.MOSASAURUS.get(), MosasaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.OVIRAPTOR.get(), OviraptorEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.PACHYCEPHALOSAURUS.get(), PachycephalosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.PLESIOSUARUS.get(), PlesiosuarusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.PTERANODON.get(), PteranodonEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.SPINOSAURUS.get(), SpinosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.STEGOSAURUS.get(), StegosaurusEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.TYRANNOSAURAUS.get(), TyrannosaurausEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.TRICERATOPS.get(), TriceratopsEntity.createAttributes().build());
		event.put(FossilsoriginsModEntities.VELOCIRAPTOR.get(), VelociraptorEntity.createAttributes().build());
	}
}
