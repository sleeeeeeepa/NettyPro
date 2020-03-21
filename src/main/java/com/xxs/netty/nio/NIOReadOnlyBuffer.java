package com.xxs.netty.nio;

import java.nio.IntBuffer;

public class NIOReadOnlyBuffer {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        IntBuffer intBuffer1 = intBuffer.asReadOnlyBuffer();
        intBuffer.put(12);
        intBuffer.put(13);
//        intBuffer1.put(13);
        intBuffer1.limit(2);
        intBuffer1.flip();
        intBuffer1.put(15);
        System.out.println(intBuffer1.get());


    }
}
