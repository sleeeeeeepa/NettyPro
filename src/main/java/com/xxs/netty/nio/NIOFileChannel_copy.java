package com.xxs.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel_copy {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\xxs\\Desktop\\xxs.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xxs\\Desktop\\xxs2.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1);
        while (true){
//            buffer.clear();
            int read = inputStreamChannel.read(buffer);
            if (read == -1) {
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);

        }
        inputStreamChannel.close();
        outputStreamChannel.close();


    }

}
