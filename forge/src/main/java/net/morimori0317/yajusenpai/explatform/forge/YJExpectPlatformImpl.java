package net.morimori0317.yajusenpai.explatform.forge;

import com.mojang.serialization.Codec;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.morimori0317.yajusenpai.forge.block.YJRoseBlockForge;

import java.util.function.Supplier;

public class YJExpectPlatformImpl {
    public static FlowerBlock createYJFlower(Supplier<MobEffect> effectSupplier, int effectDuration, BlockBehaviour.Properties properties) {
        return new YJRoseBlockForge(effectSupplier, effectDuration, properties);
    }
}
