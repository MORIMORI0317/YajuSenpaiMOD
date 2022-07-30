package net.morimori0317.yajusenpai.fabric.mixin.client;

import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.item.YJArmorMaterials;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(HumanoidArmorLayer.class)
public class HumanoidArmorLayerMixin {
    @Shadow
    @Final
    private static Map<String, ResourceLocation> ARMOR_LOCATION_CACHE;

    @Inject(method = "getArmorLocation", at = @At("HEAD"), cancellable = true)
    private void getArmorLocation(ArmorItem armorItem, boolean bl, String string, CallbackInfoReturnable<ResourceLocation> cir) {
        var mate = armorItem.getMaterial();
        if (mate instanceof YJArmorMaterials) {
            String var10000 = armorItem.getMaterial().getName();
            String string2 = YajuSenpai.MODID + ":textures/models/armor/" + var10000 + "_layer_" + (bl ? 2 : 1) + (string == null ? "" : "_" + string) + ".png";
            cir.setReturnValue(ARMOR_LOCATION_CACHE.computeIfAbsent(string2, ResourceLocation::new));
        }
    }
}
