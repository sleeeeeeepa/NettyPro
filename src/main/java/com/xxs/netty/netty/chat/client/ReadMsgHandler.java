package com.xxs.netty.netty.chat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

public class ReadMsgHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("接收到消息"+(String)msg);
        super.channelRead(ctx, msg);
    }

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
        new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.err.println("输入：");
                    Scanner scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    ctx.channel().writeAndFlush(s);
                }
            }
        }.run();
    }

}
