package com.xxs.netty.netty.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

public class ChatMsgCoder extends MessageToMessageCodec {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        try {
            String e = String.valueOf(msg);
            System.out.println("encode"+e);
            out.add(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, Object msg, List out) throws Exception {
        String e = String.valueOf(msg);
        System.out.println("decode"+e);
        out.add(e);
    }
}
