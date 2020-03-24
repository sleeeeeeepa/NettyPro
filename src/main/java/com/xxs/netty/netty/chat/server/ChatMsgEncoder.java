package com.xxs.netty.netty.chat.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

public class ChatMsgEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("发出信息 编码前"+msg);
        ByteBuf msg1 = Unpooled.copiedBuffer((String) msg, CharsetUtil.UTF_8);
        System.out.println("发出信息 编码后"+msg1.array());
        ctx.channel().writeAndFlush(msg1);
    }
}
