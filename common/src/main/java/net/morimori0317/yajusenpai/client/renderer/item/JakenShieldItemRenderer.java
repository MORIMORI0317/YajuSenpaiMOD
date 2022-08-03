package net.morimori0317.yajusenpai.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.explatform.client.YJClientExpectPlatform;

public class JakenShieldItemRenderer implements BEWLItemRenderer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(YajuSenpai.MODID, "textures/entity/jaken_yoruikimasyou_shield.png");

    @Override
    public void render(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        var ber = YJClientExpectPlatform.getBlockEntityRenderer();

        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(multiBufferSource, ber.shieldModel.renderType(TEXTURE), true, stack.hasFoil());
        ber.shieldModel.handle().render(poseStack, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        ber.shieldModel.plate().render(poseStack, vertexConsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();
    }
}
