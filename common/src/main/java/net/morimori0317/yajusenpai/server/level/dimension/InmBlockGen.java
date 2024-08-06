package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.function.Supplier;

public enum InmBlockGen {
    YAJUSENPAI_CCCLKTJ(YJBlocks.CCCLKTJM_SENPAI_BLOCK, "yajusenpai_ccclktj", true, false),
    YAJUSENPAI_CWCWT(YJBlocks.CWCWTD_SENPAI_BLOCK, "yajusenpai_cwcwt", true, false),
    YAJUSENPAI_ENNU(YJBlocks.ENNUI_SENPAI_BLOCK, "yajusenpai_ennu", true, false),
    YAJUSENPAI_GOMANETS(YJBlocks.GOMANETSU_SENPAI_BLOCK, "yajusenpai_gomanets", true, false),
    YAJUSENPAI_IKISUG(YJBlocks.YAJUSENPAI_IKISUGI_BLOCK, "yajusenpai_ikisug", true, false),
    YAJUSENPAI_IMDKU(YJBlocks.IMDKUJ_SENPAI_BLOCK, "yajusenpai_imdku", true, false),
    YAJUSENPAI_INTERVIE(YJBlocks.YAJUSENPAI_BLOCK, "yajusenpai_intervie", true, false),
    YAJUSENPAI_INTLNGT(YJBlocks.INTLNGTM_SENPAI_BLOCK, "yajusenpai_intlngt", true, false),
    YAJUSENPAI_KUNEKUN(YJBlocks.KUNEKUNE_SENPAI_BLOCK, "yajusenpai_kunekun", true, false),
    YAJUSENPAI_MEDIKAR(YJBlocks.MEDIKARA_SENPAI_BLOCK, "yajusenpai_medikar", true, false),
    YAJUSENPAI_NEHA(YJBlocks.NEHAN_SENPAI_BLOCK, "yajusenpai_neha", true, false),
    YAJUSENPAI_SHITARIGA(YJBlocks.SHITARIGAO_SENPAI_BLOCK, "yajusenpai_shitariga", true, false),
    YAJUSENPAI_SZKFK(YJBlocks.SZKFK_SENPAI_BLOCK, "yajusenpai_szkfk", true, false),

    YAJUSENPAI_EXPLODING(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK, "yajusenpai_exploding", true, true),

    KMR(YJBlocks.KMR_BLOCK, "kmr", false, false),
    MUR(YJBlocks.MUR_BLOCK, "mur", false, false),
    TON(YJBlocks.TON_BLOCK, "ton", false, false),
    NKTIDKSG(YJBlocks.NKTIDKSG_BLOCK, "nktidksg", false, false),
    TAKEDA_INM(YJBlocks.TAKEDA_INM_BLOCK, "takeda_inm", false, false),
    KATYOU(YJBlocks.KATYOU_BLOCK, "katyou", false, false),
    SECOND_INARI_OTOKO(YJBlocks.SECOND_INARI_OTOKO_BLOCK, "second_inari_otoko", false, false),
    AKYS(YJBlocks.AKYS_BLOCK, "akys", false, false),
    GO(YJBlocks.GO_BLOCK, "go", false, false),
    HIDE(YJBlocks.HIDE_BLOCK, "hide", false, false),
    KBTIT(YJBlocks.KBTIT_BLOCK, "kbtit", false, false);

    private final Supplier<Block> block;
    private final String name;
    private final boolean yj;
    private final boolean rare;

    InmBlockGen(Supplier<Block> block, String name, boolean yj, boolean rare) {
        this.block = block;
        this.name = name;
        this.yj = yj;
        this.rare = rare;
    }

    public Supplier<Block> getBlock() {
        return block;
    }

    public String getName() {
        return name;
    }

    public boolean isYj() {
        return yj;
    }

    public boolean isRare() {
        return rare;
    }
}
