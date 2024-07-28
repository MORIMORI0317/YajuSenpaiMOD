package net.morimori0317.yajusenpai.neoforge.mixin.data;

import com.google.common.base.Preconditions;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.neoforge.data.cross.model.UncheckedTextureModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(value = ModelBuilder.class, remap = false)
public class ModelBuilderMixin implements UncheckedTextureModelBuilder {
    @Shadow
    @Final
    protected Map<String, String> textures;

    @Override
    public void uncheckedTexture(String key, ResourceLocation texture) {
        Preconditions.checkNotNull(key, "Key must not be null");
        Preconditions.checkNotNull(texture, "Texture must not be null");

        this.textures.put(key, texture.toString());
    }
}