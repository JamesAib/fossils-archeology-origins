package com.praepositi.fossilsorigins.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.praepositi.fossilsorigins.block.model.DNAInjectorBlockBlockModel;
import com.praepositi.fossilsorigins.block.entity.DNAInjectorBlockTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class DNAInjectorBlockTileRenderer extends GeoBlockRenderer<DNAInjectorBlockTileEntity> {
	public DNAInjectorBlockTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new DNAInjectorBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(DNAInjectorBlockTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
