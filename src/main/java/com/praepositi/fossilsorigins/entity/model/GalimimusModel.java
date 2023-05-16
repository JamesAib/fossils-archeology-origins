package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.GalimimusEntity;

public class GalimimusModel extends AnimatedGeoModel<GalimimusEntity> {
	@Override
	public ResourceLocation getAnimationResource(GalimimusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/gallimimus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GalimimusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/gallimimus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GalimimusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
