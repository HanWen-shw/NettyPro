package com.shw.nio;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        for(int i = 0; i < 64; i++) {
            buffer.put((byte)i);
        }
        //读取
        buffer.flip();
        //只读
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }
        readOnlyBuffer.put((byte)100); //ReadOnlyBufferException
    }
}
