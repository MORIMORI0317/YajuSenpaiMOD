package net.morimori.yjsnpimod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class YJSoundEvents {
    public static final SoundEvent YJ_NNA = newSound("yj.nna");
    public static final SoundEvent YJ_HUN = newSound("yj.hun");
    public static final SoundEvent YJ_ON = newSound("yj.on");
    public static final SoundEvent YJ_FOOKIMATII = newSound("yj.fookimatii");
    public static final SoundEvent YJ_BUTTIPA = newSound("yj.buttipa");

    public static void registerSoundEvent(IForgeRegistry<SoundEvent> r) {
        registrySoundEvent(r, YJ_NNA);
        registrySoundEvent(r, YJ_HUN);
        registrySoundEvent(r, YJ_ON);
        registrySoundEvent(r, YJ_FOOKIMATII);
        registrySoundEvent(r, YJ_BUTTIPA);
    }

    private static void registrySoundEvent(IForgeRegistry<SoundEvent> r, SoundEvent s) {
        r.register(s);
    }

    public static SoundEvent newSound(String name) {
        return new SoundEvent(new ResourceLocation(YJSNPIMOD.MODID, name)).setRegistryName(name);
    }
}
