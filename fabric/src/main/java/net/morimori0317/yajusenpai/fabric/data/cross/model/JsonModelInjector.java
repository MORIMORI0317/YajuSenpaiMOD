package net.morimori0317.yajusenpai.fabric.data.cross.model;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.OverridePredicate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class JsonModelInjector {
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> originalModelOutput;
    private final Multimap<FileModel, OverridePredicate> overrides = LinkedHashMultimap.create();
    private final Map<String, ResourceLocation> textures = new LinkedHashMap<>();

    public JsonModelInjector(BiConsumer<ResourceLocation, Supplier<JsonElement>> originalModelOutput) {
        this.originalModelOutput = originalModelOutput;
    }

    public BiConsumer<ResourceLocation, Supplier<JsonElement>> injectedModelOutput() {
        return (location, jsonElementSupplier) -> originalModelOutput.accept(location, () -> injectJsonModel(jsonElementSupplier.get()));
    }

    private JsonElement injectJsonModel(JsonElement jsonElement) {
        if (jsonElement.isJsonObject()) {
            var jo = jsonElement.getAsJsonObject();

            if (!overrides.isEmpty()) {
                var oja = new JsonArray();

                overrides.asMap().forEach((fileModel, predicates) -> {
                    var apjso = new JsonObject();
                    apjso.addProperty("model", fileModel.getLocation().toString());

                    var pjso = new JsonObject();

                    for (OverridePredicate predicate : predicates) {
                        pjso.addProperty(predicate.key().toString(), predicate.value());
                    }

                    apjso.add("predicate", pjso);

                    oja.add(apjso);
                });

                jo.add("overrides", oja);
            }

            if (!textures.isEmpty()) {
                var tjo = new JsonObject();

                textures.forEach((id, loc) -> tjo.addProperty(id, loc.toString()));

                jo.add("textures", tjo);
            }
        }
        return jsonElement;
    }

    public void putOverride(FileModel model, List<OverridePredicate> predicates) {
        this.overrides.putAll(model, predicates);
    }

    public void putTexture(String id, ResourceLocation location) {
        this.textures.put(id, location);
    }
}
