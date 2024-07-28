package net.morimori0317.yajusenpai.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.client.YJItemProperties;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.model.FileTexture;
import net.morimori0317.yajusenpai.data.cross.model.ItemModelProviderAccess;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import net.morimori0317.yajusenpai.data.cross.model.OverridePredicate;
import net.morimori0317.yajusenpai.data.cross.provider.ItemModelProviderWrapper;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJItemModelProvider extends ItemModelProviderWrapper {
    public YJItemModelProvider(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
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
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_INGOT.get());
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_NUGGET.get());
        providerAccess.basicFlatItem(YJItems.RAW_YAJUSENPAI.get());

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

        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_HORSE_ARMOR.get());
        providerAccess.handheldFlatItem(YJItems.YAJUSENPAI_SWORD.get());
        providerAccess.handheldFlatItem(YJItems.YAJUSENPAI_PICKAXE.get());
        providerAccess.handheldFlatItem(YJItems.YAJUSENPAI_AXE.get());
        providerAccess.handheldFlatItem(YJItems.YAJUSENPAI_SHOVEL.get());
        providerAccess.handheldFlatItem(YJItems.YAJUSENPAI_HOE.get());
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_HELMET.get());
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_CHESTPLATE.get());
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_LEGGINGS.get());
        providerAccess.basicFlatItem(YJItems.YAJUSENPAI_BOOTS.get());

        providerAccess.basicFlatItem(YJItems.APPLE_INM.get());
        providerAccess.basicFlatItem(YJItems.ICE_TEA.get());

        providerAccess.basicFlatItem(YJItems.BAKED_POTATO_SENPAI.get());

        providerAccess.handheldFlatItem(YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get());
        providerAccess.basicFlatItem(YJItems.CYCLOPS_SUNGLASSES.get());
        providerAccess.basicFlatItem(YJItems.BRIEF.get());
        softSmartphone(providerAccess);
        oBack(providerAccess);
    }

    private static void softSmartphone(ItemModelProviderAccess providerAccess) {
        MutableFileModel model = providerAccess.basicFlatItem(YJItems.SOFT_SMARTPHONE.get());
        model.override(providerAccess.existingModel(YJUtils.modLoc("item/soft_smartphone_using")), ImmutableList.of(new OverridePredicate(YJItemProperties.SOFT_SMARTPHONE_USING, 1)));
    }

    private static void oBack(ItemModelProviderAccess providerAccess) {
        MutableFileModel rotationModel = providerAccess.basicFlatItem(FileTexture.of(YJUtils.modLoc("rotation_o_back")));
        MutableFileModel model = providerAccess.basicFlatItem(YJItems.O_BACK.get());
        model.override(rotationModel, ImmutableList.of(new OverridePredicate(YJItemProperties.O_BACK_ROTATION, 1)));
    }
}
