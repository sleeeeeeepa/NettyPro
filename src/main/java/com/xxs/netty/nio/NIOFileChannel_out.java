package com.xxs.netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;

public class NIOFileChannel_out {

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(9);
        byte[] bytes = "薛旭升".getBytes();

        //写入buffer
        byteBuffer.put(bytes);

        //等到一个输出流并转为文件通道
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xxs\\Desktop\\xxs.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();

        byteBuffer.flip();
        //将buffer写入通道
        fileChannel.write(byteBuffer);

        fileChannel.close();

    }

}
