package net.morimori0317.yajusenpai.data.cross.provider.model;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.data.CachedOutput;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.ModelProcessProviderWrapper;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivisionModelProcessSubProviderWrapper extends ModelProcessSubProviderWrapper {
    public DivisionModelProcessSubProviderWrapper(CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(crossDataGeneratorAccess);
    }

    @Override
    public List<ModelProcessProviderWrapper.ModelData> process(CachedOutput cachedOutput, ModelProcessProviderWrapper.ModelData modelData) {
        return divModel(modelData.getName(), modelData.model()).entrySet().stream().map(n -> {
            var p = modelData.location().getPath();
            var ps = p.split("/");
            ps[ps.length - 1] = n.getKey();
            return new ModelProcessProviderWrapper.ModelData(ResourceLocation.fromNamespaceAndPath(modelData.location().getNamespace(), String.join("/", ps)), n.getValue());
        }).toList();
    }

    private Map<String, JsonObject> divModel(String name, JsonObject original) {
        var groups = original.getAsJsonArray("groups");

        if (groups == null)
            return ImmutableMap.of(name, original);

        Map<String, List<JsonElement>> divGroups = new HashMap<>();

        for (JsonElement group : groups) {
            if (group instanceof JsonObject jsonObject && jsonObject.has("name") && isDivGroup(jsonObject.get("name").getAsString())) {
                var gname = convertDivGroupName(jsonObject.get("name").getAsString());
                divGroups.putIfAbsent(gname, new ArrayList<>());
                divGroups.get(gname).add(group);
            } else {
                divGroups.putIfAbsent(name, new ArrayList<>());
                divGroups.get(name).add(group);
            }
        }

        var orelement = original.getAsJsonArray("elements");

        return divGroups.entrySet().stream().map(ent -> Pair.of(ent.getKey(), ent.getValue().stream().flatMap(r -> getAllChildren(r).stream()).toList())).map(ent -> {
            JsonObject oriCopy = original.deepCopy();
            oriCopy.remove("elements");
            oriCopy.remove("groups");
            JsonArray nelements = new JsonArray();
            for (Integer integer : ent.getRight()) {
                nelements.add(orelement.get(integer));
            }
            oriCopy.add("elements", nelements);
            return Pair.of(ent.getLeft(), oriCopy);
        }).collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }

    private List<Integer> getAllChildren(JsonElement group) {
        List<Integer> ret = new ArrayList<>();
        if (group instanceof JsonObject groupJson) {
            JsonArray children = groupJson.getAsJsonArray("children");
            for (JsonElement child : children) {
                ret.addAll(getAllChildren(child));
            }
        } else if (group instanceof JsonPrimitive jsonPrimitive && jsonPrimitive.isNumber()) {
            ret.add(jsonPrimitive.getAsInt());
        }
        return ret;
    }

    protected boolean isDivGroup(String groupName) {
        return groupName.startsWith("_");
    }

    protected String convertDivGroupName(String groupName) {
        return groupName.substring(1);
    }
}
