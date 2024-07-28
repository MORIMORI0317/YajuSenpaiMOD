package net.morimori0317.yajusenpai.data.cross.provider;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.Util;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.model.ModelProcessSubProviderWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class ModelProcessProviderWrapper extends InputBaseProviderWrapper {
    private static final Gson GSON = new Gson();
    private final List<ModelProcessSubProviderWrapper> subProviderWrappers;

    public ModelProcessProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess, List<ModelProcessSubProviderWrapper> subProviderWrappers) {
        super(packOutput, PackOutput.Target.RESOURCE_PACK, "models", crossDataGeneratorAccess);
        this.subProviderWrappers = subProviderWrappers;
    }

    @Override
    public String getName() {
        return "Model Process";
    }

    @Override
    protected @Nullable CompletableFuture<?> runTask(CachedOutput cachedOutput, Path inputRoot, Path target) {
        return CompletableFuture.supplyAsync(() -> {
            var locEx = toResourceLocationAndExtension(inputRoot, target);
            try (Reader reader = new FileReader(target.toFile()); Reader bufReadr = new BufferedReader(reader)) {
                return new ModelData(locEx.getLeft(), GSON.fromJson(bufReadr, JsonObject.class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, Util.backgroundExecutor()).thenComposeAsync(r -> runConvert(cachedOutput, r), Util.backgroundExecutor()).handleAsync((models, throwable) -> models, Util.backgroundExecutor()).thenComposeAsync(models -> {
            if (models != null) {
                List<CompletableFuture<?>> saves = new ArrayList<>();
                for (ModelData model : models) {
                    saves.add(DataProvider.saveStable(cachedOutput, model.model(), pathProvider.json(model.location())));
                }
                return CompletableFuture.allOf(saves.toArray(CompletableFuture[]::new));
            }
            return CompletableFuture.completedFuture(null);
        }, Util.backgroundExecutor());
    }

    @NotNull
    protected CompletableFuture<List<ModelData>> runConvert(CachedOutput cachedOutput, ModelData base) {
        CompletableFuture<List<ModelData>> cf = CompletableFuture.completedFuture(ImmutableList.of(base));
        for (ModelProcessSubProviderWrapper subProviderWrapper : subProviderWrappers) {
            cf = cf.thenApplyAsync(r -> subProviderWrapper.process(cachedOutput, r), Util.backgroundExecutor());
        }
        return cf;
    }

    public static record ModelData(ResourceLocation location, JsonObject model) {
        public String getName() {
            var sp = location.getPath().split("/");
            return sp[sp.length - 1];
        }
    }
}
