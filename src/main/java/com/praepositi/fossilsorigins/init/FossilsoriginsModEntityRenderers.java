
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.praepositi.fossilsorigins.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import com.praepositi.fossilsorigins.client.renderer.VelociraptorRenderer;
import com.praepositi.fossilsorigins.client.renderer.VelociraptorEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.TyrannosaurausRenderer;
import com.praepositi.fossilsorigins.client.renderer.TyrannosaurausEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.TriceratopsRenderer;
import com.praepositi.fossilsorigins.client.renderer.TriceratopsEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.StegosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.StegosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.SpinosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.SpinosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.PteranodonRenderer;
import com.praepositi.fossilsorigins.client.renderer.PteranodonEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.PlesiosuarusRenderer;
import com.praepositi.fossilsorigins.client.renderer.PaleontologistRenderer;
import com.praepositi.fossilsorigins.client.renderer.PachycephalosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.PachycephalosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.OviraptorRenderer;
import com.praepositi.fossilsorigins.client.renderer.OviraptorEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.MosasaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.GalimimusRenderer;
import com.praepositi.fossilsorigins.client.renderer.GalimimusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.DryosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.DryosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.DimetrodonRenderer;
import com.praepositi.fossilsorigins.client.renderer.DimetrodonEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.DilophosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.DilophosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.CryolophosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.CryolophosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.CompsognathusRenderer;
import com.praepositi.fossilsorigins.client.renderer.CompsognathusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.CarnotaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.CarnotaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.BrachiosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.BrachiosaurusEggEntityRenderer;
import com.praepositi.fossilsorigins.client.renderer.AnkylosaurusRenderer;
import com.praepositi.fossilsorigins.client.renderer.AnkylosaurusEggEntityRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FossilsoriginsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FossilsoriginsModEntities.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.ANKYLOSAURUS.get(), AnkylosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.CARNOTAURUS.get(), CarnotaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.COMPSOGNATHUS.get(), CompsognathusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.CRYOLOPHOSAURUS.get(), CryolophosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DIMETRODON.get(), DimetrodonRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DRYOSAURUS.get(), DryosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.GALIMIMUS.get(), GalimimusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.MOSASAURUS.get(), MosasaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.OVIRAPTOR.get(), OviraptorRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PACHYCEPHALOSAURUS.get(), PachycephalosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PLESIOSUARUS.get(), PlesiosuarusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PTERANODON.get(), PteranodonRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.SPINOSAURUS.get(), SpinosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.STEGOSAURUS.get(), StegosaurusRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.TYRANNOSAURAUS.get(), TyrannosaurausRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.TRICERATOPS.get(), TriceratopsRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.ANKYLOSAURUS_EGG_ENTITY.get(), AnkylosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.TYRANNOSAURAUS_EGG_ENTITY.get(), TyrannosaurausEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.BRACHIOSAURUS_EGG_ENTITY.get(), BrachiosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.CARNOTAURUS_EGG_ENTITY.get(), CarnotaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.COMPSOGNATHUS_EGG_ENTITY.get(), CompsognathusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DILOPHOSAURUS_EGG_ENTITY.get(), DilophosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DRYOSAURUS_EGG_ENTITY.get(), DryosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PACHYCEPHALOSAURUS_EGG_ENTITY.get(), PachycephalosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PTERANODON_EGG_ENTITY.get(), PteranodonEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.STEGOSAURUS_EGG_ENTITY.get(), StegosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.TRICERATOPS_EGG_ENTITY.get(), TriceratopsEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.CRYOLOPHOSAURUS_EGG_ENTITY.get(), CryolophosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.DIMETRODON_EGG_ENTITY.get(), DimetrodonEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.GALIMIMUS_EGG_ENTITY.get(), GalimimusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.SPINOSAURUS_EGG_ENTITY.get(), SpinosaurusEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.VELOCIRAPTOR_EGG_ENTITY.get(), VelociraptorEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.OVIRAPTOR_EGG_ENTITY.get(), OviraptorEggEntityRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.PALEONTOLOGIST.get(), PaleontologistRenderer::new);
		event.registerEntityRenderer(FossilsoriginsModEntities.TRANQUALIZER_DART.get(), ThrownItemRenderer::new);
	}
}
