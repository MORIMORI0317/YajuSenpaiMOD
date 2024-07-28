package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class InputBaseProviderWrapper extends BasicProviderWrapper {
    protected final PackOutput.PathProvider pathProvider;
    protected final PackOutput.Target target;
    protected final String modId;
    protected final String kind;

    public InputBaseProviderWrapper(PackOutput packOutput, PackOutput.Target target, String kind, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        this(packOutput, target, crossDataGeneratorAccess.getMod().getModId(), kind, crossDataGeneratorAccess);
    }

    public InputBaseProviderWrapper(PackOutput packOutput, PackOutput.Target target, String modId, String kind, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.pathProvider = packOutput.createPathProvider(target, kind);
        this.target = target;
        this.modId = modId;
        this.kind = kind;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        List<CompletableFuture<?>> tasks = new ArrayList<>();
        var inPaths = getCrossGeneratorAccess().getResourceInputFolders();

        for (Path inPath : inPaths) {
            var targetPath = inPath.resolve(targetByName(target)).resolve(modId).resolve(kind);
            if (!Files.exists(targetPath))
                continue;

            try (var walk = Files.walk(targetPath)) {
                walk.forEach(path -> {
                    if (Files.isDirectory(path))
                        return;

                    if (!isTarget(inPath, path))
                        return;

                    var task = runTask(cachedOutput, inPath, path);
                    if (task != null)
                        tasks.add(task);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new));
    }

    protected abstract boolean isTarget(Path rootPath, Path targetPath);

    @Nullable
    protected abstract CompletableFuture<?> runTask(CachedOutput cachedOutput, Path inputRoot, Path target);

    private static String targetByName(PackOutput.Target target) {
        switch (target) {
            case DATA_PACK -> {
                return "data";
            }
            case RESOURCE_PACK -> {
                return "assets";
            }
            case REPORTS -> {
                return "reports";
            }
        }
        throw new RuntimeException("Unexpected target.");
    }

    protected Pair<ResourceLocation, String> toResourceLocationAndExtension(Path inputRoot, Path target) {
        var relativePath = inputRoot.relativize(target);

        var sb = new StringBuilder();
        String ex = "";

        for (int i = 0; i < relativePath.getNameCount() - 3; i++) {
            var p = relativePath.getName(i + 3).toFile().getName();
            if (i == relativePath.getNameCount() - 4) {
                sb.append(removeExtension(p));
                ex = getExtension(p);
            } else {
                sb.append(p).append("/");
            }
        }

        return Pair.of(ResourceLocation.fromNamespaceAndPath(relativePath.getName(1).toFile().getName(), sb.toString()), ex);
    }

    /**
     * 拡張子を取得する
     *
     * @param name 名前
     * @return 拡張子
     */
    private static String getExtension(String name) {
        String[] sps = name.split("\\.");
        if (sps.length > 1)
            return sps[sps.length - 1];
        return null;
    }

    /**
     * 拡張子を削除
     *
     * @param name 名前
     * @return 拡張子削除済み名
     */
    private static String removeExtension(String name) {
        String[] sps = name.split("\\.");
        if (sps.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sps.length - 1; i++) {
                sb.append(sps[i]).append(".");
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }
        return name;
    }
}
