
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.praepositi.fossilsorigins.entity.VelociraptorEntity;
import com.praepositi.fossilsorigins.entity.VelociraptorEggEntityEntity;
import com.praepositi.fossilsorigins.entity.TyrannosaurausEntity;
import com.praepositi.fossilsorigins.entity.TyrannosaurausEggEntityEntity;
import com.praepositi.fossilsorigins.entity.TriceratopsEntity;
import com.praepositi.fossilsorigins.entity.TriceratopsEggEntityEntity;
import com.praepositi.fossilsorigins.entity.TranqualizerDartEntity;
import com.praepositi.fossilsorigins.entity.StegosaurusEntity;
import com.praepositi.fossilsorigins.entity.StegosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.SpinosaurusEntity;
import com.praepositi.fossilsorigins.entity.SpinosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.PteranodonEntity;
import com.praepositi.fossilsorigins.entity.PteranodonEggEntityEntity;
import com.praepositi.fossilsorigins.entity.PlesiosuarusEntity;
import com.praepositi.fossilsorigins.entity.PaleontologistEntity;
import com.praepositi.fossilsorigins.entity.PachycephalosaurusEntity;
import com.praepositi.fossilsorigins.entity.PachycephalosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.OviraptorEntity;
import com.praepositi.fossilsorigins.entity.OviraptorEggEntityEntity;
import com.praepositi.fossilsorigins.entity.MosasaurusEntity;
import com.praepositi.fossilsorigins.entity.GalimimusEntity;
import com.praepositi.fossilsorigins.entity.GalimimusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.DryosaurusEntity;
import com.praepositi.fossilsorigins.entity.DryosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.DimetrodonEntity;
import com.praepositi.fossilsorigins.entity.DimetrodonEggEntityEntity;
import com.praepositi.fossilsorigins.entity.DilophosaurusEntity;
import com.praepositi.fossilsorigins.entity.DilophosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.CryolophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CryolophosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.CompsognathusEntity;
import com.praepositi.fossilsorigins.entity.CompsognathusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.CarnotaurusEntity;
import com.praepositi.fossilsorigins.entity.CarnotaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.BrachiosaurusEntity;
import com.praepositi.fossilsorigins.entity.BrachiosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.entity.AnkylosaurusEntity;
import com.praepositi.fossilsorigins.entity.AnkylosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.FossilsoriginsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FossilsoriginsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FossilsoriginsMod.MODID);
	public static final RegistryObject<EntityType<BrachiosaurusEntity>> BRACHIOSAURUS = register("brachiosaurus",
			EntityType.Builder.<BrachiosaurusEntity>of(BrachiosaurusEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BrachiosaurusEntity::new)

					.sized(6f, 7f));
	public static final RegistryObject<EntityType<AnkylosaurusEntity>> ANKYLOSAURUS = register("ankylosaurus",
			EntityType.Builder.<AnkylosaurusEntity>of(AnkylosaurusEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AnkylosaurusEntity::new)

					.sized(3f, 4f));
	public static final RegistryObject<EntityType<CarnotaurusEntity>> CARNOTAURUS = register("carnotaurus",
			EntityType.Builder.<CarnotaurusEntity>of(CarnotaurusEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CarnotaurusEntity::new)

					.sized(5f, 6f));
	public static final RegistryObject<EntityType<CompsognathusEntity>> COMPSOGNATHUS = register("compsognathus",
			EntityType.Builder.<CompsognathusEntity>of(CompsognathusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CompsognathusEntity::new)

					.sized(0.6f, 0.7f));
	public static final RegistryObject<EntityType<CryolophosaurusEntity>> CRYOLOPHOSAURUS = register("cryolophosaurus",
			EntityType.Builder.<CryolophosaurusEntity>of(CryolophosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CryolophosaurusEntity::new)

					.sized(3f, 2.5f));
	public static final RegistryObject<EntityType<DilophosaurusEntity>> DILOPHOSAURUS = register("dilophosaurus",
			EntityType.Builder.<DilophosaurusEntity>of(DilophosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DilophosaurusEntity::new)

					.sized(2f, 1.4f));
	public static final RegistryObject<EntityType<DimetrodonEntity>> DIMETRODON = register("dimetrodon",
			EntityType.Builder.<DimetrodonEntity>of(DimetrodonEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DimetrodonEntity::new)

					.sized(2f, 1.8f));
	public static final RegistryObject<EntityType<DryosaurusEntity>> DRYOSAURUS = register("dryosaurus",
			EntityType.Builder.<DryosaurusEntity>of(DryosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DryosaurusEntity::new)

					.sized(1f, 1.8f));
	public static final RegistryObject<EntityType<GalimimusEntity>> GALIMIMUS = register("galimimus",
			EntityType.Builder.<GalimimusEntity>of(GalimimusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GalimimusEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<MosasaurusEntity>> MOSASAURUS = register("mosasaurus",
			EntityType.Builder.<MosasaurusEntity>of(MosasaurusEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MosasaurusEntity::new)

					.sized(5f, 3f));
	public static final RegistryObject<EntityType<OviraptorEntity>> OVIRAPTOR = register("oviraptor",
			EntityType.Builder.<OviraptorEntity>of(OviraptorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OviraptorEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PachycephalosaurusEntity>> PACHYCEPHALOSAURUS = register("pachycephalosaurus",
			EntityType.Builder.<PachycephalosaurusEntity>of(PachycephalosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PachycephalosaurusEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<PlesiosuarusEntity>> PLESIOSUARUS = register("plesiosuarus",
			EntityType.Builder.<PlesiosuarusEntity>of(PlesiosuarusEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PlesiosuarusEntity::new)

					.sized(3f, 3f));
	public static final RegistryObject<EntityType<PteranodonEntity>> PTERANODON = register("pteranodon",
			EntityType.Builder.<PteranodonEntity>of(PteranodonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PteranodonEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SpinosaurusEntity>> SPINOSAURUS = register("spinosaurus",
			EntityType.Builder.<SpinosaurusEntity>of(SpinosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpinosaurusEntity::new)

					.sized(6f, 6f));
	public static final RegistryObject<EntityType<StegosaurusEntity>> STEGOSAURUS = register("stegosaurus",
			EntityType.Builder.<StegosaurusEntity>of(StegosaurusEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StegosaurusEntity::new)

					.sized(3f, 4f));
	public static final RegistryObject<EntityType<TyrannosaurausEntity>> TYRANNOSAURAUS = register("tyrannosauraus",
			EntityType.Builder.<TyrannosaurausEntity>of(TyrannosaurausEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TyrannosaurausEntity::new)

					.sized(7f, 6f));
	public static final RegistryObject<EntityType<TriceratopsEntity>> TRICERATOPS = register("triceratops",
			EntityType.Builder.<TriceratopsEntity>of(TriceratopsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TriceratopsEntity::new)

					.sized(3f, 4f));
	public static final RegistryObject<EntityType<VelociraptorEntity>> VELOCIRAPTOR = register("velociraptor",
			EntityType.Builder.<VelociraptorEntity>of(VelociraptorEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VelociraptorEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AnkylosaurusEggEntityEntity>> ANKYLOSAURUS_EGG_ENTITY = register("ankylosaurus_egg_entity",
			EntityType.Builder.<AnkylosaurusEggEntityEntity>of(AnkylosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(AnkylosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<TyrannosaurausEggEntityEntity>> TYRANNOSAURAUS_EGG_ENTITY = register("tyrannosauraus_egg_entity",
			EntityType.Builder.<TyrannosaurausEggEntityEntity>of(TyrannosaurausEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TyrannosaurausEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<BrachiosaurusEggEntityEntity>> BRACHIOSAURUS_EGG_ENTITY = register("brachiosaurus_egg_entity",
			EntityType.Builder.<BrachiosaurusEggEntityEntity>of(BrachiosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(BrachiosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<CarnotaurusEggEntityEntity>> CARNOTAURUS_EGG_ENTITY = register("carnotaurus_egg_entity",
			EntityType.Builder.<CarnotaurusEggEntityEntity>of(CarnotaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(CarnotaurusEggEntityEntity::new)

					.sized(0.2f, 0.2f));
	public static final RegistryObject<EntityType<CompsognathusEggEntityEntity>> COMPSOGNATHUS_EGG_ENTITY = register("compsognathus_egg_entity",
			EntityType.Builder.<CompsognathusEggEntityEntity>of(CompsognathusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(CompsognathusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<DilophosaurusEggEntityEntity>> DILOPHOSAURUS_EGG_ENTITY = register("dilophosaurus_egg_entity",
			EntityType.Builder.<DilophosaurusEggEntityEntity>of(DilophosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(DilophosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<DryosaurusEggEntityEntity>> DRYOSAURUS_EGG_ENTITY = register("dryosaurus_egg_entity",
			EntityType.Builder.<DryosaurusEggEntityEntity>of(DryosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DryosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<PachycephalosaurusEggEntityEntity>> PACHYCEPHALOSAURUS_EGG_ENTITY = register("pachycephalosaurus_egg_entity",
			EntityType.Builder.<PachycephalosaurusEggEntityEntity>of(PachycephalosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(PachycephalosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<PteranodonEggEntityEntity>> PTERANODON_EGG_ENTITY = register("pteranodon_egg_entity",
			EntityType.Builder.<PteranodonEggEntityEntity>of(PteranodonEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PteranodonEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<StegosaurusEggEntityEntity>> STEGOSAURUS_EGG_ENTITY = register("stegosaurus_egg_entity",
			EntityType.Builder.<StegosaurusEggEntityEntity>of(StegosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(StegosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<TriceratopsEggEntityEntity>> TRICERATOPS_EGG_ENTITY = register("triceratops_egg_entity",
			EntityType.Builder.<TriceratopsEggEntityEntity>of(TriceratopsEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(TriceratopsEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<CryolophosaurusEggEntityEntity>> CRYOLOPHOSAURUS_EGG_ENTITY = register("cryolophosaurus_egg_entity",
			EntityType.Builder.<CryolophosaurusEggEntityEntity>of(CryolophosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(CryolophosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<DimetrodonEggEntityEntity>> DIMETRODON_EGG_ENTITY = register("dimetrodon_egg_entity",
			EntityType.Builder.<DimetrodonEggEntityEntity>of(DimetrodonEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DimetrodonEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<GalimimusEggEntityEntity>> GALIMIMUS_EGG_ENTITY = register("galimimus_egg_entity",
			EntityType.Builder.<GalimimusEggEntityEntity>of(GalimimusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GalimimusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<SpinosaurusEggEntityEntity>> SPINOSAURUS_EGG_ENTITY = register("spinosaurus_egg_entity",
			EntityType.Builder.<SpinosaurusEggEntityEntity>of(SpinosaurusEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(SpinosaurusEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<VelociraptorEggEntityEntity>> VELOCIRAPTOR_EGG_ENTITY = register("velociraptor_egg_entity",
			EntityType.Builder.<VelociraptorEggEntityEntity>of(VelociraptorEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(VelociraptorEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<OviraptorEggEntityEntity>> OVIRAPTOR_EGG_ENTITY = register("oviraptor_egg_entity",
			EntityType.Builder.<OviraptorEggEntityEntity>of(OviraptorEggEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OviraptorEggEntityEntity::new)

					.sized(0.2f, 0.3f));
	public static final RegistryObject<EntityType<PaleontologistEntity>> PALEONTOLOGIST = register("paleontologist",
			EntityType.Builder.<PaleontologistEntity>of(PaleontologistEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PaleontologistEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TranqualizerDartEntity>> TRANQUALIZER_DART = register("projectile_tranqualizer_dart", EntityType.Builder.<TranqualizerDartEntity>of(TranqualizerDartEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TranqualizerDartEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AnkylosaurusEggEntityEntity.init();
			TyrannosaurausEggEntityEntity.init();
			BrachiosaurusEggEntityEntity.init();
			CarnotaurusEggEntityEntity.init();
			CompsognathusEggEntityEntity.init();
			DilophosaurusEggEntityEntity.init();
			DryosaurusEggEntityEntity.init();
			PachycephalosaurusEggEntityEntity.init();
			PteranodonEggEntityEntity.init();
			StegosaurusEggEntityEntity.init();
			TriceratopsEggEntityEntity.init();
			CryolophosaurusEggEntityEntity.init();
			DimetrodonEggEntityEntity.init();
			GalimimusEggEntityEntity.init();
			SpinosaurusEggEntityEntity.init();
			VelociraptorEggEntityEntity.init();
			OviraptorEggEntityEntity.init();
			PaleontologistEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ANKYLOSAURUS_EGG_ENTITY.get(), AnkylosaurusEggEntityEntity.createAttributes().build());
		event.put(TYRANNOSAURAUS_EGG_ENTITY.get(), TyrannosaurausEggEntityEntity.createAttributes().build());
		event.put(BRACHIOSAURUS_EGG_ENTITY.get(), BrachiosaurusEggEntityEntity.createAttributes().build());
		event.put(CARNOTAURUS_EGG_ENTITY.get(), CarnotaurusEggEntityEntity.createAttributes().build());
		event.put(COMPSOGNATHUS_EGG_ENTITY.get(), CompsognathusEggEntityEntity.createAttributes().build());
		event.put(DILOPHOSAURUS_EGG_ENTITY.get(), DilophosaurusEggEntityEntity.createAttributes().build());
		event.put(DRYOSAURUS_EGG_ENTITY.get(), DryosaurusEggEntityEntity.createAttributes().build());
		event.put(PACHYCEPHALOSAURUS_EGG_ENTITY.get(), PachycephalosaurusEggEntityEntity.createAttributes().build());
		event.put(PTERANODON_EGG_ENTITY.get(), PteranodonEggEntityEntity.createAttributes().build());
		event.put(STEGOSAURUS_EGG_ENTITY.get(), StegosaurusEggEntityEntity.createAttributes().build());
		event.put(TRICERATOPS_EGG_ENTITY.get(), TriceratopsEggEntityEntity.createAttributes().build());
		event.put(CRYOLOPHOSAURUS_EGG_ENTITY.get(), CryolophosaurusEggEntityEntity.createAttributes().build());
		event.put(DIMETRODON_EGG_ENTITY.get(), DimetrodonEggEntityEntity.createAttributes().build());
		event.put(GALIMIMUS_EGG_ENTITY.get(), GalimimusEggEntityEntity.createAttributes().build());
		event.put(SPINOSAURUS_EGG_ENTITY.get(), SpinosaurusEggEntityEntity.createAttributes().build());
		event.put(VELOCIRAPTOR_EGG_ENTITY.get(), VelociraptorEggEntityEntity.createAttributes().build());
		event.put(OVIRAPTOR_EGG_ENTITY.get(), OviraptorEggEntityEntity.createAttributes().build());
		event.put(PALEONTOLOGIST.get(), PaleontologistEntity.createAttributes().build());
	}
}
