package net.morimori.yjsnpimod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.effect.YJEffects;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class IceTeaItem extends Item implements IDetailedInfomationItem {
    public IceTeaItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ITEM_HONEY_BOTTLE_DRINK;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.world.isRemote)
            return super.hitEntity(stack, target, attacker);

        if (!target.getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
            YJFoods.ICE_TEA.getEffects().stream().forEach(n -> target.addPotionEffect(n.getFirst()));
            target.world.playSound((PlayerEntity) null, target.getPosX(), target.getPosY(), target.getPosZ(), YJSoundEvents.YJ_OTTODAIJOUBUKA, SoundCategory.VOICE, 3, 1);
            if (!(attacker instanceof PlayerEntity && ((PlayerEntity) attacker).isCreative())) {
                stack.shrink(1);
            }
        }
        return super.hitEntity(stack, target, attacker);
    }
}
