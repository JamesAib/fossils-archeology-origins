package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.StegosaurusEntity;

public class StegosaurusModel extends AnimatedGeoModel<StegosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(StegosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/stegosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(StegosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/stegosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(StegosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
