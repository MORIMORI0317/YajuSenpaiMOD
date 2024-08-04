package net.morimori0317.yajusenpai.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.PaintingVariantTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.entity.decoration.YJPaintingVariants;

import java.util.concurrent.CompletableFuture;

public class YJPaintingVariantTagsProvider extends PaintingVariantTagsProviderWrapper {
    public YJPaintingVariantTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, registriesDatapackProviderWrapper);
    }

    @Override
    public void generateTag(TagProviderAccess<PaintingVariant, TagAppenderWrapper<PaintingVariant>> providerAccess) {
        providerAccess.tag(PaintingVariantTags.PLACEABLE)
                .add(YJPaintingVariants.ART)
                .add(YJPaintingVariants.BUTTIPA)
                .add(YJPaintingVariants.DEMASUYO)
                .add(YJPaintingVariants.GANKOU)
                .add(YJPaintingVariants.ICETEA)
                .add(YJPaintingVariants.IKISUGI)
                .add(YJPaintingVariants.INTERVIEW)
                .add(YJPaintingVariants.KANGAERU)
                .add(YJPaintingVariants.KMR)
                .add(YJPaintingVariants.KUGYOU)
                .add(YJPaintingVariants.LOGO)
                .add(YJPaintingVariants.MIACAT)
                .add(YJPaintingVariants.MUR)
                .add(YJPaintingVariants.SANSYOU)
                .add(YJPaintingVariants.TADOKORO)
                .add(YJPaintingVariants.YONSYOU)
                .add(YJPaintingVariants.KATYOU)
                .add(YJPaintingVariants.GENBAKANTOKU)
                .add(YJPaintingVariants.TNOK)
                .add(YJPaintingVariants.WORLD_OF_TON)
                .add(YJPaintingVariants.RESTAURANT)
                .add(YJPaintingVariants.GABA_ANA_DADDY)
                .add(YJPaintingVariants.TON)
                .add(YJPaintingVariants.ITS_DOG)
                .add(YJPaintingVariants.CYCLOPES)
                .add(YJPaintingVariants.TKD_INM)
                .add(YJPaintingVariants.NKOJ)
                .add(YJPaintingVariants.KUSO_DOKATA)
                .add(YJPaintingVariants.GO_IS_GOD)
                .add(YJPaintingVariants.TDN)
                .add(YJPaintingVariants.DB)
                .add(YJPaintingVariants.HTN)
                .add(YJPaintingVariants.KATYOU_2)
                .add(YJPaintingVariants.URTLMN)
                .add(YJPaintingVariants.PINKY)
                .add(YJPaintingVariants.THE_77SAI_KMMRKN)
                .add(YJPaintingVariants.NKN_KN)
                .add(YJPaintingVariants.KYN)
                .add(YJPaintingVariants.AKG)
                .add(YJPaintingVariants.KBS)
                .add(YJPaintingVariants.SUW_TNNU)
                .add(YJPaintingVariants.UEKBTKN_AND_VOLLEYBALLKN)
                .add(YJPaintingVariants.INR)
                .add(YJPaintingVariants.SANNIN_KATERU_WAKE_NAIDARO)
                .add(YJPaintingVariants.SKRNB)
                .add(YJPaintingVariants.NKMR)
                .add(YJPaintingVariants.D10)
                .add(YJPaintingVariants.YUSAKU)
                .add(YJPaintingVariants.KBTIT)
                .add(YJPaintingVariants.NKTIDKSG)
                .add(YJPaintingVariants.SENPAI_SUKISSU)
                .add(YJPaintingVariants.KM_DGYN_INM)
                .add(YJPaintingVariants.TKNUC)
                .add(YJPaintingVariants.AUCTION)
                .add(YJPaintingVariants.OJSN)
                .add(YJPaintingVariants.GT_AND_ONDISK)
                .add(YJPaintingVariants.YMD_UDN)
                .add(YJPaintingVariants.HIDE)
                .add(YJPaintingVariants.OTIRO);
    }
}
