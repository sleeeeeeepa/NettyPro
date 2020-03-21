package com.xxs.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel_copy_transferfrom {

    public static void main(String[] args) throws Exception {
        //初始化文件通道
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\xxs\\Desktop\\1.png");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xxs\\Desktop\\2.png");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());


        inputStreamChannel.close();
        outputStreamChannel.close();
        fileInputStream.close();
        fileOutputStream.close();



    }
}
