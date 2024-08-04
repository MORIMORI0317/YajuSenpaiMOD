package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.util.YJUtils;

public final class YJCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(YajuSenpai.MODID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> MOD_TAB = TABS.register(YajuSenpai.MODID, () ->
            CreativeTabRegistry.create(builder -> {
                builder.title(Component.translatable("itemGroup." + YajuSenpai.MODID + "." + YajuSenpai.MODID));
                builder.icon(() -> new ItemStack(YJItems.ICON.get()));
                builder.backgroundTexture(YJUtils.modLoc("textures/gui/container/creative_inventory/tab_yjsnpi.png"));
            }));

    public static void init() {
        TABS.register();
    }
}
