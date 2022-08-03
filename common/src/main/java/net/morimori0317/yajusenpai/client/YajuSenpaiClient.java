package net.morimori0317.yajusenpai.client;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.client.renderer.YjBlockRenderTypes;
import net.morimori0317.yajusenpai.client.renderer.item.YJItemRenderers;
import net.morimori0317.yajusenpai.explatform.client.YJClientExpectPlatform;
import net.morimori0317.yajusenpai.item.YJItems;

public class YajuSenpaiClient {
    public static void init() {
        YjBlockRenderTypes.init();
        YJItemRenderers.init();


        YJClientExpectPlatform.registerItemProperties(YJItems.JAKEN_YORUIKIMASYOU_SHIELD.get(), new ResourceLocation("blocking"), (p_174590_, p_174591_, p_174592_, p_174593_) -> p_174592_ != null && p_174592_.isUsingItem() && p_174592_.getUseItem() == p_174590_ ? 1.0F : 0.0F);
        YJClientExpectPlatform.registerItemProperties(YJItems.SOFT_SMARTPHONE.get(), new ResourceLocation("using"), (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);
    }
}
