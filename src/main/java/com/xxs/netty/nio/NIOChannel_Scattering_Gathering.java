package com.xxs.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NIOChannel_Scattering_Gathering {
    public static void main(String[] args) throws IOException {
        //创建一个nio服务端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //监听7000端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口并启动
        serverSocketChannel.bind(inetSocketAddress);
        //初始化bytebuffer
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        //监听acc事件
        SocketChannel channel = serverSocketChannel.accept();
        //循环读取通道内容
        while (true) {
            channel.read(byteBuffers);
            System.out.println("111");
            //将通道内容写回
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
//            channel.write(byteBuffers);

            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
        }

    }
}
