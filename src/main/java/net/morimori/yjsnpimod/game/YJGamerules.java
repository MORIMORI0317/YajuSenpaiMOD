package net.morimori.yjsnpimod.game;

import net.minecraft.world.GameRules;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.morimori.yjsnpimod.YJDeobfNames;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class YJGamerules {

    public static GameRules.RuleKey<GameRules.BooleanValue> YJSNPI_BLOCK_PROLIFERATION;


    public static void register() {

        YJSNPI_BLOCK_PROLIFERATION = GameRules.func_234903_a_("yjsnpiBlockProliferation", GameRules.Category.MISC, getBooleanValueRuleType(true));

    }

    public static GameRules.RuleType<GameRules.BooleanValue> getBooleanValueRuleType(boolean defalt) {
        Method rulucreater = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, YJDeobfNames.GameRulesBooleanValue_create.name(), boolean.class);
        rulucreater.setAccessible(true);
        try {
            GameRules.RuleType<GameRules.BooleanValue> dftype = (GameRules.RuleType<GameRules.BooleanValue>) rulucreater.invoke(GameRules.BooleanValue.class, defalt);
            return dftype;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
