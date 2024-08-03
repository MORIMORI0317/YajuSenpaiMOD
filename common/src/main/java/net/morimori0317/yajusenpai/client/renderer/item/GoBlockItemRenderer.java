package net.morimori0317.yajusenpai.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.client.util.YJModelUtils;
import net.morimori0317.yajusenpai.client.util.YJRenderUtils;
import org.joml.Math;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class GoBlockItemRenderer implements BEWLItemRenderer {
    private static final float HALF_SQRT_3 = (float) (Math.sqrt(3.0) / 2.0);

    @Override
    public void render(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, float delta, int light, int overlay) {
        BakedModel model = YJModelUtils.getModel(YJBlocks.GO_BLOCK.get().defaultBlockState());
        VertexConsumer vc = ItemRenderer.getFoilBufferDirect(multiBufferSource, Sheets.cutoutBlockSheet(), true, stack.hasFoil());

        poseStack.pushPose();

        poseStack.pushPose();

        if (displayContext == ItemDisplayContext.GUI) {
            poseStack.translate(0.5, 0.5, 0.5);
            poseStack.scale(0.625f, 0.625f, 0.625f);
            poseStack.mulPose((new Quaternionf()).rotationXYZ(30f * 0.017453292F, 225f * 0.017453292F, 0));
            poseStack.translate(-0.5, -0.5, -0.5);
        }

        YJRenderUtils.renderModel(poseStack, vc, model, LightTexture.FULL_BRIGHT, overlay);
        poseStack.popPose();

        if (displayContext == ItemDisplayContext.GUI) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, -0.5f);
            poseStack.scale(0.06f, 0.06f, Mth.EPSILON);
            long time = 114514;
            float par = (System.currentTimeMillis() % time) / (float) time;
            renderRays(poseStack, par, multiBufferSource.getBuffer(RenderType.dragonRays()));
            renderRays(poseStack, par, multiBufferSource.getBuffer(RenderType.dragonRaysDepth()));
            poseStack.popPose();
        }

        poseStack.popPose();
    }

    private static void renderRays(PoseStack poseStack, float par, VertexConsumer vertexConsumer) {
        poseStack.pushPose();
        int i = FastColor.ARGB32.colorFromFloat(1.0F, 1.0F, 1.0F, 1.0F);
        int color = 0xE6B422;
        RandomSource randomSource = RandomSource.create(432L);
        Vector3f vector3f = new Vector3f();
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        Vector3f vector3f4 = new Vector3f();
        Quaternionf quaternionf = new Quaternionf();

        for (int l = 0; l < 100; ++l) {
            quaternionf.rotationXYZ(
                            randomSource.nextFloat() * 6.2831855F,
                            randomSource.nextFloat() * 6.2831855F,
                            randomSource.nextFloat() * 6.2831855F)
                    .rotateXYZ(
                            randomSource.nextFloat() * 6.2831855F,
                            randomSource.nextFloat() * 6.2831855F,
                            randomSource.nextFloat() * 6.2831855F + par * 6.2831855F);
            poseStack.mulPose(quaternionf);
            float h = randomSource.nextFloat() * 20.0F + 5.0F;
            float m = randomSource.nextFloat() * 2.0F + 1.0F;
            vector3f2.set(-HALF_SQRT_3 * m, h, -0.5F * m);
            vector3f3.set(HALF_SQRT_3 * m, h, -0.5F * m);
            vector3f4.set(0.0F, h, m);
            PoseStack.Pose pose = poseStack.last();
            vertexConsumer.addVertex(pose, vector3f).setColor(i);
            vertexConsumer.addVertex(pose, vector3f2).setColor(color);
            vertexConsumer.addVertex(pose, vector3f3).setColor(color);
            vertexConsumer.addVertex(pose, vector3f).setColor(i);
            vertexConsumer.addVertex(pose, vector3f3).setColor(color);
            vertexConsumer.addVertex(pose, vector3f4).setColor(color);
            vertexConsumer.addVertex(pose, vector3f).setColor(i);
            vertexConsumer.addVertex(pose, vector3f4).setColor(color);
            vertexConsumer.addVertex(pose, vector3f2).setColor(color);
        }

        poseStack.popPose();
    }
}
