package net.morimori.yjsnpimod.registry;

import net.fabricmc.fabric.impl.dimension.FabricDimensionInternals;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.HashMap;
import java.util.Map;

public class YJSoundEvents {
    private static final Map<ResourceLocation, SoundEvent> MOD_SOUNDEVENTS = new HashMap<>();
    public static final SoundEvent YJ_BUTTIPA = register("yj.buttipa");
    public static final SoundEvent YJ_DASOUTOOMOEBA = register("yj.dasoutoomoeba");
    public static final SoundEvent YJ_DEDEMASUYO = register("yj.dedemasuyo");
    public static final SoundEvent YJ_FA = register("yj.fa");
    public static final SoundEvent YJ_FOOKIMATII = register("yj.fookimatii");
    public static final SoundEvent YJ_GAKUSEIDESU = register("yj.gakuseidesu");
    public static final SoundEvent YJ_HORAHORAHORA = register("yj.horahorahora");
    public static final SoundEvent YJ_HUN = register("yj.hun");
    public static final SoundEvent YJ_IIYOKOIYO = register("yj.iiyokoiyo");
    public static final SoundEvent YJ_IKISUGI = register("yj.ikisugi");
    public static final SoundEvent YJ_KATAKU = register("yj.kataku");
    public static final SoundEvent YJ_MAZUUTISAXA = register("yj.mazuutisaxa");
    public static final SoundEvent YJ_NIJUYONSAI = register("yj.nijuyonsai");
    public static final SoundEvent YJ_NNA = register("yj.nna");
    public static final SoundEvent YJ_NU = register("yj.nu");
    public static final SoundEvent YJ_NUWATIKARETA = register("yj.nuwatikareta");
    public static final SoundEvent YJ_ON = register("yj.on");
    public static final SoundEvent YJ_ONAON = register("yj.onaon");
    public static final SoundEvent YJ_OSUONEGAI = register("yj.osuonegai");
    public static final SoundEvent YJ_SYU = register("yj.syu");
    public static final SoundEvent YJ_TAIZYUANDSINTYOU = register("yj.taizyuandsintyou");
    public static final SoundEvent YJ_YARIMASUNEXE = register("yj.yarimasunexe");
    public static final SoundEvent YJ_YOKUWAKARANAKATTADESU = register("yj.yokuwakaranakattadesu");
    public static final SoundEvent YJ_ZA = register("yj.za");
    public static final SoundEvent YJ_OTTODAIJOUBUKA = register("yj.ottodaijoubuka");
    public static final SoundEvent YJ_BUTTIPA_MIZIKAME = register("yj.buttipa_mizikame");


    public static final SoundEvent YJ_BREAK = register("yj.break");
    public static final SoundEvent YJ_PLACE = register("yj.place");
    public static final SoundEvent YJ_STEP = register("yj.step");
    public static final SoundEvent YJ_HIT = register("yj.hit");
    public static final SoundEvent YJ_FALL = register("yj.fall");
    public static final SoundEvent YJ_EQUIP = register("yj.equip");

    public static final SoundEvent YJ_PROLIFERATION = register("yj.proliferation");
    public static final SoundEvent YJ_ANTIPROLIFERATION = register("yj.antiproliferation");
    public static final SoundEvent YJ_DAMEGE = register("yj.damege");
    public static final SoundEvent YJ_OVERWRITE = register("yj.overwrite");
    public static final SoundEvent YJ_ATTACK = register("yj.attack");

    public static final SoundEvent MEZIKARA_ALL = register("mezikara.all");
    public static final SoundEvent MEZIKARA_N1 = register("mezikara.n1");
    public static final SoundEvent MEZIKARA_N2 = register("mezikara.n2");
    public static final SoundEvent MEZIKARA_N3 = register("mezikara.n3");
    public static final SoundEvent MEZIKARA_HONTAI = register("mezikara.hontai");
    public static final SoundEvent MEZIKARA_MAEBURI = register("mezikara.maeburi");
    public static final SoundEvent MEZIKARA_NS = register("mezikara.ns");

    public static final SoundEvent TON_ALL = register("ton.all");
    public static final SoundEvent TON_SEKAINOTON = register("ton.sekainoton");
    public static final SoundEvent TON_A1 = register("ton.a1");
    public static final SoundEvent TON_A2 = register("ton.a2");
    public static final SoundEvent TON_A3 = register("ton.a3");
    public static final SoundEvent TON_A4 = register("ton.a4");
    public static final SoundEvent TON_STAGGER = register("ton.stagger");

    public static final SoundEvent CYCLOPS_POPOPOPO = register("cyclops.popopopo");
    public static final SoundEvent CYCLOPS_AIKISO = register("cyclops.aikiso");
    public static final SoundEvent CYCLOPS_BADY = register("cyclops.bady");
    public static final SoundEvent CYCLOPS_CAPTURE = register("cyclops.capture");
    public static final SoundEvent CYCLOPS_EVERY = register("cyclops.every");
    public static final SoundEvent CYCLOPS_NAZOOTO = register("cyclops.nazooto");
    public static final SoundEvent CYCLOPS_SANDSTOME = register("cyclops.sandstome");

    public static final SoundEvent CYCLOPS_SANGRASSED = register("cyclops.sangrassed");

    public static final SoundEvent YJ_DOOR_OPEN = register("yj.door_open");
    public static final SoundEvent YJ_DOOR_CLOSE = register("yj.door_close");
    public static final SoundEvent YJ_BU = register("yj.bu");
    public static final SoundEvent YJ_TI = register("yj.ti");
    public static final SoundEvent YJ_PA = register("yj.pa");
    public static final SoundEvent KATYOU_NYA = register("katyou.nya");
    public static final SoundEvent KATYOU_BROKEN = register("katyou.broken");
    public static final SoundEvent KATYOU = register("katyou");
    public static final SoundEvent YJ_IKISUGI_EXPLODING = register("yj.ikisugi_exploding");
    public static final SoundEvent YJ_IKISUGI_ONRY = register("yj.ikisugi_onry");

    private static SoundEvent register(String name) {
        SoundEvent se = new SoundEvent(new ResourceLocation(YJSNPIMOD.MODID, name));
        MOD_SOUNDEVENTS.put(new ResourceLocation(YJSNPIMOD.MODID, name), se);
        return se;
    }

    public static void init() {
        MOD_SOUNDEVENTS.forEach((n, m) -> Registry.register(Registry.SOUND_EVENT, n, m));
    }
}
