package com.xxs.netty.netty.chat.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class ChatMsgDecoder extends ChannelInboundHandlerAdapter {
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //接受消息开始解码
//        ByteBuf heapBuffer = ctx.alloc().heapBuffer();
//        ByteBuf buf = (ByteBuf) heapBuffer;
//        System.out.println("接受到信息 解码前"+buf.array());
//        String msg1 = new String(buf.array(), Charset.forName("utf-8"));
//        System.out.println("接受到信息 解码前"+msg1);
//
////        ctx.fireChannelRead(msg1);
//    }
}
