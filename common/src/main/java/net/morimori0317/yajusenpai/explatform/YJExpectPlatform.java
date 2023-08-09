package net.morimori0317.yajusenpai.explatform;

import com.mojang.serialization.Codec;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.Supplier;

public class YJExpectPlatform {
    @ExpectPlatform
    public static FlowerBlock createYJFlower(Supplier<MobEffect> effectSupplier, int effectDuration, BlockBehaviour.Properties properties) {
        throw new AssertionError();
    }
}
