package net.morimori0317.yajusenpai.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public interface BEWLItemRenderer {
    void render(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, float delta, int light, int overlay);
}
