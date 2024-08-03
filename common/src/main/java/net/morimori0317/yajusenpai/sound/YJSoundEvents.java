package net.morimori0317.yajusenpai.sound;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YJSoundEvents {
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(YajuSenpai.MODID, Registries.SOUND_EVENT);
    public static final RegistrySupplier<SoundEvent> YJ_BUTTIPA = register("yj.buttipa");
    public static final RegistrySupplier<SoundEvent> YJ_DASOUTOOMOEBA = register("yj.dasoutoomoeba");
    public static final RegistrySupplier<SoundEvent> YJ_DEDEMASUYO = register("yj.dedemasuyo");
    public static final RegistrySupplier<SoundEvent> YJ_FA = register("yj.fa");
    public static final RegistrySupplier<SoundEvent> YJ_FOOKIMATII = register("yj.fookimatii");
    public static final RegistrySupplier<SoundEvent> YJ_GAKUSEIDESU = register("yj.gakuseidesu");
    public static final RegistrySupplier<SoundEvent> YJ_HORAHORAHORA = register("yj.horahorahora");
    public static final RegistrySupplier<SoundEvent> YJ_HUN = register("yj.hun");
    public static final RegistrySupplier<SoundEvent> YJ_IIYOKOIYO = register("yj.iiyokoiyo");
    public static final RegistrySupplier<SoundEvent> YJ_IKISUGI = register("yj.ikisugi");
    public static final RegistrySupplier<SoundEvent> YJ_KATAKU = register("yj.kataku");
    public static final RegistrySupplier<SoundEvent> YJ_MAZUUTISAXA = register("yj.mazuutisaxa");
    public static final RegistrySupplier<SoundEvent> YJ_NIJUYONSAI = register("yj.nijuyonsai");
    public static final RegistrySupplier<SoundEvent> YJ_NNA = register("yj.nna");
    public static final RegistrySupplier<SoundEvent> YJ_NU = register("yj.nu");
    public static final RegistrySupplier<SoundEvent> YJ_NUWATIKARETA = register("yj.nuwatikareta");
    public static final RegistrySupplier<SoundEvent> YJ_ON = register("yj.on");
    public static final RegistrySupplier<SoundEvent> YJ_ONAON = register("yj.onaon");
    public static final RegistrySupplier<SoundEvent> YJ_OSUONEGAI = register("yj.osuonegai");
    public static final RegistrySupplier<SoundEvent> YJ_SYU = register("yj.syu");
    public static final RegistrySupplier<SoundEvent> YJ_TAIZYUANDSINTYOU = register("yj.taizyuandsintyou");
    public static final RegistrySupplier<SoundEvent> YJ_YARIMASUNEXE = register("yj.yarimasunexe");
    public static final RegistrySupplier<SoundEvent> YJ_YOKUWAKARANAKATTADESU = register("yj.yokuwakaranakattadesu");
    public static final RegistrySupplier<SoundEvent> YJ_ZA = register("yj.za");
    public static final RegistrySupplier<SoundEvent> YJ_OTTODAIJOUBUKA = register("yj.ottodaijoubuka");
    public static final RegistrySupplier<SoundEvent> YJ_BUTTIPA_MIZIKAME = register("yj.buttipa_mizikame");

    public static final RegistrySupplier<SoundEvent> YJ_BREAK = register("yj.break");
    public static final RegistrySupplier<SoundEvent> YJ_PLACE = register("yj.place");
    public static final RegistrySupplier<SoundEvent> YJ_STEP = register("yj.step");
    public static final RegistrySupplier<SoundEvent> YJ_HIT = register("yj.hit");
    public static final RegistrySupplier<SoundEvent> YJ_FALL = register("yj.fall");
    public static final RegistrySupplier<SoundEvent> YJ_EQUIP = register("yj.equip");

    public static final RegistrySupplier<SoundEvent> YJ_PROLIFERATION = register("yj.proliferation");
    public static final RegistrySupplier<SoundEvent> YJ_ANTIPROLIFERATION = register("yj.antiproliferation");
    public static final RegistrySupplier<SoundEvent> YJ_DAMEGE = register("yj.damege");
    public static final RegistrySupplier<SoundEvent> YJ_OVERWRITE = register("yj.overwrite");
    public static final RegistrySupplier<SoundEvent> YJ_ATTACK = register("yj.attack");
    public static final RegistrySupplier<SoundEvent> YJ_DIE = register("yj.die");

    public static final RegistrySupplier<SoundEvent> YJ_ABARENNAYO = register("yj.abarennayo");
    public static final RegistrySupplier<SoundEvent> YJ_BRIEF = register("yj.brief");
    public static final RegistrySupplier<SoundEvent> YJ_KUCHIAKEENAHORA = register("yj.kuchiakeenahora");

    public static final RegistrySupplier<SoundEvent> YJ_ATTACK_ICE_TEA = register("yj.attack_ice_tea");
    public static final RegistrySupplier<SoundEvent> YJ_MOOD = register("yj.mood");

    public static final RegistrySupplier<SoundEvent> MEDIKARA_ALL = register("medikara.all");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_N1 = register("medikara.n1");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_N2 = register("medikara.n2");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_N3 = register("medikara.n3");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_HONTAI = register("medikara.hontai");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_MAEBURI = register("medikara.maeburi");
    public static final RegistrySupplier<SoundEvent> MEDIKARA_NS = register("medikara.ns");

    public static final RegistrySupplier<SoundEvent> TON_ALL = register("ton.all");
    public static final RegistrySupplier<SoundEvent> TON_SEKAINOTON = register("ton.sekainoton");
    public static final RegistrySupplier<SoundEvent> TON_A1 = register("ton.a1");
    public static final RegistrySupplier<SoundEvent> TON_A2 = register("ton.a2");
    public static final RegistrySupplier<SoundEvent> TON_A3 = register("ton.a3");
    public static final RegistrySupplier<SoundEvent> TON_A4 = register("ton.a4");
    public static final RegistrySupplier<SoundEvent> TON_STAGGER = register("ton.stagger");

    public static final RegistrySupplier<SoundEvent> CYCLOPS_POPOPOPO = register("cyclops.popopopo");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_AIKISO = register("cyclops.aikiso");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_BADY = register("cyclops.bady");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_CAPTURE = register("cyclops.capture");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_EVERY = register("cyclops.every");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_NAZOOTO = register("cyclops.nazooto");
    public static final RegistrySupplier<SoundEvent> CYCLOPS_SANDSTOME = register("cyclops.sandstome");

    public static final RegistrySupplier<SoundEvent> CYCLOPS_SANGRASSED = register("cyclops.sangrassed");

    public static final RegistrySupplier<SoundEvent> YJ_DOOR_OPEN = register("yj.door_open");
    public static final RegistrySupplier<SoundEvent> YJ_DOOR_CLOSE = register("yj.door_close");
    public static final RegistrySupplier<SoundEvent> YJ_BU = register("yj.bu");
    public static final RegistrySupplier<SoundEvent> YJ_TI = register("yj.ti");
    public static final RegistrySupplier<SoundEvent> YJ_PA = register("yj.pa");
    public static final RegistrySupplier<SoundEvent> KATYOU_NYA = register("katyou.nya");
    public static final RegistrySupplier<SoundEvent> KATYOU_BROKEN = register("katyou.broken");
    public static final RegistrySupplier<SoundEvent> KATYOU = register("katyou");
    public static final RegistrySupplier<SoundEvent> YJ_IKISUGI_EXPLODING = register("yj.ikisugi_exploding");
    public static final RegistrySupplier<SoundEvent> YJ_IKISUGI_ONRY = register("yj.ikisugi_onry");

    public static final RegistrySupplier<SoundEvent> TON_AAIISSUNE = register("ton.aaiissune");
    public static final RegistrySupplier<SoundEvent> TON_HAESUGGOIOOKII = register("ton.haesuggoiookii");
    public static final RegistrySupplier<SoundEvent> TON_HONOTUNIOOKKIISUNE = register("ton.honotuniookkiisune");
    public static final RegistrySupplier<SoundEvent> TON_IYTYOTTOHONTONI = register("ton.iytyottohontoni");
    public static final RegistrySupplier<SoundEvent> TON_KYOUHATUKAREMASITAYO = register("ton.kyouhatukaremasitayo");
    public static final RegistrySupplier<SoundEvent> TON_MAZUIDESUYO = register("ton.mazuidesuyo");
    public static final RegistrySupplier<SoundEvent> TON_NANISURUNSUKA = register("ton.nanisurunsuka");
    public static final RegistrySupplier<SoundEvent> TON_SENAPAI = register("ton.senapai");
    public static final RegistrySupplier<SoundEvent> TON_TADOKOROSANMAZUIDESUYO = register("ton.tadokorosanmazuidesuyo");
    public static final RegistrySupplier<SoundEvent> TON_UMOU = register("ton.umou");
    public static final RegistrySupplier<SoundEvent> TON_YAMETEKUDASAIYO = register("ton.yametekudasaiyo");
    public static final RegistrySupplier<SoundEvent> TON_YAMETEKUDASAIYOHONOTNI = register("ton.yametekudasaiyohonotni");

    public static final RegistrySupplier<SoundEvent> TON_BREAK = register("ton.break");
    public static final RegistrySupplier<SoundEvent> TON_PLACE = register("ton.place");
    public static final RegistrySupplier<SoundEvent> TON_STEP = register("ton.step");
    public static final RegistrySupplier<SoundEvent> TON_HIT = register("ton.hit");
    public static final RegistrySupplier<SoundEvent> TON_FALL = register("ton.fall");
    public static final RegistrySupplier<SoundEvent> TON_ATTACK = register("ton.attack");
    public static final RegistrySupplier<SoundEvent> TON_DAMAGE = register("ton.damage");
    public static final RegistrySupplier<SoundEvent> TON_DIE = register("ton.die");

    public static final RegistrySupplier<SoundEvent> KMR_ARIGATOGOZAIMASU = register("kmr.arigatogozaimasu");
    public static final RegistrySupplier<SoundEvent> KMR_E = register("kmr.e");
    public static final RegistrySupplier<SoundEvent> KMR_IYAMITENAIDESUYO = register("kmr.iyamitenaidesuyo");
    public static final RegistrySupplier<SoundEvent> KMR_IYASONNNAKOTO = register("kmr.iyasonnnakoto");
    public static final RegistrySupplier<SoundEvent> KMR_IYAXASONNA = register("kmr.iyaxasonna");
    public static final RegistrySupplier<SoundEvent> KMR_NANDEMIRUHITUYOUGAARUNDESUKA = register("kmr.nandemiruhituyougaarundesuka");
    public static final RegistrySupplier<SoundEvent> KMR_NAOKIDESU = register("kmr.naokidesu");
    public static final RegistrySupplier<SoundEvent> KMR_YAMETEKUREYO = register("kmr.yametekureyo");

    public static final RegistrySupplier<SoundEvent> KMR_BREAK = register("kmr.break");
    public static final RegistrySupplier<SoundEvent> KMR_PLACE = register("kmr.place");
    public static final RegistrySupplier<SoundEvent> KMR_STEP = register("kmr.step");
    public static final RegistrySupplier<SoundEvent> KMR_HIT = register("kmr.hit");
    public static final RegistrySupplier<SoundEvent> KMR_FALL = register("kmr.fall");
    public static final RegistrySupplier<SoundEvent> KMR_ATTACK = register("kmr.attack");
    public static final RegistrySupplier<SoundEvent> KMR_DAMAGE = register("kmr.damage");
    public static final RegistrySupplier<SoundEvent> KMR_DIE = register("kmr.die");

    public static final RegistrySupplier<SoundEvent> MUR_ASSOKKA = register("mur.assokka");
    public static final RegistrySupplier<SoundEvent> MUR_ATARIMAEDAYONA = register("mur.atarimaedayona");
    public static final RegistrySupplier<SoundEvent> MUR_ATTU = register("mur.attu");
    public static final RegistrySupplier<SoundEvent> MUR_DOUSUKKANA = register("mur.dousukkana");
    public static final RegistrySupplier<SoundEvent> MUR_HARAHETTANA = register("mur.harahettana");
    public static final RegistrySupplier<SoundEvent> MUR_IIZOKORE = register("mur.iizokore");
    public static final RegistrySupplier<SoundEvent> MUR_IKITEENA = register("mur.ikiteena");
    public static final RegistrySupplier<SoundEvent> MUR_MIROYOMIROYO = register("mur.miroyomiroyo");
    public static final RegistrySupplier<SoundEvent> MUR_MITAKERYAMISETEYARUYO = register("mur.mitakeryamiseteyaruyo");
    public static final RegistrySupplier<SoundEvent> MUR_OIMATE = register("mur.oimate");
    public static final RegistrySupplier<SoundEvent> MUR_OSSUDANA = register("mur.ossudana");
    public static final RegistrySupplier<SoundEvent> MUR_POTTYAMA = register("mur.pottyama");
    public static final RegistrySupplier<SoundEvent> MUR_SOUDAYO = register("mur.soudayo");
    public static final RegistrySupplier<SoundEvent> MUR_SUGGEKITUKATTAZO = register("mur.suggekitukattazo");
    public static final RegistrySupplier<SoundEvent> MUR_TIRATIRAMITETADARO = register("mur.tiratiramitetadaro");
    public static final RegistrySupplier<SoundEvent> MUR_URESIIDARO = register("mur.uresiidaro");
    public static final RegistrySupplier<SoundEvent> MUR_USOTUKEZETTAIMITETAZO = register("mur.usotukezettaimitetazo");

    public static final RegistrySupplier<SoundEvent> MUR_BREAK = register("mur.break");
    public static final RegistrySupplier<SoundEvent> MUR_PLACE = register("mur.place");
    public static final RegistrySupplier<SoundEvent> MUR_STEP = register("mur.step");
    public static final RegistrySupplier<SoundEvent> MUR_HIT = register("mur.hit");
    public static final RegistrySupplier<SoundEvent> MUR_FALL = register("mur.fall");
    public static final RegistrySupplier<SoundEvent> MUR_ATTACK = register("mur.attack");
    public static final RegistrySupplier<SoundEvent> MUR_DAMAGE = register("mur.damage");
    public static final RegistrySupplier<SoundEvent> MUR_DIE = register("mur.die");

    public static final RegistrySupplier<SoundEvent> GABAANADADDY_OREMOITCHAU = register("gabaanadaddy.oremoitchau");
    public static final RegistrySupplier<SoundEvent> GABAANADADDY_FUTOI_SEA_CHICKEN_GAHOSHII = register("gabaanadaddy.futoi_sea_chicken_gahoshii");
    public static final RegistrySupplier<SoundEvent> GABAANADADDY_ARCHER = register("gabaanadaddy.archer");
    public static final RegistrySupplier<SoundEvent> GABAANADADDY_IKUYO = register("gabaanadaddy.ikuyo");
    public static final RegistrySupplier<SoundEvent> GABAANADADDY_OISHII = register("gabaanadaddy.oishii");

    public static final RegistrySupplier<SoundEvent> KYN_ATUI1 = register("kyn.atui1");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI2 = register("kyn.atui2");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI3 = register("kyn.atui3");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI4 = register("kyn.atui4");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI5 = register("kyn.atui5");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI6 = register("kyn.atui6");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI7 = register("kyn.atui7");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI8 = register("kyn.atui8");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI9 = register("kyn.atui9");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI10 = register("kyn.atui10");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI11 = register("kyn.atui11");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI12 = register("kyn.atui12");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI13 = register("kyn.atui13");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI14 = register("kyn.atui14");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI15 = register("kyn.atui15");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI16 = register("kyn.atui16");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI17 = register("kyn.atui17");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI18 = register("kyn.atui18");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI19 = register("kyn.atui19");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI20 = register("kyn.atui20");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI21 = register("kyn.atui21");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI22 = register("kyn.atui22");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI23 = register("kyn.atui23");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI24 = register("kyn.atui24");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI25 = register("kyn.atui25");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI26 = register("kyn.atui26");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI27 = register("kyn.atui27");
    public static final RegistrySupplier<SoundEvent> KYN_ATUI28 = register("kyn.atui28");

    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_END = register("takeda_inm.end");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_WAIT = register("takeda_inm.wait");

    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_BREAK = register("takeda_inm.break");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_PLACE = register("takeda_inm.place");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_STEP = register("takeda_inm.step");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_HIT = register("takeda_inm.hit");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_FALL = register("takeda_inm.fall");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_ATTACK = register("takeda_inm.attack");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_DAMAGE = register("takeda_inm.damage");
    public static final RegistrySupplier<SoundEvent> TAKEDA_INM_DIE = register("takeda_inm.die");

    public static final RegistrySupplier<SoundEvent> NKTIDKSG_BREAK = register("nktidksg.break");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_PLACE = register("nktidksg.place");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_STEP = register("nktidksg.step");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_HIT = register("nktidksg.hit");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_FALL = register("nktidksg.fall");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_ATTACK = register("nktidksg.attack");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_DAMAGE = register("nktidksg.damage");
    public static final RegistrySupplier<SoundEvent> NKTIDKSG_DIE = register("nktidksg.die");

    public static final RegistrySupplier<SoundEvent> KATYOU_BREAK = register("katyou.break");
    public static final RegistrySupplier<SoundEvent> KATYOU_PLACE = register("katyou.place");
    public static final RegistrySupplier<SoundEvent> KATYOU_STEP = register("katyou.step");
    public static final RegistrySupplier<SoundEvent> KATYOU_HIT = register("katyou.hit");
    public static final RegistrySupplier<SoundEvent> KATYOU_FALL = register("katyou.fall");
    public static final RegistrySupplier<SoundEvent> KATYOU_ATTACK = register("katyou.attack");
    public static final RegistrySupplier<SoundEvent> KATYOU_DAMAGE = register("katyou.damage");
    public static final RegistrySupplier<SoundEvent> KATYOU_DIE = register("katyou.die");

    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_BREAK = register("second_inari_otoko.break");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_PLACE = register("second_inari_otoko.place");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_STEP = register("second_inari_otoko.step");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_HIT = register("second_inari_otoko.hit");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_FALL = register("second_inari_otoko.fall");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_ATTACK = register("second_inari_otoko.attack");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_DAMAGE = register("second_inari_otoko.damage");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_DIE = register("second_inari_otoko.die");
    public static final RegistrySupplier<SoundEvent> SECOND_INARI_OTOKO_EAT = register("second_inari_otoko.eat");

    public static final RegistrySupplier<SoundEvent> AKYS_BREAK = register("akys.break");
    public static final RegistrySupplier<SoundEvent> AKYS_PLACE = register("akys.place");
    public static final RegistrySupplier<SoundEvent> AKYS_STEP = register("akys.step");
    public static final RegistrySupplier<SoundEvent> AKYS_HIT = register("akys.hit");
    public static final RegistrySupplier<SoundEvent> AKYS_FALL = register("akys.fall");
    public static final RegistrySupplier<SoundEvent> AKYS_ATTACK = register("akys.attack");
    public static final RegistrySupplier<SoundEvent> AKYS_DAMAGE = register("akys.damage");
    public static final RegistrySupplier<SoundEvent> AKYS_DIE = register("akys.die");

    public static final RegistrySupplier<SoundEvent> GO_BREAK = register("go.break");
    public static final RegistrySupplier<SoundEvent> GO_PLACE = register("go.place");
    public static final RegistrySupplier<SoundEvent> GO_STEP = register("go.step");
    public static final RegistrySupplier<SoundEvent> GO_HIT = register("go.hit");
    public static final RegistrySupplier<SoundEvent> GO_FALL = register("go.fall");
    public static final RegistrySupplier<SoundEvent> GO_ATTACK = register("go.attack");
    public static final RegistrySupplier<SoundEvent> GO_DAMAGE = register("go.damage");
    public static final RegistrySupplier<SoundEvent> GO_DIE = register("go.die");

    public static final RegistrySupplier<SoundEvent> HIDE_BREAK = register("hide.break");
    public static final RegistrySupplier<SoundEvent> HIDE_PLACE = register("hide.place");
    public static final RegistrySupplier<SoundEvent> HIDE_STEP = register("hide.step");
    public static final RegistrySupplier<SoundEvent> HIDE_HIT = register("hide.hit");
    public static final RegistrySupplier<SoundEvent> HIDE_FALL = register("hide.fall");
    public static final RegistrySupplier<SoundEvent> HIDE_ATTACK = register("hide.attack");
    public static final RegistrySupplier<SoundEvent> HIDE_DAMAGE = register("hide.damage");
    public static final RegistrySupplier<SoundEvent> HIDE_DIE = register("hide.die");
    public static final RegistrySupplier<SoundEvent> HIDE_FIRE = register("hide.fire");
    public static final RegistrySupplier<SoundEvent> HIDE_WATER = register("hide.water");
    public static final RegistrySupplier<SoundEvent> HIDE_EXPLOSION = register("hide.explosion");

    private static RegistrySupplier<SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(YajuSenpai.MODID, name)));
    }

    public static void init() {
        SOUND_EVENTS.register();
    }
}
