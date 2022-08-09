package net.morimori0317.yajusenpai.util;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class YJDataUtils {
    public static InputStream resourceExtractor(@NotNull Class<?> clazz, @NotNull String path) {
        if (path.startsWith("/")) path = path.substring(1);

        InputStream stream = clazz.getResourceAsStream("/" + path);
        if (stream == null) stream = ClassLoader.getSystemResourceAsStream(path);
        return stream != null ? new BufferedInputStream(stream) : null;
    }

    public static void inputToOutput(InputStream inputStream, OutputStream outputStream, int size) throws IOException {
        try (InputStream in = inputStream; OutputStream out = outputStream) {
            byte[] data = new byte[size];
            int len;
            while ((len = in.read(data)) != -1) {
                out.write(data, 0, len);
            }
        }
    }
}
