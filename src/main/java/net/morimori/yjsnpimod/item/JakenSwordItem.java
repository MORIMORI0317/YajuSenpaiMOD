package net.morimori.yjsnpimod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.registry.YJDamageSource;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JakenSwordItem extends SwordItem {
    public JakenSwordItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        SoundEvent soundEvent = YJSoundEvents.YJ_ATTACK;
        if (attacker.getRandom().nextInt(114514) <= 810) {
            target.hurt(YJDamageSource.IKISUGI, 1145141919);
            soundEvent = YJSoundEvents.YJ_NU;
        }
        attacker.level.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), soundEvent, SoundSource.NEUTRAL, 5, 1);
        return super.hurtEnemy(itemStack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(new TranslatableComponent("tooltip.detailedinformation.item.yjsnpimod.jaken_yoruikimasyoune_sword").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }
}
