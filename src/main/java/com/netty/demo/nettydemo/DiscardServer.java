/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package com.netty.demo.nettydemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: DiscardServer, v0.1
 * @date 2017年08月27日 13:18 Exp $
 */

public class DiscardServer {
    private static final Logger logger = LoggerFactory.getLogger(DiscardServer.class);

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run() throws Exception{
        // NioEventLoopGroup是一个处理IO操作的事件循环，
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DiscardServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            // bind and start to accept incoming connections

            ChannelFuture f = b.bind(port).sync();
            System.out.println("启动服务");
            logger.error("启动服务");
            // wait until the server socket is closed.
            // In this example,this does not happen,but you can do that to gracefully
            // shut down your server
            f.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }


    // 使用telnet 127.0.0.1 8080
    public static void main(String[] args) throws Exception {
        int port;
        if(args.length > 0){
            port = Integer.valueOf(args[0]);
        }else {
            port = 8080;
        }

        new DiscardServer(port).run();
    }
}
