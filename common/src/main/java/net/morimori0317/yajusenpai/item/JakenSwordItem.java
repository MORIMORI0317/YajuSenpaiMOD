package net.morimori0317.yajusenpai.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.morimori0317.yajusenpai.util.YJUtils;

public class JakenSwordItem extends SwordItem implements YJToolItem {
    public static final ResourceLocation JAKEN_ENTITY_INTERACTION_RANGE_ID = YJUtils.modLoc("jaken_entity_interaction_range");
    public static final ResourceLocation JAKEN_BLOCK_INTERACTION_RANGE_ID = YJUtils.modLoc("jaken_block_interaction_range");

    public JakenSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        YJToolItem.hurtEnemy(target, attacker, true);
        super.postHurtEnemy(itemStack, target, attacker);
    }

    public static ItemAttributeModifiers createJakenAttributes(Tier tier, int i, float f) {
        ItemAttributeModifiers ret = SwordItem.createAttributes(tier, i, f);

        ret = ret.withModifierAdded(Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(JAKEN_ENTITY_INTERACTION_RANGE_ID, 3.64, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND);
        ret = ret.withModifierAdded(Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(JAKEN_BLOCK_INTERACTION_RANGE_ID, 3.64, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND);

        return ret;
    }
}
