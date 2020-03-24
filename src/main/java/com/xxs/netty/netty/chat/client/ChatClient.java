package com.xxs.netty.netty.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {
    private Bootstrap bootstrap;
    public SocketChannel socketChannel;

    public ChatClient() {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .handler(new ChatClientChannelInitializer());
    }
    public void run (){
        try {
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 7777).sync();
            sync.addListener((ChannelFutureListener) future -> socketChannel = (SocketChannel) future.channel());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClient().run();
    }
}
