package com.xxs.netty.netty.chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ChatServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new RegisterHandler())
                .addLast(new ChatMsgEncoder())
                .addLast(new ChatMsgDecoder())
                .addLast(new ChatDistribute());
    }
}
