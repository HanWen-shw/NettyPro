package com.shw.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入处理器
        ChannelPipeline pipeline = ch.pipeline();
        //HttpServerCodec 是netty 提供的处理http的 编-解码器
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        //自定义handler
        pipeline.addLast("httpServerHandler",new HttpServerHandler());
    }
}
