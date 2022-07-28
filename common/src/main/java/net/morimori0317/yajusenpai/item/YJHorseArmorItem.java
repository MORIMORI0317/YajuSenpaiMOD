package net.morimori0317.yajusenpai.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YJHorseArmorItem extends HorseArmorItem {
    private final boolean yjsnpi;

    public YJHorseArmorItem(int i, Properties properties, boolean yjsnpi) {
        super(i, "", properties);
        this.yjsnpi = yjsnpi;
    }

    @Override
    public ResourceLocation getTexture() {
        if (yjsnpi)
            return new ResourceLocation(YajuSenpai.MODID, "textures/models/horse_armor/yjsnpi_horse_armor.png");
        return new ResourceLocation(YajuSenpai.MODID, "textures/models/horse_armor/yjnium_horse_armor.png");
    }
}
