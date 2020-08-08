package net.morimori.yjsnpimod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class YJSoundEvents {
    public static final SoundEvent YJ_BUTTIPA = newSound("yj.buttipa");
    public static final SoundEvent YJ_DASOUTOOMOEBA = newSound("yj.dasoutoomoeba");
    public static final SoundEvent YJ_DEDEMASUYO = newSound("yj.dedemasuyo");
    public static final SoundEvent YJ_FA = newSound("yj.fa");
    public static final SoundEvent YJ_FOOKIMATII = newSound("yj.fookimatii");
    public static final SoundEvent YJ_GAKUSEIDESU = newSound("yj.gakuseidesu");
    public static final SoundEvent YJ_HORAHORAHORA = newSound("yj.horahorahora");
    public static final SoundEvent YJ_HUN = newSound("yj.hun");
    public static final SoundEvent YJ_IIYOKOIYO = newSound("yj.iiyokoiyo");
    public static final SoundEvent YJ_IKISUGI = newSound("yj.ikisugi");
    public static final SoundEvent YJ_KATAKU = newSound("yj.kataku");
    public static final SoundEvent YJ_MAZUUTISAXA = newSound("yj.mazuutisaxa");
    public static final SoundEvent YJ_MEZIKARA = newSound("yj.mezikara");
    public static final SoundEvent YJ_NIJUYONSAI = newSound("yj.nijuyonsai");
    public static final SoundEvent YJ_NNA = newSound("yj.nna");
    public static final SoundEvent YJ_NU = newSound("yj.nu");
    public static final SoundEvent YJ_NUWATIKARETA = newSound("yj.nuwatikareta");
    public static final SoundEvent YJ_ON = newSound("yj.on");
    public static final SoundEvent YJ_ONAON = newSound("yj.onaon");
    public static final SoundEvent YJ_OSUONEGAI = newSound("yj.osuonegai");
    public static final SoundEvent YJ_SYU = newSound("yj.syu");
    public static final SoundEvent YJ_TAIZYUANDSINTYOU = newSound("yj.taizyuandsintyou");
    public static final SoundEvent YJ_YARIMASUNEXE = newSound("yj.yarimasunexe");
    public static final SoundEvent YJ_YOKUWAKARANAKATTADESU = newSound("yj.yokuwakaranakattadesu");
    public static final SoundEvent YJ_ZA = newSound("yj.za");

    public static final SoundEvent YJ_BREAK = newSound("yj.break");
    public static final SoundEvent YJ_PLACE = newSound("yj.place");
    public static final SoundEvent YJ_STEP = newSound("yj.step");
    public static final SoundEvent YJ_HIT = newSound("yj.hit");
    public static final SoundEvent YJ_FALL = newSound("yj.fall");
    public static final SoundEvent YJ_EQUIP = newSound("yj.equip");

    public static final SoundEvent YJ_PROLIFERATION = newSound("yj.proliferation");
    public static final SoundEvent YJ_ANTIPROLIFERATION = newSound("yj.antiproliferation");

    public static void registerSoundEvent(IForgeRegistry<SoundEvent> r) {
        registrySoundEvent(r, YJ_BUTTIPA);
        registrySoundEvent(r, YJ_NNA);
        registrySoundEvent(r, YJ_DASOUTOOMOEBA);
        registrySoundEvent(r, YJ_DEDEMASUYO);
        registrySoundEvent(r, YJ_FA);
        registrySoundEvent(r, YJ_FOOKIMATII);
        registrySoundEvent(r, YJ_GAKUSEIDESU);
        registrySoundEvent(r, YJ_HORAHORAHORA);
        registrySoundEvent(r, YJ_HUN);
        registrySoundEvent(r, YJ_IIYOKOIYO);
        registrySoundEvent(r, YJ_IKISUGI);
        registrySoundEvent(r, YJ_KATAKU);
        registrySoundEvent(r, YJ_MAZUUTISAXA);
        registrySoundEvent(r, YJ_MEZIKARA);
        registrySoundEvent(r, YJ_NIJUYONSAI);
        registrySoundEvent(r, YJ_NNA);
        registrySoundEvent(r, YJ_NU);
        registrySoundEvent(r, YJ_NUWATIKARETA);
        registrySoundEvent(r, YJ_ON);
        registrySoundEvent(r, YJ_ONAON);
        registrySoundEvent(r, YJ_OSUONEGAI);
        registrySoundEvent(r, YJ_SYU);
        registrySoundEvent(r, YJ_TAIZYUANDSINTYOU);
        registrySoundEvent(r, YJ_YARIMASUNEXE);
        registrySoundEvent(r, YJ_YOKUWAKARANAKATTADESU);
        registrySoundEvent(r, YJ_ZA);

        registrySoundEvent(r, YJ_BREAK);
        registrySoundEvent(r, YJ_PLACE);
        registrySoundEvent(r, YJ_STEP);
        registrySoundEvent(r, YJ_HIT);
        registrySoundEvent(r, YJ_FALL);
        registrySoundEvent(r, YJ_EQUIP);

        registrySoundEvent(r, YJ_PROLIFERATION);
        registrySoundEvent(r, YJ_ANTIPROLIFERATION);
    }

    private static void registrySoundEvent(IForgeRegistry<SoundEvent> r, SoundEvent s) {
        r.register(s);
    }

    public static SoundEvent newSound(String name) {
        return new SoundEvent(new ResourceLocation(YJSNPIMOD.MODID, name)).setRegistryName(name);
    }
}
