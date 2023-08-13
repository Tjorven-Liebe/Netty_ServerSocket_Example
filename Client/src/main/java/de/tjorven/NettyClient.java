package de.tjorven;

import de.tjorven.packet.DefaultPacket;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) {
        new NettyClient();
    }

    public NettyClient() {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new PacketEncoder(), new PacketDecoder(), new ClientHandler());
                }
            });
            ChannelFuture sync = bootstrap.connect("localhost", 8080).sync();
            sync.channel().writeAndFlush(new DefaultPacket<>("test", "testType")).sync();
            sync.channel().writeAndFlush(new DefaultPacket<>("test", 500)).sync();
            sync.channel().writeAndFlush(new DefaultPacket<>("test", new TollesObject("Test", 50))).sync();
        } catch (Exception e) {
            worker.shutdownGracefully();
        }
    }

}
