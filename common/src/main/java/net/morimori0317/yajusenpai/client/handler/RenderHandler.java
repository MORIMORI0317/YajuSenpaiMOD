package net.morimori0317.yajusenpai.client.handler;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.block.BigPillowBlock;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.client.util.YJRenderUtils;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;

public class RenderHandler {
    public static void onLivingRenderPre(LivingEntity livingEntity, PoseStack poseStack) {
        poseStack.pushPose();
        var pos = ((YJLivingEntity) livingEntity).getSleepingPos();
        if (pos == null) return;

        if (!livingEntity.level().getBlockState(livingEntity.blockPosition()).is(YJBlocks.BIG_PILLOW.get()))
            return;

        var bs = livingEntity.level().getBlockState(pos);
        if (!bs.is(YJBlocks.BIG_PILLOW.get())) return;

        var direction = bs.getValue(BigPillowBlock.FACING);
        YJRenderUtils.poseRotateX(poseStack, 90f);

        if (direction == Direction.WEST) {
            YJRenderUtils.poseRotateZ(poseStack, 270);
        } else if (direction == Direction.EAST) {
            YJRenderUtils.poseRotateZ(poseStack, 90);
        } else if (direction == Direction.SOUTH) {
            YJRenderUtils.poseRotateZ(poseStack, 180);
        }

        poseStack.translate(0, -livingEntity.getBbHeight() + 1f / 16f * 2f, -livingEntity.getBbWidth() / 2 + 1f / 16f * 2);
    }

    public static void onLivingRenderPost(LivingEntity livingEntity, PoseStack poseStack) {
        poseStack.popPose();
    }
}
