
package com.praepositi.fossilsorigins.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.praepositi.fossilsorigins.entity.SpinosaurusEggEntityEntity;
import com.praepositi.fossilsorigins.client.model.ModelDino_EggSmall;

public class SpinosaurusEggEntityRenderer extends MobRenderer<SpinosaurusEggEntityEntity, ModelDino_EggSmall<SpinosaurusEggEntityEntity>> {
	public SpinosaurusEggEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDino_EggSmall(context.bakeLayer(ModelDino_EggSmall.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpinosaurusEggEntityEntity entity) {
		return new ResourceLocation("fossilsorigins:textures/entities/egg_texture.png");
	}
}
