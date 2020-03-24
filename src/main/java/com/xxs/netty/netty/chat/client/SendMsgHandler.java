package com.xxs.netty.netty.chat.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Scanner;

public class SendMsgHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.channel().eventLoop().execute(() -> {
//            while (true) {
//                System.err.println("输入：");
//                Scanner scanner = new Scanner(System.in);
//                String s = scanner.nextLine();
//                ctx.channel().writeAndFlush(s);
//            }
//        });
    }
}
