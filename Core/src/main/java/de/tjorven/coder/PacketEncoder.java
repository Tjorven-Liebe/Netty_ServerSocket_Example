package de.tjorven.coder;

import de.tjorven.packet.Packet;
import de.tjorven.serialization.PacketSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * The encoder is used to convert a packet into Base64 while sending it through the Pipeline. It will be decoded in the PacketDecoder again
     * @see PacketDecoder
     *
     * @param ctx           the {@link ChannelHandlerContext} which this {@link MessageToByteEncoder} belongs to
     * @param packet           the message to encode
     * @param out           the {@link ByteBuf} into which the encoded message will be written
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        String string = PacketSerializer.packetToBase64(packet);
        out.writeInt(string.length());
        out.writeCharSequence(string, StandardCharsets.UTF_8);
    }
}
