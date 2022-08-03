package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
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
        player.startUsingItem(interactionHand);
        level.playSound(player, player, YJSoundEvents.YJ_ANTIPROLIFERATION.get(), SoundSource.RECORDS, 1f, 1.0F);
        player.getCooldowns().addCooldown(this, 10);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 20 * 3;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!player.level.isClientSide) {
            itemStack.hurtAndBreak(1, player, (livingEntityx) -> livingEntityx.broadcastBreakEvent(interactionHand));
        }
        return InteractionResult.sidedSuccess(player.level.isClientSide);
    }
}
