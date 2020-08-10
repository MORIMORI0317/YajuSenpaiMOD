package net.morimori.yjsnpimod.client.handler;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.item.YJItems;
import red.felnull.otyacraftengine.client.util.IKSGRenderUtil;

public class RenderHandler {

    private static Minecraft mc = Minecraft.getInstance();
    public static final ResourceLocation CYCLOPS_SUNGLASSES = new ResourceLocation(YJSNPIMOD.MODID, "textures/misc/cyclops_sunglasses.png");

    @SubscribeEvent
    public static void onRender(TickEvent.RenderTickEvent e) {

        if (mc.player == null)
            return;

        MatrixStack matrix = new MatrixStack();

        if (mc.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == YJItems.CYCLOPS_SUNGLASSES) {
            int sizeX = mc.getMainWindow().getScaledWidth();
            int sizeY = mc.getMainWindow().getScaledHeight();
            IKSGRenderUtil.matrixPush(matrix);
            IKSGRenderUtil.matrixTranslatef(matrix, 0f, 0f, 500f);
            RenderSystem.enableBlend();
            IKSGRenderUtil.guiBindAndBlit(CYCLOPS_SUNGLASSES, matrix, 0, 0, 0, 0, sizeX, sizeY, sizeX, sizeY);
            RenderSystem.disableBlend();
            IKSGRenderUtil.matrixPop(matrix);
        }
    }

    @SubscribeEvent
    public static void onPreMobRender(RenderLivingEvent.Pre e) {
        Vector3d p = e.getEntity().getPositionVec();
        BlockState state = mc.player.world.getBlockState(new BlockPos(p.getX(), p.getY(), p.getZ()));

        if (state.getBlock() != YJBlocks.BIG_PILLOW)
            return;

        Direction direction = state.get(HorizontalBlock.HORIZONTAL_FACING);
        IKSGRenderUtil.matrixPush(e.getMatrixStack());
        IKSGRenderUtil.matrixRotateDegreefX(e.getMatrixStack(), 90f);
        if (direction == Direction.WEST) {
            IKSGRenderUtil.matrixRotateDegreefZ(e.getMatrixStack(), 270);
        } else if (direction == Direction.EAST) {
            IKSGRenderUtil.matrixRotateDegreefZ(e.getMatrixStack(), 90);
        } else if (direction == Direction.SOUTH) {
            IKSGRenderUtil.matrixRotateDegreefZ(e.getMatrixStack(), 180);
        }
        LivingEntity en = e.getEntity();
        IKSGRenderUtil.matrixTranslatef(e.getMatrixStack(), 0, -en.getHeight(), -en.getWidth() / 2);

    }

    @SubscribeEvent
    public static void onPostMobRender(RenderLivingEvent.Post e) {

        Vector3d p = e.getEntity().getPositionVec();
        BlockState state = mc.player.world.getBlockState(new BlockPos(p.getX(), p.getY(), p.getZ()));
        if (state.getBlock() != YJBlocks.BIG_PILLOW)
            return;

        IKSGRenderUtil.matrixPop(e.getMatrixStack());
    }
}
