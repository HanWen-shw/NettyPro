package com.shw.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel channel1 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){
            byteBuffer.clear();
            int read = channel1.read(byteBuffer);
            System.out.println("read:" + read);
            if (read == -1){
                break;
            }
            byteBuffer.flip();
            channel2.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}

