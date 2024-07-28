package net.morimori0317.yajusenpai.data.cross.provider;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;
import net.minecraft.Util;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.io.*;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class DirectCopyProviderWrapper extends InputBaseProviderWrapper {
    public DirectCopyProviderWrapper(PackOutput packOutput, PackOutput.Target target, String kind, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, target, kind, crossDataGeneratorAccess);
    }

    public DirectCopyProviderWrapper(PackOutput packOutput, PackOutput.Target target, String modId, String kind, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, target, modId, kind, crossDataGeneratorAccess);
    }

    @Override
    protected @Nullable CompletableFuture<?> runTask(CachedOutput cachedOutput, Path inputRoot, Path target) {
        return CompletableFuture.runAsync(() -> {
            var locEx = toResourceLocationAndExtension(inputRoot, target);
            try (InputStream stream = new FileInputStream(target.toFile()); InputStream bufStream = new BufferedInputStream(stream)) {
                save(cachedOutput, bufStream, pathProvider.file(locEx.getKey(), locEx.getValue()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, Util.backgroundExecutor());
    }

    @Override
    protected boolean isTarget(Path rootPath, Path targetPath) {
        return true;
    }

    @Override
    public String getName() {
        return "Input copy";
    }

    /**
     * 保存
     *
     * @param cachedOutput CachedOutput
     * @param stream       Stream
     * @param path         Path
     * @throws IOException Error
     */
    private static void save(CachedOutput cachedOutput, InputStream stream, Path path) throws IOException {
        byte[] bs;
        HashCode hashCode;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); HashingOutputStream hashingOutputStream = new HashingOutputStream(Hashing.sha1(), byteArrayOutputStream)) {
            i2o(stream, hashingOutputStream);
            bs = byteArrayOutputStream.toByteArray();
            hashCode = hashingOutputStream.hash();
        }
        cachedOutput.writeIfNeeded(path, bs, hashCode);
    }

    /**
     * インプットストリームをアウトプットストリームへ
     *
     * @param inputStream  In
     * @param outputStream Out
     * @return 合計サイズ
     * @throws IOException 例外
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    private static int i2o(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        return inputToOutput(inputStream, outputStream);
    }

    /**
     * インプットストリームをアウトプットストリームへ
     *
     * @param inputStream  In
     * @param outputStream Out
     * @return 合計サイズ
     * @throws IOException 例外
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    private static int inputToOutput(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        return inputToOutput(inputStream, outputStream, 1024);
    }

    /**
     * インプットストリームをアウトプットストリームへ
     *
     * @param inputStream  In
     * @param outputStream Out
     * @param readSize     一度に書き込む量
     * @return 合計サイズ
     * @throws IOException 例外
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    private static int inputToOutput(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, @Range(from = 0, to = Integer.MAX_VALUE) int readSize) throws IOException {
        int ct = 0;
        try (InputStream in = inputStream; OutputStream out = outputStream) {
            byte[] data = new byte[readSize];
            int len;
            while ((len = in.read(data)) != -1) {
                ct += len;
                out.write(data, 0, len);
            }
        }
        return ct;
    }
}
