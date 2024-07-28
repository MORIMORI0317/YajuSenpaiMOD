package net.morimori0317.yajusenpai.neoforge.data.cross;

import com.google.gson.JsonObject;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.neoforged.neoforge.client.model.generators.IGeneratedBlockState;

public record WrappedBlockStateBuilder(BlockStateGenerator blockStateGenerator) implements IGeneratedBlockState {
    @Override
    public JsonObject toJson() {
        return blockStateGenerator.get().getAsJsonObject();
    }
}
