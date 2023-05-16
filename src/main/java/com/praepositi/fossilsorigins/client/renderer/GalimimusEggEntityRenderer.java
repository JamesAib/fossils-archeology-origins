
package com.praepositi.fossilsorigins.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.praepositi.fossilsorigins.entity.GalimimusEggEntityEntity;
import com.praepositi.fossilsorigins.client.model.ModelDino_EggSmall;

public class GalimimusEggEntityRenderer extends MobRenderer<GalimimusEggEntityEntity, ModelDino_EggSmall<GalimimusEggEntityEntity>> {
	public GalimimusEggEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDino_EggSmall(context.bakeLayer(ModelDino_EggSmall.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GalimimusEggEntityEntity entity) {
		return new ResourceLocation("fossilsorigins:textures/entities/egg_texture.png");
	}
}
