package com.shw.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("/Users/shw/Desktop/shw/z.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("z.jpg");
        FileChannel source = fileInputStream.getChannel();
        FileChannel target = fileOutputStream.getChannel();
        //拷贝
        target.transferFrom(source,0,source.size());
        fileInputStream.close();
        fileOutputStream.close();

    }
}
