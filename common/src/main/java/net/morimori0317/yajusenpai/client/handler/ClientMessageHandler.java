package net.morimori0317.yajusenpai.client.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.networking.YJPackets;

public class ClientMessageHandler {
    private static final Minecraft mc = Minecraft.getInstance();

    public static void onComaSyncMessage(YJPackets.ComaSyncMessage message, NetworkManager.PacketContext packetContext) {
        packetContext.queue(() -> {
            var entity = mc.level.getEntity(message.entityId());
            if (entity instanceof LivingEntity livingEntity) {
                YJLivingEntity yjLiving = (YJLivingEntity) livingEntity;
                yjLiving.setComaSync(message.coma());
            }
        });
    }

    public static void onSleepMessage(YJPackets.SleepMessage message, NetworkManager.PacketContext packetContext) {
        packetContext.queue(() -> {
            var entity = mc.level.getEntity(message.entityId());
            if (entity instanceof LivingEntity livingEntity) {
                if (message.del()) {
                    ((YJLivingEntity) livingEntity).setSleepingPos(null);
                } else {
                    ((YJLivingEntity) livingEntity).setSleepingPos(message.pos());
                }
            }
        });
    }
}
