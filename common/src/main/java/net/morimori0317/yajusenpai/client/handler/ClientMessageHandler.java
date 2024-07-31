package net.morimori0317.yajusenpai.client.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.networking.YJPackets;

public class ClientMessageHandler {

    public static void onComaSyncMessage(YJPackets.ComaSyncMessage message, NetworkManager.PacketContext packetContext) {
        packetContext.queue(() -> {
            Minecraft mc = Minecraft.getInstance();
            var entity = mc.level.getEntity(message.entityId());
            if (entity instanceof LivingEntity livingEntity) {
                YJLivingEntityAccessor yjLiving = (YJLivingEntityAccessor) livingEntity;
                yjLiving.yajuSenpai$setComaSync(message.coma());
            }
        });
    }

    public static void onSleepMessage(YJPackets.SleepMessage message, NetworkManager.PacketContext packetContext) {
        packetContext.queue(() -> {
            Minecraft mc = Minecraft.getInstance();
            var entity = mc.level.getEntity(message.entityId());
            if (entity instanceof LivingEntity livingEntity) {
                if (message.del()) {
                    ((YJLivingEntityAccessor) livingEntity).yajuSenpai$setSleepingPos(null);
                } else {
                    ((YJLivingEntityAccessor) livingEntity).yajuSenpai$setSleepingPos(message.pos());
                }
            }
        });
    }
}
