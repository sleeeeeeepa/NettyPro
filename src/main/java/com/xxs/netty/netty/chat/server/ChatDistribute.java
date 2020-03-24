package com.xxs.netty.netty.chat.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

public class ChatDistribute extends SimpleChannelInboundHandler<String> {

//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        System.out.println(ctx.channel().remoteAddress()+"上线");
//        ChatServer.channelGroup.add(ctx.channel());
//    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        String msg1 = (String) msg;
        System.out.println("准备分发消息" + msg1);
        //准备分发信息
        for (Channel socketChannel : ChatServer.socketChannelList) {
            if(socketChannel != ctx.channel()){
                socketChannel.writeAndFlush(socketChannel.remoteAddress()+":"+msg1);
            }
        }
    }
}
