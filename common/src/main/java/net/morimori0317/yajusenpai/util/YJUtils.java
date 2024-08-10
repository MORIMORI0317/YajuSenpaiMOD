package net.morimori0317.yajusenpai.util;

import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.value.IntValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.LevelChunk;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageSources;
import net.morimori0317.yajusenpai.explatform.YJExpectPlatform;
import net.morimori0317.yajusenpai.item.YJDataComponents;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.level.dimension.YJDimensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class YJUtils {

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(YajuSenpai.MODID, path);
    }

    public static boolean isBoss(LivingEntity livingEntity) {
        return YJExpectPlatform.isBoss(livingEntity);
    }

    public static void ikisugiKill(LivingEntity target, Entity attacker) {
        for (int i = 0; i < 19; i++) {
            target.hurt(YJDamageSources.ikisugi(target.level(), attacker), 114514);
            if (!target.isAlive()) {
                break;
            }
        }
    }

    public static boolean isYJDim(Level level) {
        return level.dimension() == YJDimensions.YJ_DIM;
    }

    public static IntValue refToVal(LocalIntRef ref) {
        return new IntValue() {
            @Override
            public void accept(int value) {
                ref.set(value);
            }

            @Override
            public int getAsInt() {
                return ref.get();
            }
        };
    }

    public static void giveItemToPlayer(@NotNull ServerPlayer player, @NotNull ItemStack stack) {
        if (!player.addItem(stack))
            player.drop(stack, false, true);
    }

    public static void giveItemToEntity(@NotNull Entity entity, @NotNull ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(entity.level(), (double) entity.getX(), (double) entity.getY(), (double) entity.getZ(), stack);
        itemEntity.setDefaultPickUpDelay();
        entity.level().addFreshEntity(itemEntity);
    }

    public static ItemStack createFutoiSeaChicken() {
        ItemStack stack = new ItemStack(Items.CHICKEN);

        stack.set(DataComponents.CUSTOM_NAME, Component.translatable("item.yajusenpai.futoi_sea_chicken")
                .withStyle(Style.EMPTY.withBold(true).withItalic(false)));
        stack.set(YJDataComponents.FUTOI_SEA_CHICKEN.get(), Unit.INSTANCE);

        return stack;
    }

    public static boolean isYJSound(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(YJMobEffects.BEAST_FICTION.vanillaHolder()))
                return true;

            boolean flg1 = livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(YJItems.YAJUSENPAI_HELMET.get());
            boolean flg2 = livingEntity.getItemBySlot(EquipmentSlot.CHEST).is(YJItems.YAJUSENPAI_CHESTPLATE.get());
            boolean flg3 = livingEntity.getItemBySlot(EquipmentSlot.LEGS).is(YJItems.YAJUSENPAI_LEGGINGS.get());
            boolean flg4 = livingEntity.getItemBySlot(EquipmentSlot.FEET).is(YJItems.YAJUSENPAI_BOOTS.get());

            return flg1 && flg2 && flg3 && flg4;
        }
        return false;
    }

    public static void doPlayers(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Consumer<ServerPlayer> playerConsumer) {
        LevelChunk lch = (LevelChunk) level.getChunk(pos);
        doPlayers(lch, playerConsumer);
    }

    public static void doPlayers(@NotNull LevelChunk chunk, @NotNull Consumer<ServerPlayer> playerConsumer) {
        ((ServerChunkCache) chunk.getLevel().getChunkSource()).chunkMap.getPlayers(chunk.getPos(), false).forEach(playerConsumer);
    }

    public static boolean legacyYjRandom(RandomSource random) {
        return random.nextFloat() <= 0.0810f;
    }

    public static boolean yjRandom(RandomSource random) {
        return 364 > random.nextInt(1919);
    }

    public static boolean veryYjRandom(RandomSource random) {
        return 114514 > random.nextInt(1919810);
    }

    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        return YJExpectPlatform.isFood(stack, livingEntity);
    }

    public static <T> Holder<T> vanillaHolder(RegistrySupplier<T> registrySupplier) {
        return registrySupplier.getRegistrar().getHolder(registrySupplier.getKey());
    }
}
