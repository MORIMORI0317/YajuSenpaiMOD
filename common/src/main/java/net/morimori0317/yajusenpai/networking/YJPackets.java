package net.morimori0317.yajusenpai.networking;

import dev.architectury.networking.NetworkManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.client.handler.ClientMessageHandler;

public class YJPackets {
    public static final ResourceLocation SLEEP = new ResourceLocation(YajuSenpai.MODID, "sleep");
    public static final ResourceLocation COMA_SYNC = new ResourceLocation(YajuSenpai.MODID, "coma_sync");

    public static void clientInit() {
        NetworkManager.registerReceiver(NetworkManager.s2c(), SLEEP, (friendlyByteBuf, packetContext) -> ClientMessageHandler.onSleepMessage(new SleepMessage(friendlyByteBuf), packetContext));
        NetworkManager.registerReceiver(NetworkManager.s2c(), COMA_SYNC, (friendlyByteBuf, packetContext) -> ClientMessageHandler.onComaSyncMessage(new ComaSyncMessage(friendlyByteBuf), packetContext));
    }

    public static record ComaSyncMessage(int entityId, boolean coma) implements PacketMessage {
        private ComaSyncMessage(FriendlyByteBuf bf) {
            this(bf.readInt(), bf.readBoolean());
        }

        @Override
        public FriendlyByteBuf toFBB(FriendlyByteBuf buf) {
            buf.writeInt(entityId);
            buf.writeBoolean(coma);
            return buf;
        }
    }

    public static record SleepMessage(int entityId, BlockPos pos, boolean del) implements PacketMessage {
        private SleepMessage(FriendlyByteBuf bf) {
            this(bf.readInt(), bf.readBlockPos(), bf.readBoolean());
        }

        @Override
        public FriendlyByteBuf toFBB(FriendlyByteBuf buf) {
            buf.writeInt(entityId);
            buf.writeBlockPos(pos);
            buf.writeBoolean(del);
            return buf;
        }
    }
}
