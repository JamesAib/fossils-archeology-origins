package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.PachycephalosaurusEntity;

public class PachycephalosaurusModel extends AnimatedGeoModel<PachycephalosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(PachycephalosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/pachycephalosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PachycephalosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/pachycephalosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PachycephalosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
