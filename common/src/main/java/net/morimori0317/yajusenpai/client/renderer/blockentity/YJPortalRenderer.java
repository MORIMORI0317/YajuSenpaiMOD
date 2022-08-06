package net.morimori0317.yajusenpai.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.blockentity.YJPortalBlockEntity;
import net.morimori0317.yajusenpai.client.renderer.YJRenderType;

public class YJPortalRenderer<T extends YJPortalBlockEntity> implements BlockEntityRenderer<T> {
    public static final ResourceLocation YJ_SKY_LOCATION = new ResourceLocation(YajuSenpai.MODID, "textures/block/yjsnpi_interview_block.png");
    public static final ResourceLocation YJ_PORTAL_LOCATION = new ResourceLocation(YajuSenpai.MODID, "textures/entity/yj_portal.png");
    private static final RenderType YJ_PORTAL = YJRenderType.yjPortal();

    @Override
    public void render(T theEndPortalBlockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Matrix4f matrix4f = poseStack.last().pose();
        this.renderCube(theEndPortalBlockEntity, matrix4f, multiBufferSource.getBuffer(this.renderType()));
    }

    private void renderCube(T theEndPortalBlockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
        float f = this.getOffsetDown();
        float g = this.getOffsetUp();
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, f, f, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
        this.renderFace(theEndPortalBlockEntity, matrix4f, vertexConsumer, 0.0F, 1.0F, g, g, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
    }

    private void renderFace(T theEndPortalBlockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float f, float g, float h, float i, float j, float k, float l, float m, Direction direction) {
        if (direction.getAxis() == Direction.Axis.Y) {
            vertexConsumer.vertex(matrix4f, f, h, j).endVertex();
            vertexConsumer.vertex(matrix4f, g, h, k).endVertex();
            vertexConsumer.vertex(matrix4f, g, i, l).endVertex();
            vertexConsumer.vertex(matrix4f, f, i, m).endVertex();
        }

    }

    protected float getOffsetUp() {
        return 0.75F;
    }

    protected float getOffsetDown() {
        return 0.375F;
    }

    protected RenderType renderType() {
        return YJ_PORTAL;
    }
}