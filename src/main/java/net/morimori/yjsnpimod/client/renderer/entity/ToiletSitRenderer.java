package net.morimori.yjsnpimod.client.renderer.entity;

import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.morimori.yjsnpimod.entity.ToiletSitEntity;

public class ToiletSitRenderer extends EntityRenderer<ToiletSitEntity> {
    public ToiletSitRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public ResourceLocation getEntityTexture(ToiletSitEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(ToiletSitEntity entity, ClippingHelper camera, double camX, double camY, double camZ) {
        return false;
    }
}
