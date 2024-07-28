package net.morimori0317.yajusenpai.client;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.jetbrains.annotations.Nullable;

public class YJItemProperties {
    public static final ResourceLocation SOFT_SMARTPHONE_USING = YJUtils.modLoc("using");
    public static final ResourceLocation O_BACK_ROTATION = YJUtils.modLoc("o_back_rotation");

    public static void init() {
        ItemPropertiesRegistry.register(YJItems.SOFT_SMARTPHONE.get(), SOFT_SMARTPHONE_USING, YJItemProperties::softSmartphoneUsing);
        ItemPropertiesRegistry.register(YJItems.O_BACK.get(), O_BACK_ROTATION, YJItemProperties::oBackRotation);
    }

    private static float softSmartphoneUsing(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
    }

    private static float oBackRotation(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        return stack.isEnchanted() ? 1.0F : 0.0F;
    }
}