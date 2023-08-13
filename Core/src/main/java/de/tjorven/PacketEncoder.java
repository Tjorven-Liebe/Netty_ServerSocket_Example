package de.tjorven;

import de.tjorven.packet.Packet;
import de.tjorven.serialization.PacketSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        String string = PacketSerializer.packetToBase64(packet);
        out.writeInt(string.length());
        out.writeCharSequence(string, StandardCharsets.UTF_8);
    }
}
