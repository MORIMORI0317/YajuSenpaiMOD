package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.Direction;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.model.BlockStateAndModelProviderAccess;

public abstract class BlockStateAndModelProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final DataProvider blockStateAndModelProvider;

    public BlockStateAndModelProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.blockStateAndModelProvider = crossDataGeneratorAccess.createBlockStateAndModelProvider(packOutput, this);
    }

    @Override
    public DataProvider getProvider() {
        return blockStateAndModelProvider;
    }

    public abstract void generateStatesAndModels(BlockStateAndModelProviderAccess providerAccess);

    /**
     * BlockModelGenerators$createHorizontalFacingDispatchの移植
     *
     * @return PropertyDispatch
     */
    public PropertyDispatch createHorizontalFacingDispatch() {
        return PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.WEST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, Variant.variant());
    }

    /**
     * BlockModelGenerators$createBooleanModelDispatchの移植
     *
     * @return PropertyDispatch
     */
    public PropertyDispatch createBooleanModelDispatch(BooleanProperty booleanProperty, ResourceLocation trueLoc, ResourceLocation falseLoc) {
        return PropertyDispatch.property(booleanProperty)
                .select(true, Variant.variant().with(VariantProperties.MODEL, trueLoc))
                .select(false, Variant.variant().with(VariantProperties.MODEL, falseLoc));
    }
}
