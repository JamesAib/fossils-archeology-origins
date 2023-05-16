package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.DilophosaurusEntity;

public class DilophosaurusModel extends AnimatedGeoModel<DilophosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(DilophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/dilophosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DilophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/dilophosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DilophosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
