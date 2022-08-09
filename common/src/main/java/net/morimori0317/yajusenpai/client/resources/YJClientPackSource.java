package net.morimori0317.yajusenpai.client.resources;

import dev.architectury.platform.Platform;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.FolderPackResources;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.morimori0317.yajusenpai.util.YJDataUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Supplier;

public class YJClientPackSource {
    private static boolean inited;

    public synchronized static void init() {
        if (inited) return;
        inited = true;
        File pf = new File("yajusenpai");
        pf.mkdir();
        File pff = new File(pf, "HighResolutionTexture.zip");

        if (!pff.exists()) {
            try (var in = YJDataUtils.resourceExtractor(YJClientPackSource.class, "assets/yajusenpai/pack/HighResolutionTexture.zip"); var out = new FileOutputStream(pff)) {
                if (in != null)
                    YJDataUtils.inputToOutput(in, out, 1024);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Pack createHighResolutionTexturePack(Pack.PackConstructor packConstructor) {
        if (Platform.isDevelopmentEnvironment()) {
            File file = new File("../../HighResolutionTexture");
            if (file.exists() && file.isDirectory()) {
                return createHighResolutionTexturePack(packConstructor, () -> createHighResolutionTextureDirPack(file));
            }
        } else {
            init();
            File file = new File("yajusenpai/HighResolutionTexture.zip");
            if (file.exists() && !file.isDirectory()) {
                return createHighResolutionTexturePack(packConstructor, () -> createHighResolutionTextureZipPack(file));
            }
        }
        return null;
    }

    private static Pack createHighResolutionTexturePack(Pack.PackConstructor packConstructor, Supplier<PackResources> supplier) {
        return Pack.create("yj_high_resolution", false, supplier, packConstructor, Pack.Position.TOP, PackSource.BUILT_IN);
    }

    private static FolderPackResources createHighResolutionTextureDirPack(File file) {
        return new FolderPackResources(file) {
            public String getName() {
                return "YJ High Resolution";
            }
        };
    }

    private static PackResources createHighResolutionTextureZipPack(File file) {
        return new FilePackResources(file) {
            public String getName() {
                return "YJ High Resolution";
            }
        };
    }
}
