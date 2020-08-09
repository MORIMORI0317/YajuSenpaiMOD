package net.morimori.yjsnpimod.client.handler;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSNPIMOD;
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

}
