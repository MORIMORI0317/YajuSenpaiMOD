package net.morimori0317.yajusenpai.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class YJModelUtils {
    public static BakedModel getModel(ModelResourceLocation modelResourceLocation) {
        Minecraft mc = Minecraft.getInstance();
        return mc.getModelManager().getModel(modelResourceLocation);
    }

    public static BakedModel getModel(BlockState state) {
        Minecraft mc = Minecraft.getInstance();
        return mc.getModelManager().getBlockModelShaper().getBlockModel(state);
    }
}
