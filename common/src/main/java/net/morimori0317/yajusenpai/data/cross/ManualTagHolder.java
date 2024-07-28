package net.morimori0317.yajusenpai.data.cross;

import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ManualTagHolder<T> {
    @NotNull
    static <T> ManualTagHolder<T> of(@NotNull TagKey<T> tagKey, @Nullable Consumer<IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T>> tagRegister) {
        return new ManualTagHolderImpl<>(tagKey, tagRegister);
    }

    @NotNull
    static <T> ManualTagHolder<T> of(@NotNull TagKey<T> tagKey) {
        return new ManualTagHolderImpl<>(tagKey);
    }

    @NotNull
    static <T> ManualTagHolder<T> of(@NotNull Supplier<TagKey<T>> tagKey) {
        return new ManualTagHolder<>() {
            @Override
            public @NotNull TagKey<T> getKey() {
                return tagKey.get();
            }

            @Override
            public void registering(IntrinsicHolderTagsProviderWrapper.@NotNull IntrinsicTagProviderAccess<T> tagProviderAccess) {
            }
        };
    }

    @NotNull
    TagKey<T> getKey();

    void registering(@NotNull IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T> tagProviderAccess);
}
