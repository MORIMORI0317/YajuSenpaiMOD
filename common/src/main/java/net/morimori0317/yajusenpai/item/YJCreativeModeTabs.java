package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YJCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(YajuSenpai.MODID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> MOD_TAB = TABS.register(YajuSenpai.MODID, () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + YajuSenpai.MODID + "." + YajuSenpai.MODID), () -> new ItemStack(YJItems.ICON.get())));

    public static void init() {
        TABS.register();
    }
}
