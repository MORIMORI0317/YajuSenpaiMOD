package net.morimori0317.yajusenpai.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;

public interface PacketMessage {
    FriendlyByteBuf toFBB(RegistryFriendlyByteBuf buf);
}
