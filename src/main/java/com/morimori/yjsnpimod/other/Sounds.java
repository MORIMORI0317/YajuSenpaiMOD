package com.morimori.yjsnpimod.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.morimori.yjsnpimod.Variable;

import net.minecraft.block.SoundType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class Sounds {

	//yj
    public static SoundEvent NNA = new SoundEvent(new ResourceLocation(Variable.MODID, "nna"));//ンアー
    public static SoundEvent YARIMASUNEXE = new SoundEvent(new ResourceLocation(Variable.MODID, "yarimasunexe"));//やりますねぇ!
    public static SoundEvent ONAON = new SoundEvent(new ResourceLocation(Variable.MODID, "onaon"));//オン！アオン！
    public static SoundEvent MAZUUTISAXA = new SoundEvent(new ResourceLocation(Variable.MODID, "mazuutisaxa"));//まずうちさぁ…屋上あるんだけど…焼いてかない？
    public static SoundEvent KATAKU = new SoundEvent(new ResourceLocation(Variable.MODID, "kataku"));//硬くなってんぜ
    public static SoundEvent NUWATIKARETA = new SoundEvent(new ResourceLocation(Variable.MODID, "nuwatikareta"));//ヌワーチカレタモー
    public static SoundEvent BUTTIPA = new SoundEvent(new ResourceLocation(Variable.MODID, "buttipa"));//ブッチパ
    public static SoundEvent IKISUGI = new SoundEvent(new ResourceLocation(Variable.MODID, "ikisugi"));//イキスギ
    public static SoundEvent OSUONEGAI = new SoundEvent(new ResourceLocation(Variable.MODID, "osuonegai"));//オースお願いします
    public static SoundEvent DEDEMASUYO = new SoundEvent(new ResourceLocation(Variable.MODID, "dedemasuyo"));//で、出ますよ
    public static SoundEvent FOOKIMATII = new SoundEvent(new ResourceLocation(Variable.MODID, "fookimatii"));//foo↑気持ちィ
    public static SoundEvent IIYOKOIYO = new SoundEvent(new ResourceLocation(Variable.MODID, "114514"));//114514
    public static SoundEvent NIJUYONSAI = new SoundEvent(new ResourceLocation(Variable.MODID, "nijuyonsai"));//24歳
    public static SoundEvent ON = new SoundEvent(new ResourceLocation(Variable.MODID, "on"));//オン！
    public static SoundEvent ZA = new SoundEvent(new ResourceLocation(Variable.MODID, "za"));//あー
    public static SoundEvent HUN = new SoundEvent(new ResourceLocation(Variable.MODID, "hun"));//フン！
    public static SoundEvent SYU = new SoundEvent(new ResourceLocation(Variable.MODID, "syu"));//シュー
    public static SoundEvent YOKUWAKARANAKATTADESU = new SoundEvent(new ResourceLocation(Variable.MODID, "yokuwakaranakattadesu"));//よくわからなかったです
    public static SoundEvent GAKUSEIDESU = new SoundEvent(new ResourceLocation(Variable.MODID, "gakuseidesu"));//学生です
    public static SoundEvent DASOUTOOMOEBA = new SoundEvent(new ResourceLocation(Variable.MODID, "dasoutoomoeba"));//出そうと思えば
    public static SoundEvent TAIZYANDSINTYOUGA = new SoundEvent(new ResourceLocation(Variable.MODID, "taizyuandsintyou"));//体重が・・・身長が・・・
    public static SoundEvent NU = new SoundEvent(new ResourceLocation(Variable.MODID, "nu"));//ヌッ
    public static SoundEvent HORAHORAHORA = new SoundEvent(new ResourceLocation(Variable.MODID, "horahorahora"));//ホラホラホラホラ
    public static SoundEvent FA = new SoundEvent(new ResourceLocation(Variable.MODID, "fa"));//ファッ!?




    //record
    public static SoundEvent yjinevent = new SoundEvent(new ResourceLocation(Variable.MODID, "yjin"));//野獣インタビュー
    public static SoundEvent yonsyouevent = new SoundEvent(new ResourceLocation(Variable.MODID, "yonsyou"));//四章
    public static SoundEvent karatebuevent = new SoundEvent(new ResourceLocation(Variable.MODID, "karatebu"));//迫真空手部
    public static SoundEvent cyclopssnpievent = new SoundEvent(new ResourceLocation(Variable.MODID, "cyclopssnpi"));//サイクロプス先輩


    public static final SoundType YJ = new SoundType(1.0F, 1.2F, NNA, HUN, ON, FOOKIMATII, BUTTIPA);

    public static List<SoundEvent> YJPBlockSoundlist = new ArrayList<SoundEvent>();
    public static List<SoundEvent> YJJakenSworlSoundlist = new ArrayList<SoundEvent>();
    public static List<SoundEvent> YJJakenShieldSoundlist = new ArrayList<SoundEvent>();
    public static List<SoundEvent> YJChanseSoundlist = new ArrayList<SoundEvent>();



    public static void ListRegSound() {
    Collections.addAll(YJPBlockSoundlist, NNA, YARIMASUNEXE, ONAON, MAZUUTISAXA,KATAKU,NUWATIKARETA,BUTTIPA,IKISUGI,OSUONEGAI,
    		DEDEMASUYO,FOOKIMATII,IIYOKOIYO,NIJUYONSAI,YOKUWAKARANAKATTADESU,GAKUSEIDESU,DASOUTOOMOEBA,TAIZYANDSINTYOUGA
    		);
	Collections.addAll(YJJakenSworlSoundlist,SYU,FOOKIMATII,HORAHORAHORA

			);
	Collections.addAll(YJJakenShieldSoundlist,NNA,ON,ZA,HUN
			);
	Collections.addAll(YJChanseSoundlist,FA,NU
			);


	}
    public static SoundEvent SoundLisRandom(List<SoundEvent> list) {
    	int ls=list.size();

    	Random r = new Random();

		return list.get(r.nextInt(ls));
    }

}
