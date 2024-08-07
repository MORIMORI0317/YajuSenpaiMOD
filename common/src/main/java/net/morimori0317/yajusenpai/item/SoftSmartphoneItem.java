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
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
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

        if (((YJLivingEntityAccessor) player).yajuSenpai$isComa())
            return InteractionResultHolder.pass(itemStack);

        var entities = level.getEntitiesOfClass(LivingEntity.class, getArea(player));
        if (entities.stream().noneMatch(e -> e != player && ((YJLivingEntityAccessor) e).yajuSenpai$getSleepingPos() != null && ((YJLivingEntityAccessor) e).yajuSenpai$isComa() && !((YJLivingEntityAccessor) e).yajuSenpai$isIkisugiSleeping()))
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

        var entities = level.getEntitiesOfClass(LivingEntity.class, getArea(livingEntity));
        boolean[] flg = {false};
        entities.stream().filter(e -> canIkisugi(livingEntity, e)).forEach(e -> {
            startIkisugi(level, livingEntity, e);
            flg[0] = true;
        });
        if (!level.isClientSide()) {
            if (flg[0])
                itemStack.hurtAndBreak(1, livingEntity, EquipmentSlot.MAINHAND);

            if (flg[0] && livingEntity.getRandom().nextInt(1919) == 0)
                livingEntity.addEffect(new MobEffectInstance(YJMobEffects.IKISUGI.vanillaHolder(), CommonHandler.IKISUGI_DIE_TIME));
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }

    public static boolean canIkisugi(LivingEntity attacker, LivingEntity target) {
        return target != attacker &&
                ((YJLivingEntityAccessor) target).yajuSenpai$getSleepingPos() != null &&
                ((YJLivingEntityAccessor) target).yajuSenpai$isComa() &&
                !((YJLivingEntityAccessor) target).yajuSenpai$isIkisugiSleeping();
    }

    public static void startIkisugi(Level level, LivingEntity attacker, LivingEntity target) {
        if (!level.isClientSide()) {
            target.addEffect(new MobEffectInstance(YJMobEffects.IKISUGI.vanillaHolder(), CommonHandler.IKISUGI_DIE_TIME));
            ((YJLivingEntityAccessor) target).yajuSenpai$setGrantedIkisugiEntity(attacker);
        }
        ((YJLivingEntityAccessor) target).yajuSenpai$setIkisugiSleeping(true);
    }

    @Override
    public int getUseDuration(ItemStack itemStack, LivingEntity livingEntity) {
        return 20 * 2 + 10;
    }

}