package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.VelociraptorEntity;

public class VelociraptorModel extends AnimatedGeoModel<VelociraptorEntity> {
	@Override
	public ResourceLocation getAnimationResource(VelociraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/velociraptor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VelociraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/velociraptor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VelociraptorEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
