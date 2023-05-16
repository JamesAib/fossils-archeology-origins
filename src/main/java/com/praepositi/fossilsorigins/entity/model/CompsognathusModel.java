package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.CompsognathusEntity;

public class CompsognathusModel extends AnimatedGeoModel<CompsognathusEntity> {
	@Override
	public ResourceLocation getAnimationResource(CompsognathusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/compsognathus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CompsognathusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/compsognathus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CompsognathusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
