package net.morimori0317.yajusenpai.server.level.dimension;


import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJSurfaceRuleData {
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource SAND = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(YJBlocks.YJ_GRAVEL.get());
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(YJBlocks.YJ_DEEPSLATE.get());
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource ORANGE_TERRACOTTA = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource MUD = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource RED_SANDSTONE = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource WHITE_TERRACOTTA = makeStateRule(YJBlocks.YJ_STONE.get());
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(YJBlocks.YJ_SAND.get());
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(YJBlocks.YJ_DIRT.get());
    private static final SurfaceRules.RuleSource ICE = makeStateRule(YJBlocks.YJ_DIRT.get());

    public static SurfaceRules.RuleSource yjDimension() {
        return yjDimeLike(true, false, true);
    }

    public static SurfaceRules.RuleSource yjDimeLike(boolean bl, boolean bl2, boolean bl3) {
        SurfaceRules.ConditionSource conditionSource = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(97), 2);
        SurfaceRules.ConditionSource conditionSource2 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(256), 0);
        SurfaceRules.ConditionSource conditionSource3 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(63), -1);
        SurfaceRules.ConditionSource conditionSource4 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(74), 1);
        SurfaceRules.ConditionSource conditionSource5 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(60), 0);
        SurfaceRules.ConditionSource conditionSource6 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource conditionSource7 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
        SurfaceRules.ConditionSource conditionSource8 = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource conditionSource9 = SurfaceRules.waterBlockCheck(0, 0);
        SurfaceRules.ConditionSource conditionSource10 = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.ConditionSource conditionSource11 = SurfaceRules.hole();
        SurfaceRules.ConditionSource conditionSource12 = SurfaceRules.isBiome(Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN);
        SurfaceRules.ConditionSource conditionSource13 = SurfaceRules.steep();
        SurfaceRules.RuleSource ruleSource = SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource9, GRASS_BLOCK), DIRT);
        SurfaceRules.RuleSource ruleSource2 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);
        SurfaceRules.RuleSource ruleSource3 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, STONE), GRAVEL);
        SurfaceRules.ConditionSource conditionSource14 = SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.BEACH, Biomes.SNOWY_BEACH);
        SurfaceRules.ConditionSource conditionSource15 = SurfaceRules.isBiome(Biomes.DESERT);
        SurfaceRules.RuleSource ruleSource4 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.CALCITE, -0.0125, 0.0125), CALCITE), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.STONY_SHORE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.GRAVEL, -0.05, 0.05), ruleSource3), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_HILLS), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE)), SurfaceRules.ifTrue(conditionSource14, ruleSource2), SurfaceRules.ifTrue(conditionSource15, ruleSource2), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.DRIPSTONE_CAVES), STONE));
        SurfaceRules.RuleSource ruleSource5 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45, 0.58), SurfaceRules.ifTrue(conditionSource9, POWDER_SNOW));
        SurfaceRules.RuleSource ruleSource6 = SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.35, 0.6), SurfaceRules.ifTrue(conditionSource9, POWDER_SNOW));
        SurfaceRules.RuleSource ruleSource7 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource13, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, -0.5, 0.2), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, -0.0625, 0.025), ICE), SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource13, STONE), ruleSource5, SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(ruleSource5, DIRT)), ruleSource4, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), STONE)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0), ruleSource3), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0), DIRT), ruleSource3)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), DIRT);
        SurfaceRules.RuleSource ruleSource8 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource13, PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.PACKED_ICE, 0.0, 0.2), PACKED_ICE), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.ICE, 0.0, 0.025), ICE), SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SNOWY_SLOPES), SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource13, STONE), ruleSource6, SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.JAGGED_PEAKS), SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource13, STONE), SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.GROVE), SurfaceRules.sequence(ruleSource6, SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK))), ruleSource4, SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_SAVANNA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5), COARSE_DIRT))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WINDSWEPT_GRAVELLY_HILLS), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(2.0), ruleSource3), SurfaceRules.ifTrue(surfaceNoiseAbove(1.0), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-1.0), ruleSource), ruleSource3)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95), PODZOL))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.ICE_SPIKES), SurfaceRules.ifTrue(conditionSource9, SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), MUD), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MUSHROOM_FIELDS), MYCELIUM), ruleSource);
        SurfaceRules.ConditionSource conditionSource16 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.909, -0.5454);
        SurfaceRules.ConditionSource conditionSource17 = SurfaceRules.noiseCondition(Noises.SURFACE, -0.1818, 0.1818);
        SurfaceRules.ConditionSource conditionSource18 = SurfaceRules.noiseCondition(Noises.SURFACE, 0.5454, 0.909);
        SurfaceRules.RuleSource ruleSource9 = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WOODED_BADLANDS), SurfaceRules.ifTrue(conditionSource, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource16, COARSE_DIRT), SurfaceRules.ifTrue(conditionSource17, COARSE_DIRT), SurfaceRules.ifTrue(conditionSource18, COARSE_DIRT), ruleSource))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.SWAMP), SurfaceRules.ifTrue(conditionSource6, SurfaceRules.ifTrue(SurfaceRules.not(conditionSource7), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.MANGROVE_SWAMP), SurfaceRules.ifTrue(conditionSource5, SurfaceRules.ifTrue(SurfaceRules.not(conditionSource7), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0), WATER)))))), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource2, ORANGE_TERRACOTTA), SurfaceRules.ifTrue(conditionSource4, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource16, TERRACOTTA), SurfaceRules.ifTrue(conditionSource17, TERRACOTTA), SurfaceRules.ifTrue(conditionSource18, TERRACOTTA), SurfaceRules.bandlands())), SurfaceRules.ifTrue(conditionSource8, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, RED_SANDSTONE), RED_SAND)), SurfaceRules.ifTrue(SurfaceRules.not(conditionSource11), ORANGE_TERRACOTTA), SurfaceRules.ifTrue(conditionSource10, WHITE_TERRACOTTA), ruleSource3)), SurfaceRules.ifTrue(conditionSource3, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource7, SurfaceRules.ifTrue(SurfaceRules.not(conditionSource4), ORANGE_TERRACOTTA)), SurfaceRules.bandlands())), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(conditionSource10, WHITE_TERRACOTTA)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(conditionSource8, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource12, SurfaceRules.ifTrue(conditionSource11, SurfaceRules.sequence(SurfaceRules.ifTrue(conditionSource9, AIR), SurfaceRules.ifTrue(SurfaceRules.temperature(), ICE), WATER))), ruleSource8))), SurfaceRules.ifTrue(conditionSource10, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(conditionSource12, SurfaceRules.ifTrue(conditionSource11, WATER))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, ruleSource7), SurfaceRules.ifTrue(conditionSource14, SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, SANDSTONE)), SurfaceRules.ifTrue(conditionSource15, SurfaceRules.ifTrue(SurfaceRules.VERY_DEEP_UNDER_FLOOR, SANDSTONE)))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS), STONE), SurfaceRules.ifTrue(SurfaceRules.isBiome(Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), ruleSource2), ruleSource3)));
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        if (bl2) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK));
        }
        if (bl3) {
            builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK));
        }
        SurfaceRules.RuleSource ruleSource10 = SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), ruleSource9);
        builder.add(bl ? ruleSource10 : ruleSource9);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate", VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double d) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, d / 8.25, Double.MAX_VALUE);
    }
}