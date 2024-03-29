package net.morimori0317.yajusenpai.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.block.YJSoundType;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;
import net.morimori0317.yajusenpai.entity.YJDamageTypeTags;
import net.morimori0317.yajusenpai.item.YJItems;

import java.util.Arrays;

public class YJUtils {
    private static final ResourceKey<Level> YJ_DIMENSION = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(YajuSenpai.MODID, "the_yajusenpai"));

    public static ResourceLocation modLoc(String path) {
        return new ResourceLocation(YajuSenpai.MODID, path);
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

    public static boolean hasKatyouEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.KATYOU_CURSE.get(), stack) > 0;
    }

    public static boolean hasGabaAnaDaddyEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.GABA_ANA_DADDY_CURSE.get(), stack) > 0;
    }

    public static boolean hasKynEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.KYN_CURSE.get(), stack) > 0;
    }

    public static ItemStack createFutoiSeaChicken() {
        var ch = new ItemStack(Items.CHICKEN);
        ch.setHoverName(Component.translatable("item.yajusenpai.futoi_sea_chicken").withStyle(Style.EMPTY.withBold(true).withItalic(false)));
        ch.getOrCreateTag().putBoolean("futoi_sea_chicken", true);
        return ch;
    }

    public static boolean isYJSound(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.hasEffect(YJMobEffects.BEAST_FICTION.get()))
                return true;

            boolean flg1 = livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(YJItems.YJSNPI_HELMET.get());
            boolean flg2 = livingEntity.getItemBySlot(EquipmentSlot.CHEST).is(YJItems.YJSNPI_CHESTPLATE.get());
            boolean flg3 = livingEntity.getItemBySlot(EquipmentSlot.LEGS).is(YJItems.YJSNPI_LEGGINGS.get());
            boolean flg4 = livingEntity.getItemBySlot(EquipmentSlot.FEET).is(YJItems.YJSNPI_BOOTS.get());

            return flg1 && flg2 && flg3 && flg4;
        }
        return false;
    }

    public static YJSoundType getInmSoundType(ItemStack stack) {
        if (stack.getItem() instanceof BlockItem blockItem && Arrays.stream(YJBlocks.INM_BLOCKS).anyMatch(n -> n.get() == blockItem.getBlock()) && blockItem.getBlock().getSoundType(blockItem.getBlock().defaultBlockState()) instanceof YJSoundType soundType)
            return soundType;
        return null;
    }

    public static boolean isYJDim(Level level) {
        return level.dimension() == YJ_DIMENSION;
    }

    public static ResourceKey<Level> getYJDimension() {
        return YJ_DIMENSION;
    }

    public static boolean isIkisugiDamage(DamageSource damageSource) {
        return damageSource.is(YJDamageTypeTags.IS_IKISUGI);
    }
}
