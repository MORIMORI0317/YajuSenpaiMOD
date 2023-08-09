package net.morimori0317.yajusenpai.data;

import com.google.common.collect.ImmutableList;
import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.model.ItemModelProviderAccess;
import dev.felnull.otyacraftengine.data.model.MutableFileModel;
import dev.felnull.otyacraftengine.data.model.OverridePredicate;
import dev.felnull.otyacraftengine.data.provider.ItemModelProviderWrapper;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.client.YJItemProperties;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJItemModelProviderWrapper extends ItemModelProviderWrapper {
    public YJItemModelProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
    }

    @Override
    public void generateItemModels(ItemModelProviderAccess providerAccess) {
        providerAccess.basicFlatItem(YJItems.ICON.get());

        providerAccess.basicFlatItem(YJItems.YJ_CORE.get());
        providerAccess.basicFlatItem(YJItems.YJ_STAR.get());

        providerAccess.basicFlatItem(YJItems.YJNIUM_INGOT.get());
        providerAccess.basicFlatItem(YJItems.YJNIUM_NUGGET.get());
        providerAccess.basicFlatItem(YJItems.RAW_YJNIUM.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_INGOT.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_NUGGET.get());
        providerAccess.basicFlatItem(YJItems.RAW_YJSNPI.get());

        providerAccess.basicFlatItem(YJItems.YJNIUM_HORSE_ARMOR.get());
        providerAccess.handheldFlatItem(YJItems.YJNIUM_SWORD.get());
        providerAccess.handheldFlatItem(YJItems.YJNIUM_PICKAXE.get());
        providerAccess.handheldFlatItem(YJItems.YJNIUM_AXE.get());
        providerAccess.handheldFlatItem(YJItems.YJNIUM_SHOVEL.get());
        providerAccess.handheldFlatItem(YJItems.YJNIUM_HOE.get());
        providerAccess.basicFlatItem(YJItems.YJNIUM_HELMET.get());
        providerAccess.basicFlatItem(YJItems.YJNIUM_CHESTPLATE.get());
        providerAccess.basicFlatItem(YJItems.YJNIUM_LEGGINGS.get());
        providerAccess.basicFlatItem(YJItems.YJNIUM_BOOTS.get());

        providerAccess.basicFlatItem(YJItems.YJSNPI_HORSE_ARMOR.get());
        providerAccess.handheldFlatItem(YJItems.YJSNPI_SWORD.get());
        providerAccess.handheldFlatItem(YJItems.YJSNPI_PICKAXE.get());
        providerAccess.handheldFlatItem(YJItems.YJSNPI_AXE.get());
        providerAccess.handheldFlatItem(YJItems.YJSNPI_SHOVEL.get());
        providerAccess.handheldFlatItem(YJItems.YJSNPI_HOE.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_HELMET.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_CHESTPLATE.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_LEGGINGS.get());
        providerAccess.basicFlatItem(YJItems.YJSNPI_BOOTS.get());

        providerAccess.basicFlatItem(YJItems.APPLE.get());
        providerAccess.basicFlatItem(YJItems.ICE_TEA.get());

        providerAccess.basicFlatItem(YJItems.BAKED_POTATO_SENPAI.get());

        providerAccess.handheldFlatItem(YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get());
        providerAccess.basicFlatItem(YJItems.CYCLOPS_SUNGLASSES.get());
        providerAccess.basicFlatItem(YJItems.BRIEF.get());
        softSmartphone(providerAccess);
    }

    private static void softSmartphone(ItemModelProviderAccess providerAccess) {
        MutableFileModel model = providerAccess.basicFlatItem(YJItems.SOFT_SMARTPHONE.get());

        model.override(providerAccess.existingModel(YJUtils.modLoc("item/soft_smartphone_using")), ImmutableList.of(new OverridePredicate(YJItemProperties.SOFT_SMARTPHONE_USING, 1)));
    }
}
