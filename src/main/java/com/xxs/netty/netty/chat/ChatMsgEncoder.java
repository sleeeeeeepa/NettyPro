package com.xxs.netty.netty.chat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class ChatMsgEncoder extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接受消息开始解码
        ByteBuf buf = (ByteBuf) msg;
        ctx.fireChannelRead(new String(buf.array(), Charset.forName("utf-8")));
    }
}
