package com.example.dubbodo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TimeStampClient {

    private final String host;
    private final int port;

    public TimeStampClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 public void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();
                     p.addLast(new StringDecoder());
                     p.addLast(new StringEncoder());
                     p.addLast(new TimeStampClientHandler());
                 }
             });

            ChannelFuture f = b.connect(host, port).sync();
            f.channel().writeAndFlush("Hello, Netty!");
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeStampClient("localhost", 8080).start();
    }
}

class TimeStampClientHandler extends io.netty.channel.SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(io.netty.channel.ChannelHandlerContext ctx, String msg) {
        System.out.println("Received from server: " + msg);
    }

    @Override
    public void exceptionCaught(io.netty.channel.ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
