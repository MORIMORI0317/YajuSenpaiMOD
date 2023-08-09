package net.morimori0317.yajusenpai.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJHorseArmorItem extends HorseArmorItem {
    private static final String YJSNPI_NAME = "yjsnpi";
    private static final String YJNIUM_NAME = "yjnium";

    private final String yjTexture;

    public YJHorseArmorItem(int protection, boolean yjsnpi, Properties properties) {
        super(protection, yjsnpi ? YJSNPI_NAME : YJNIUM_NAME, properties);
        this.yjTexture = "textures/entity/horse/armor/horse_armor_" + (yjsnpi ? YJSNPI_NAME : YJNIUM_NAME) + ".png";
    }

    @Override
    public ResourceLocation getTexture() {
        return YJUtils.modLoc(yjTexture);
    }
}
