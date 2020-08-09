package net.morimori.yjsnpimod.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.tileentity.ToiletTileEntity;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;

public class ToiletTileEntityRenderer extends TileEntityRenderer<ToiletTileEntity> {

    private static final ResourceLocation huta = new ResourceLocation(YJSNPIMOD.MODID, "block/toilet_huta");

    public ToiletTileEntityRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(ToiletTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        IVertexBuilder ivb = bufferIn.getBuffer(RenderType.getSolid());
        BlockState state = tileEntityIn.getBlockState();
        IBakedModel door = IKSGRenderUtil.getBakedModel(huta);
        Direction direction = state.get(HorizontalBlock.HORIZONTAL_FACING);
        float pix = 1f / 16f;
        IKSGRenderUtil.matrixPush(matrixStackIn);
        if (direction == Direction.WEST) {
            IKSGRenderUtil.matrixRotateDegreefY(matrixStackIn, 180);
            IKSGRenderUtil.matrixTranslatef(matrixStackIn, -1f, 0f, -1f);
        } else if (direction == Direction.NORTH) {
            IKSGRenderUtil.matrixRotateDegreefY(matrixStackIn, 90);
            IKSGRenderUtil.matrixTranslatef(matrixStackIn, -1f, 0f, 0f);
        } else if (direction == Direction.SOUTH) {
            IKSGRenderUtil.matrixRotateDegreefY(matrixStackIn, 270);
            IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0f, 0f, -1f);
        }

        IKSGRenderUtil.matrixPush(matrixStackIn);
        IKSGRenderUtil.matrixRotateDegreefY(matrixStackIn, -90);
        IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0f, 0f, -1f);
        IKSGRenderUtil.matrixTranslatef(matrixStackIn, pix * 2, pix * 7, pix * -3);
        IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0, pix * 0.5f, pix * 15);
        IKSGRenderUtil.matrixRotateDegreefX(matrixStackIn, tileEntityIn.doorAngle);
        IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0, pix * -0.5f, pix * -15);
        IKSGRenderUtil.renderBlockBakedModel(door, matrixStackIn, ivb, combinedOverlayIn, tileEntityIn);
        IKSGRenderUtil.matrixPop(matrixStackIn);

        IKSGRenderUtil.matrixPop(matrixStackIn);

        ItemStack stack = tileEntityIn.getBukkakeItem();
        if (!stack.isEmpty()) {
            IKSGRenderUtil.matrixPush(matrixStackIn);
            IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0.5f, pix * 7f, 0.5f);
            IKSGRenderUtil.matrixRotateDegreefX(matrixStackIn, 90f);
            if (direction == Direction.NORTH) {
            } else if (direction == Direction.SOUTH) {
                IKSGRenderUtil.matrixRotateDegreefZ(matrixStackIn, 180f);
            } else if (direction == Direction.EAST) {
                IKSGRenderUtil.matrixRotateDegreefZ(matrixStackIn, 90f);
            } else if (direction == Direction.WEST) {
                IKSGRenderUtil.matrixRotateDegreefZ(matrixStackIn, 270f);
            }
            IKSGRenderUtil.matrixTranslatef(matrixStackIn, 0, pix * -3f, 0);
            IKSGRenderUtil.matrixScalf(matrixStackIn, 0.3f);
            Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
            IKSGRenderUtil.matrixPop(matrixStackIn);
        }
    }
}
