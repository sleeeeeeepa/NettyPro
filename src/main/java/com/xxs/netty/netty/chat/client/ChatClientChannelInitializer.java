package com.xxs.netty.netty.chat.client;

import com.xxs.netty.netty.chat.ChatMsgCoder;
import com.xxs.netty.netty.groupChat.GroupChatClientHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
//                .addLast(new StringDecoder())
//                .addLast(new StringEncoder())
                .addLast(new ChatMsgCoder())
                .addLast(new ReadMsgHandler())
//                .addLast(new SendMsgHandler())
        ;
    }
}
