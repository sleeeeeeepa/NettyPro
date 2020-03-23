package com.xxs.netty.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.List;

public class ChatServer {
    private ServerBootstrap serverBootstrap;
    public static List<SocketChannel> socketChannelList;

    public ChatServer() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_BACKLOG, 128)
                .childHandler(new ChatServerChannelInitializer());
    }
    public void run () {
        try {
            serverBootstrap.bind(7777).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatServer().run();
    }
}
