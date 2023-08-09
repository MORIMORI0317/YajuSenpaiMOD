package net.morimori0317.yajusenpai.explatform.fabric;

import com.mojang.serialization.Codec;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.morimori0317.yajusenpai.fabric.block.YJRoseBlockFabric;

import java.util.function.Supplier;

public class YJExpectPlatformImpl {
    public static FlowerBlock createYJFlower(Supplier<MobEffect> effectSupplier, int effectDuration, BlockBehaviour.Properties properties) {
        return new YJRoseBlockFabric(effectSupplier.get(), effectDuration, properties);
    }
}
