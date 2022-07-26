package net.morimori0317.yajusenpai.server.handler;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJPlayerUtils;
import net.morimori0317.yajusenpai.util.YJUtils;

public class ServerHandler {
    public static void init() {
        TickEvent.PLAYER_POST.register(ServerHandler::onPlayerTick);
        EntityEvent.LIVING_HURT.register(ServerHandler::onLivingHurt);
    }

    public static EventResult onLivingHurt(LivingEntity entity, DamageSource source, float amount) {
        if (!entity.getLevel().isClientSide() && source.isFire()) {
            int kc = -1;
            int akc = 0;
            for (ItemStack item : entity.getArmorSlots()) {
                if (YJUtils.hasKynEnchantment(item)) {
                    int ikc = 0;
                    if (item.getTag() != null)
                        ikc = item.getTag().getInt("kyn_count");
                    kc = Math.max(kc, ikc);
                    akc++;
                }
            }

            if (kc >= 0) {
                entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), YJSoundEvents.KYN_ATUIs[Mth.clamp(kc, 0, YJSoundEvents.KYN_ATUIs.length - 1)].get(), SoundSource.NEUTRAL, akc, 1);
                kc = (kc + 1) % YJSoundEvents.KYN_ATUIs.length;
                for (ItemStack item : entity.getArmorSlots()) {
                    if (YJUtils.hasKynEnchantment(item))
                        item.getOrCreateTag().putInt("kyn_count", kc);
                }
            }
        }
        return EventResult.pass();
    }

    private static void onPlayerTick(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            for (ItemStack item : serverPlayer.getArmorSlots()) {
                if (YJUtils.hasGabaAnaDaddyEnchantment(item))
                    futoiSeaChickenTick(serverPlayer);
            }
        }
    }

    public static void futoiSeaChickenTick(ServerPlayer serverPlayer) {
        if (serverPlayer.getRandom().nextInt(20 * 60 * 2) == 0) {
            YJPlayerUtils.giveItem(serverPlayer, YJUtils.createFutoiSeaChicken());
            serverPlayer.level.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), YJSoundEvents.GABAANADADDY_FUTOI_SEA_CHICKEN_GAHOSHII.get(), SoundSource.NEUTRAL, 0.3f, 1);
        }
    }
}
