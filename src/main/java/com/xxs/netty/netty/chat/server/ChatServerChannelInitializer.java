package com.xxs.netty.netty.chat.server;

import com.xxs.netty.netty.chat.ChatMsgCoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
//                .addLast(new RegisterHandler())
                .addLast(new StringDecoder())
                .addLast(new StringEncoder())
//                .addLast(new ChatMsgCoder())
                .addLast(new ChatDistribute());
    }
}
