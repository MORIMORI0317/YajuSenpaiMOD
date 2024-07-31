package net.morimori0317.yajusenpai.fabric.mixin.data;

import net.fabricmc.fabric.impl.registry.sync.DynamicRegistriesImpl;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;

@Mixin(DynamicRegistriesImpl.class)
public class DynamicRegistriesImplMixin {
    @Shadow(remap = false)
    @Final
    public static Set<ResourceKey<? extends Registry<?>>> DYNAMIC_REGISTRY_KEYS;

    @Shadow(remap = false)
    @Final
    private static List<RegistryDataLoader.RegistryData<?>> DYNAMIC_REGISTRIES;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void initInject(CallbackInfo ci) {
        DYNAMIC_REGISTRIES.addAll(RegistryDataLoader.DIMENSION_REGISTRIES);
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void initInject2(CallbackInfo ci) {
        for (RegistryDataLoader.RegistryData<?> vanillaEntry : RegistryDataLoader.DIMENSION_REGISTRIES) {
            DYNAMIC_REGISTRY_KEYS.add(vanillaEntry.key());
        }
    }
}
