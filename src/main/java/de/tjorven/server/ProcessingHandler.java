package de.tjorven.server;

import de.tjorven.packet.DefaultPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ProcessingHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel with id: '" + ctx.channel().id().asLongText() + "' registered: " + ctx.channel().id().asLongText());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof DefaultPacket<?>) {
            ((DefaultPacket<?>) msg).run();
        }
    }
}
