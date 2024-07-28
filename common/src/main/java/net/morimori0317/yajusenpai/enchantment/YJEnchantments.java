package net.morimori0317.yajusenpai.enchantment;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJEnchantments {
    private static final ResourceLocation GABA_ANA_DADDY_FONT_LOC = YJUtils.modLoc("gaba_ana_daddy");
    private static final Style GABA_ANA_DADDY_STYLE = Style.EMPTY.withFont(GABA_ANA_DADDY_FONT_LOC);

    public static final ResourceKey<Enchantment> KATYOU_BROKEN = key("katyou_broken");
    public static final ResourceKey<Enchantment> GABA_ANA_DADDY = key("gaba_ana_daddy");
    public static final ResourceKey<Enchantment> KYN = key("kyn");

    private static ResourceKey<Enchantment> key(String id) {
        return ResourceKey.create(Registries.ENCHANTMENT, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<Enchantment> register) {
        register.add(KATYOU_BROKEN, context -> {
            HolderGetter<Item> itemGetter = context.lookup(Registries.ITEM);

            Enchantment.EnchantmentDefinition definition =
                    Enchantment.definition(
                            itemGetter.getOrThrow(YJItemTags.KATYOU_BROKEN_ENCHANTABLE),
                            1, 1,
                            Enchantment.constantCost(25),
                            Enchantment.constantCost(50),
                            8, EquipmentSlotGroup.ANY);

            return Enchantment.enchantment(definition)
                    .withEffect(YJEnchantmentEffectComponents.KATYOU_BROKEN.get())
                    .build(KATYOU_BROKEN.location());
        });

        register.add(GABA_ANA_DADDY, context -> {
            HolderGetter<Item> itemGetter = context.lookup(Registries.ITEM);
            Enchantment.EnchantmentDefinition definition =
                    Enchantment.definition(
                            itemGetter.getOrThrow(YJItemTags.GABA_ANA_DADDY_ENCHANTABLE),
                            1, 1,
                            Enchantment.constantCost(25),
                            Enchantment.constantCost(50),
                            8, EquipmentSlotGroup.ANY);

            DataComponentMap.Builder effectMapBuilder = DataComponentMap.builder();
            effectMapBuilder.set(YJEnchantmentEffectComponents.GABA_ANA_DADDY.get(), Unit.INSTANCE);

            Component component = Component.translatable(Util.makeDescriptionId("enchantment", GABA_ANA_DADDY.location()))
                    .withStyle(GABA_ANA_DADDY_STYLE);
            return new Enchantment(component, definition, HolderSet.direct(new Holder[0]), effectMapBuilder.build());

        });

        register.add(KYN, context -> {
            HolderGetter<Item> itemGetter = context.lookup(Registries.ITEM);
            Enchantment.EnchantmentDefinition definition =
                    Enchantment.definition(
                            itemGetter.getOrThrow(YJItemTags.KYN_ENCHANTABLE),
                            1, 1,
                            Enchantment.constantCost(25),
                            Enchantment.constantCost(50),
                            8,
                            EquipmentSlotGroup.ARMOR, EquipmentSlotGroup.HAND);

            return Enchantment.enchantment(definition)
                    .withEffect(YJEnchantmentEffectComponents.KYN.get())
                    .build(KYN.location());
        });
    }
}
