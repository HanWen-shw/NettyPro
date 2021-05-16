package com.shw.netty.dubborpc.consumer;

import com.shw.netty.dubborpc.netty.NettyClient;
import com.shw.netty.dubborpc.publicinterface.HelloService;

public class ClientBootstrap {

    //协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws InterruptedException {
        NettyClient client = new NettyClient();
        HelloService helloService = (HelloService)client.getBean(HelloService.class, providerName);


//        String hello = helloService.hello("dubbo rpc!");
//        System.out.println("收到的结果" + hello);
        for (;; ) {
            Thread.sleep(1000);
            //通过代理对象调用服务提供者的方法(服务)
            String res = helloService.hello("你好 dubbo~");
            System.out.println("调用的结果 res= " + res);
        }
    }

}
