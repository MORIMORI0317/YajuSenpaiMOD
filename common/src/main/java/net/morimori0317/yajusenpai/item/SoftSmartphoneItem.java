package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.handler.CommonHandler;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class SoftSmartphoneItem extends Item {
    public SoftSmartphoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.TOOT_HORN;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (((YJLivingEntity) player).isComa())
            return InteractionResultHolder.pass(itemStack);

        var entities = level.getEntitiesOfClass(LivingEntity.class, getArea(player));
        if (entities.stream().noneMatch(e -> e != player && ((YJLivingEntity) e).getSleepingPos() != null && ((YJLivingEntity) e).isComa() && !e.hasEffect(YJMobEffects.IKISUGI.get())))
            return InteractionResultHolder.pass(itemStack);

        player.startUsingItem(interactionHand);
        level.playSound(player, player, YJSoundEvents.YJ_ABARENNAYO.get(), SoundSource.RECORDS, 1f, 1.0F);
        player.getCooldowns().addCooldown(this, 10);
        return InteractionResultHolder.consume(itemStack);
    }

    private AABB getArea(LivingEntity livingEntity) {
        return new AABB(livingEntity.position().x() - 3, livingEntity.position().y(), livingEntity.position().z() - 3, livingEntity.position().x() + 3 + livingEntity.getBbWidth(), livingEntity.position().y() + 3 + livingEntity.getBbHeight(), livingEntity.position().z() + 3 + livingEntity.getBbWidth());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide()) {
            var entities = level.getEntitiesOfClass(LivingEntity.class, getArea(livingEntity));
            boolean[] flg = {false};
            entities.stream().filter(e -> e != livingEntity && ((YJLivingEntity) e).getSleepingPos() != null && ((YJLivingEntity) e).isComa() && !e.hasEffect(YJMobEffects.IKISUGI.get())).forEach(e -> {
                e.addEffect(new MobEffectInstance(YJMobEffects.IKISUGI.get(), CommonHandler.IKISUGI_DIE_TIME));
                ((YJLivingEntity) e).setGrantedIkisugiEntity(livingEntity);
                flg[0] = true;
            });

            if (flg[0])
                itemStack.hurtAndBreak(1, livingEntity, (livingEntityx) -> livingEntityx.broadcastBreakEvent(EquipmentSlot.MAINHAND));

            if (flg[0] && livingEntity.getRandom().nextInt(19) == 0)
                livingEntity.addEffect(new MobEffectInstance(YJMobEffects.IKISUGI.get(), CommonHandler.IKISUGI_DIE_TIME));
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 20 * 2 + 10;
    }
}
