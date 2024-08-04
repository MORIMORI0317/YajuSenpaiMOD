package net.morimori0317.yajusenpai.networking;

import dev.architectury.networking.NetworkManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.morimori0317.yajusenpai.client.handler.ClientMessageHandler;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.jetbrains.annotations.NotNull;

public class YJPackets {
    public static final CustomPacketPayload.Type<ComaSyncMessage> COMA_SYNC_TYPE = new CustomPacketPayload.Type<>(YJUtils.modLoc("coma_sync"));
    public static final CustomPacketPayload.Type<SleepMessage> SLEEP_TYPE = new CustomPacketPayload.Type<>(YJUtils.modLoc("sleep"));

    private static final StreamCodec<RegistryFriendlyByteBuf, ComaSyncMessage> COMA_SYNC_CODEC = new StreamCodec<>() {
        @Override
        public @NotNull ComaSyncMessage decode(RegistryFriendlyByteBuf buf) {
            return new ComaSyncMessage(buf);
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, ComaSyncMessage msg) {
            msg.toFBB(buf);
        }
    };

    private static final StreamCodec<RegistryFriendlyByteBuf, SleepMessage> SLEEP_CODEC = new StreamCodec<>() {
        @Override
        public SleepMessage decode(RegistryFriendlyByteBuf buf) {
            return new SleepMessage(buf);
        }

        @Override
        public void encode(RegistryFriendlyByteBuf buf, SleepMessage msg) {
            msg.toFBB(buf);
        }
    };

    public static void clientInit() {
        NetworkManager.registerReceiver(NetworkManager.s2c(), COMA_SYNC_TYPE, COMA_SYNC_CODEC, ClientMessageHandler::onComaSyncMessage);
        NetworkManager.registerReceiver(NetworkManager.s2c(), SLEEP_TYPE, SLEEP_CODEC, ClientMessageHandler::onSleepMessage);
    }

    public static void serverInit() {
        NetworkManager.registerS2CPayloadType(COMA_SYNC_TYPE, COMA_SYNC_CODEC);
        NetworkManager.registerS2CPayloadType(SLEEP_TYPE, SLEEP_CODEC);
    }

    public record ComaSyncMessage(int entityId, boolean coma) implements PacketMessage, CustomPacketPayload {
        private ComaSyncMessage(RegistryFriendlyByteBuf bf) {
            this(bf.readInt(), bf.readBoolean());
        }

        @Override
        public FriendlyByteBuf toFBB(RegistryFriendlyByteBuf buf) {
            buf.writeInt(entityId);
            buf.writeBoolean(coma);
            return buf;
        }

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return COMA_SYNC_TYPE;
        }
    }

    public record SleepMessage(int entityId, BlockPos pos, boolean del) implements PacketMessage, CustomPacketPayload {
        private SleepMessage(RegistryFriendlyByteBuf bf) {
            this(bf.readInt(), bf.readBlockPos(), bf.readBoolean());
        }

        @Override
        public FriendlyByteBuf toFBB(RegistryFriendlyByteBuf buf) {
            buf.writeInt(entityId);
            buf.writeBlockPos(pos);
            buf.writeBoolean(del);
            return buf;
        }

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return SLEEP_TYPE;
        }
    }
}
