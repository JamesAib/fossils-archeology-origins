package com.praepositi.fossilsorigins.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import com.praepositi.fossilsorigins.entity.MosasaurusEntity;

public class MosasaurusModel extends AnimatedGeoModel<MosasaurusEntity> {
	@Override
	public ResourceLocation getAnimationResource(MosasaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "animations/mosasaurus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MosasaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "geo/mosasaurus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MosasaurusEntity entity) {
		return new ResourceLocation("fossilsorigins", "textures/entities/" + entity.getTexture() + ".png");
	}

}
