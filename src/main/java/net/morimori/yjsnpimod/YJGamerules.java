package net.morimori.yjsnpimod;

import net.minecraft.world.GameRules;
import red.felnull.otyacraftengine.util.IKSGRegistryUtil;

public class YJGamerules {

    public static GameRules.RuleKey<GameRules.BooleanValue> YJSNPI_BLOCK_PROLIFERATION;

    public static void register() {
        YJSNPI_BLOCK_PROLIFERATION = IKSGRegistryUtil.registryGameRule("yjsnpiBlockProliferation", GameRules.Category.MISC, true);
    }
}
