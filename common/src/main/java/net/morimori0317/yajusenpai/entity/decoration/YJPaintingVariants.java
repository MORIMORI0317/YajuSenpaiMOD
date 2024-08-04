package net.morimori0317.yajusenpai.entity.decoration;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJPaintingVariants {
    public static final ResourceKey<PaintingVariant> ART = key("art");
    public static final ResourceKey<PaintingVariant> BUTTIPA = key("buttipa");
    public static final ResourceKey<PaintingVariant> DEMASUYO = key("demasuyo");
    public static final ResourceKey<PaintingVariant> GANKOU = key("gankou");
    public static final ResourceKey<PaintingVariant> ICETEA = key("icetea");
    public static final ResourceKey<PaintingVariant> IKISUGI = key("ikisugi");
    public static final ResourceKey<PaintingVariant> INTERVIEW = key("interview");
    public static final ResourceKey<PaintingVariant> KANGAERU = key("kangaeru");
    public static final ResourceKey<PaintingVariant> KMR = key("kmr");
    public static final ResourceKey<PaintingVariant> KUGYOU = key("kugyou");
    public static final ResourceKey<PaintingVariant> LOGO = key("logo");
    public static final ResourceKey<PaintingVariant> MIACAT = key("miacat");
    public static final ResourceKey<PaintingVariant> MUR = key("mur");
    public static final ResourceKey<PaintingVariant> SANSYOU = key("sansyou");
    public static final ResourceKey<PaintingVariant> TADOKORO = key("tadokoro");
    public static final ResourceKey<PaintingVariant> YONSYOU = key("yonsyou");
    public static final ResourceKey<PaintingVariant> KATYOU = key("katyou");
    public static final ResourceKey<PaintingVariant> GENBAKANTOKU = key("genbakantoku");
    public static final ResourceKey<PaintingVariant> TNOK = key("tnok");
    public static final ResourceKey<PaintingVariant> WORLD_OF_TON = key("world_of_ton");
    public static final ResourceKey<PaintingVariant> RESTAURANT = key("restaurant");
    public static final ResourceKey<PaintingVariant> GABA_ANA_DADDY = key("gaba_ana_daddy");
    public static final ResourceKey<PaintingVariant> TON = key("ton");
    public static final ResourceKey<PaintingVariant> ITS_DOG = key("its_dog");
    public static final ResourceKey<PaintingVariant> CYCLOPES = key("cyclopes");
    public static final ResourceKey<PaintingVariant> TKD_INM = key("tkd_inm");
    public static final ResourceKey<PaintingVariant> NKOJ = key("nkoj");
    public static final ResourceKey<PaintingVariant> KUSO_DOKATA = key("kuso_dokata");
    public static final ResourceKey<PaintingVariant> GO_IS_GOD = key("go_is_god");
    public static final ResourceKey<PaintingVariant> TDN = key("tdn");
    public static final ResourceKey<PaintingVariant> DB = key("db");
    public static final ResourceKey<PaintingVariant> HTN = key("htn");
    public static final ResourceKey<PaintingVariant> KATYOU_2 = key("katyou_2");
    public static final ResourceKey<PaintingVariant> URTLMN = key("urtlmn");
    public static final ResourceKey<PaintingVariant> PINKY = key("pinky");
    public static final ResourceKey<PaintingVariant> THE_77SAI_KMMRKN = key("the_77sai_kmmrkn");
    public static final ResourceKey<PaintingVariant> NKN_KN = key("nkn_kn");
    public static final ResourceKey<PaintingVariant> KYN = key("kyn");
    public static final ResourceKey<PaintingVariant> AKG = key("akg");
    public static final ResourceKey<PaintingVariant> KBS = key("kbs");
    public static final ResourceKey<PaintingVariant> SUW_TNNU = key("suw_tnnu");
    public static final ResourceKey<PaintingVariant> UEKBTKN_AND_VOLLEYBALLKN = key("uekbtkn_and_volleyballkn");
    public static final ResourceKey<PaintingVariant> INR = key("inr");
    public static final ResourceKey<PaintingVariant> SANNIN_KATERU_WAKE_NAIDARO = key("sannin_kateru_wake_naidaro");
    public static final ResourceKey<PaintingVariant> SKRNB = key("skrnb");
    public static final ResourceKey<PaintingVariant> NKMR = key("nkmr");
    public static final ResourceKey<PaintingVariant> D10 = key("d10");
    public static final ResourceKey<PaintingVariant> YUSAKU = key("yusaku");
    public static final ResourceKey<PaintingVariant> KBTIT = key("kbtit");
    public static final ResourceKey<PaintingVariant> NKTIDKSG = key("nktidksg");
    public static final ResourceKey<PaintingVariant> SENPAI_SUKISSU = key("senpai_sukissu");
    public static final ResourceKey<PaintingVariant> KM_DGYN_INM = key("km_dgyn_inm");
    public static final ResourceKey<PaintingVariant> TKNUC = key("tknuc");
    public static final ResourceKey<PaintingVariant> AUCTION = key("auction");
    public static final ResourceKey<PaintingVariant> OJSN = key("ojsn");
    public static final ResourceKey<PaintingVariant> GT_AND_ONDISK = key("gt_and_ondisk");
    public static final ResourceKey<PaintingVariant> YMD_UDN = key("ymd_udn");
    public static final ResourceKey<PaintingVariant> HIDE = key("hide");
    public static final ResourceKey<PaintingVariant> OTIRO = key("otiro");

    private static ResourceKey<PaintingVariant> key(String id) {
        return ResourceKey.create(Registries.PAINTING_VARIANT, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<PaintingVariant> register) {
        reg(register, ART, 4, 4);
        reg(register, BUTTIPA, 2, 2);
        reg(register, DEMASUYO, 2, 1);
        reg(register, GANKOU, 2, 1);
        reg(register, ICETEA, 4, 2);
        reg(register, IKISUGI, 1, 1);
        reg(register, INTERVIEW, 4, 4);
        reg(register, KANGAERU, 2, 1);
        reg(register, KMR, 1, 1);
        reg(register, KUGYOU, 2, 1);
        reg(register, LOGO, 4, 2);
        reg(register, MIACAT, 1, 2);
        reg(register, MUR, 2, 2);
        reg(register, SANSYOU, 4, 3);
        reg(register, TADOKORO, 1, 1);
        reg(register, YONSYOU, 4, 3);
        reg(register, KATYOU, 1, 1);
        reg(register, GENBAKANTOKU, 2, 1);
        reg(register, TNOK, 2, 2);
        reg(register, WORLD_OF_TON, 4, 2);
        reg(register, RESTAURANT, 4, 2);
        reg(register, GABA_ANA_DADDY, 4, 3);
        reg(register, TON, 1, 2);
        reg(register, ITS_DOG, 2, 2);
        reg(register, CYCLOPES, 4, 4);
        reg(register, TKD_INM, 1, 1);
        reg(register, NKOJ, 2, 1);
        reg(register, KUSO_DOKATA, 1, 2);
        reg(register, GO_IS_GOD, 4, 4);
        reg(register, TDN, 2, 2);
        reg(register, DB, 2, 2);
        reg(register, HTN, 2, 2);
        reg(register, KATYOU_2, 4, 2);
        reg(register, URTLMN, 2, 1);
        reg(register, PINKY, 4, 3);
        reg(register, THE_77SAI_KMMRKN, 2, 2);
        reg(register, NKN_KN, 1, 1);
        reg(register, KYN, 1, 1);
        reg(register, AKG, 1, 2);
        reg(register, KBS, 4, 2);
        reg(register, SUW_TNNU, 1, 1);
        reg(register, UEKBTKN_AND_VOLLEYBALLKN, 4, 2);
        reg(register, INR, 1, 2);
        reg(register, SANNIN_KATERU_WAKE_NAIDARO, 4, 3);
        reg(register, SKRNB, 4, 2);
        reg(register, NKMR, 1, 1);
        reg(register, D10, 1, 1);
        reg(register, YUSAKU, 1, 1);
        reg(register, KBTIT, 2, 2);
        reg(register, NKTIDKSG, 2, 2);
        reg(register, SENPAI_SUKISSU, 2, 1);
        reg(register, KM_DGYN_INM, 2, 2);
        reg(register, TKNUC, 2, 2);
        reg(register, AUCTION, 2, 1);
        reg(register, OJSN, 2, 2);
        reg(register, GT_AND_ONDISK, 4, 2);
        reg(register, YMD_UDN, 2, 2);
        reg(register, HIDE, 2, 1);
        reg(register, OTIRO, 4, 3);
    }

    private static void reg(RegistriesDatapackProviderWrapper.DynamicRegister<PaintingVariant> register, ResourceKey<PaintingVariant> key, int w, int h) {
        register.add(key, ctx -> new PaintingVariant(w, h, key.location()));
    }
}
