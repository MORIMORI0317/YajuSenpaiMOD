package net.morimori0317.yajusenpai.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class YJRenderUtils {
    public static void poseRotateX(@NotNull PoseStack poseStack, float angle) {
        poseStack.mulPose(Axis.XP.rotationDegrees(angle));
    }

    public static void poseRotateY(@NotNull PoseStack poseStack, float angle) {
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
    }

    public static void poseRotateZ(@NotNull PoseStack poseStack, float angle) {
        poseStack.mulPose(Axis.ZP.rotationDegrees(angle));
    }

    public static float getPartialTicks() {
        Minecraft mc = Minecraft.getInstance();
        return mc.getTimer().getGameTimeDeltaPartialTick(true);
    }

    public static void renderModel(PoseStack poseStack, VertexConsumer vertexConsumer, @NotNull BakedModel bakedModel, int combinedLight, int combinedOverlay) {
        Objects.requireNonNull(bakedModel);
        Minecraft mc = Minecraft.getInstance();
        var bmr = mc.getBlockRenderer().getModelRenderer();
        bmr.renderModel(poseStack.last(), vertexConsumer, null, bakedModel, 1.0F, 1.0F, 1.0F, combinedLight, combinedOverlay);
    }
}
