package com.xxs.netty.netty.chat;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

public class ChatDistribute extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String msg1 = (String) msg;

        //准备分发信息
        for (SocketChannel socketChannel : ChatServer.socketChannelList) {
            if(socketChannel != ctx.channel()){
                socketChannel.writeAndFlush(msg1);
            }
        }
    }
}
