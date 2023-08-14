package de.tjorven.coder;

import de.tjorven.packet.Packet;
import de.tjorven.serialization.PacketSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class PacketDecoder extends ReplayingDecoder<Packet> {

    /**
     * The decoder is used to convert a Base64 string into a Packet after sending it through the Pipeline. It was encoded in the PacketEncoder before
     * @see PacketEncoder
     *
     * @param ctx           the {@link ChannelHandlerContext} which this {@link ByteToMessageDecoder} belongs to
     * @param in            the {@link ByteBuf} from which to read data
     * @param out           the {@link List} to which decoded messages should be added
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketSerializer.base64ToPacket((String) in.readCharSequence(in.readInt(), StandardCharsets.UTF_8)));
    }
}
