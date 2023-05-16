package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.TriceratopsEntity;

public class TriceratopsModel extends AnimatedGeoModel<TriceratopsEntity> {
	@Override
	public ResourceLocation getAnimationResource(TriceratopsEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/triceratops.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TriceratopsEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/triceratops.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TriceratopsEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
