package net.morimori0317.yajusenpai.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import org.jetbrains.annotations.NotNull;

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
}
