package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.AnkylosaurusEntity;

public class AnkylosaurusModel extends AnimatedGeoModel<AnkylosaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnkylosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/ankylosaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnkylosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/ankylosaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnkylosaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
