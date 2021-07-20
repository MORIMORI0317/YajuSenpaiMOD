package net.morimori.yjsnpimod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJHorseArmorItem extends HorseArmorItem {
    private final boolean yjsnpi;

    public YJHorseArmorItem(int i, Properties properties, boolean yjsnpi) {
        super(i, null, properties);
        this.yjsnpi = yjsnpi;
    }

    @Override
    public ResourceLocation getTexture() {
        return new ResourceLocation(YJSNPIMOD.MODID, "textures/models/horse_armor/yjnium_horse_armor.png");
    }
}
