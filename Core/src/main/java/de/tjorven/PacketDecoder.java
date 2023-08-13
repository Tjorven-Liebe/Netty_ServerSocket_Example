package de.tjorven;

import de.tjorven.packet.Packet;
import de.tjorven.serialization.PacketSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class PacketDecoder extends ReplayingDecoder<Packet> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketSerializer.base64ToPacket((String) in.readCharSequence(in.readInt(), StandardCharsets.UTF_8)));
    }
}
