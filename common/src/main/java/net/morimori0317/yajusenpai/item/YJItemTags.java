package net.morimori0317.yajusenpai.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJItemTags {
    public static final TagKey<Item> INM_BLOCK = bind("inm_block");
    public static final TagKey<Item> YJ_LOGS = bind("yj_logs");
    public static final TagKey<Item> YJNIUM_ORES = bind("yjnium_ores");
    public static final TagKey<Item> YAJUSENPAI_BLOCK = bind("yajusenpai_block");
    public static final TagKey<Item> YAJUSENPAI_ORES = bind("yajusenpai_ores");

    public static final TagKey<Item> COMPAT_BLUE_DYE = bind("compat/blue_dye");
    public static final TagKey<Item> COMPAT_GLOWSTONE = bind("compat/glowstone");
    public static final TagKey<Item> COMPAT_GREEN_DYE = bind("compat/green_dye");
    public static final TagKey<Item> COMPAT_IRON_INGOT = bind("compat/iron_ingot");
    public static final TagKey<Item> COMPAT_NETHERITE_INGOT = bind("compat/netherite_ingot");
    public static final TagKey<Item> COMPAT_RAW_YJNIUM = bind("compat/raw_yjnium");
    public static final TagKey<Item> COMPAT_RAW_YJNIUM_BLOCK = bind("compat/raw_yjnium_block");
    public static final TagKey<Item> COMPAT_RAW_YAJUSENPAI = bind("compat/raw_yajusenpai");
    public static final TagKey<Item> COMPAT_RAW_YAJUSENPAI_BLOCK = bind("compat/raw_yajusenpai_block");
    public static final TagKey<Item> COMPAT_RED_DYE = bind("compat/red_dye");
    public static final TagKey<Item> COMPAT_TINTED_GLASS = bind("compat/tinted_glass");
    public static final TagKey<Item> COMPAT_WHEAT = bind("compat/wheat");
    public static final TagKey<Item> COMPAT_YJNIUM_BLOCK = bind("compat/yjnium_block");
    public static final TagKey<Item> COMPAT_YJNIUM_INGOT = bind("compat/yjnium_ingot");
    public static final TagKey<Item> COMPAT_YJNIUM_NUGGET = bind("compat/yjnium_nugget");
    public static final TagKey<Item> COMPAT_YAJUSENPAI_INGOT = bind("compat/yajusenpai_ingot");
    public static final TagKey<Item> COMPAT_YAJUSENPAI_NUGGET = bind("compat/yajusenpai_nugget");

    public static final TagKey<Item> KATYOU_BROKEN_ENCHANTABLE = bind("enchantable/katyou_broken");
    public static final TagKey<Item> GABA_ANA_DADDY_ENCHANTABLE = bind("enchantable/gaba_ana_daddy");
    public static final TagKey<Item> KYN_ENCHANTABLE = bind("enchantable/kyn");

    public static final TagKey<Item> GO_IS_GOD = bind("go_is_god");

    private static TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, YJUtils.modLoc(id));
    }
}
