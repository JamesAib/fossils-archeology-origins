package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.OviraptorEntity;

public class OviraptorModel extends AnimatedGeoModel<OviraptorEntity> {
	@Override
	public ResourceLocation getAnimationResource(OviraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/oviraptor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OviraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/oviraptor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OviraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
