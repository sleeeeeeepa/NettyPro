package com.xxs.netty.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        //初始化5个大小的intbuffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //只能放5个因为初始化为5  如果超出报错
        // java.nio.BufferOverflowException
        for (int i = 0; i < 8; i+=2) {
            intBuffer.put(i);
        }

        intBuffer.flip();
//        intBuffer.flip(); 如果翻转两次再去读会因为position与limit都是0而导致无法读取


//        while (intBuffer.hasRemaining()) {
//            System.out.println(intBuffer.get());
//        }
        for (int i = 0; i < 3; i++) {
            System.out.println(intBuffer.get());
        }
        intBuffer.flip();
//        intBuffer.position(3);
        intBuffer.put(200);
        System.out.println(intBuffer.array());
    }
}
