package net.morimori0317.yajusenpai.client.renderer.item;

import net.morimori0317.yajusenpai.item.YJItems;

public class YJItemRenderers {
    public static void init() {
        ItemRendererRegister.register(YJItems.JAKEN_YORUIKIMASYOU_SHIELD, new JakenShieldItemRenderer());
    }
}
