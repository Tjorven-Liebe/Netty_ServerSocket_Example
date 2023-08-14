package de.tjorven.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        System.out.println("Channel with id: '" + channelHandlerContext.channel().id().asLongText() + "' registered");
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) {
        if (message instanceof String string)
            System.out.println(string);
    }
}
