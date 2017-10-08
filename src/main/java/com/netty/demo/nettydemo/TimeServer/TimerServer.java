package com.netty.demo.nettydemo.TimeServer;

import com.netty.demo.nettydemo.discard.DiscardServerHandler;
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
 * @author Quan
 * @date 2017/9/4
 * @desciption
 */
public class TimerServer {
    private static final Logger logger = LoggerFactory.getLogger(TimerServer.class);

    private int port;

    public TimerServer(int port) {
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
                            socketChannel.pipeline().addLast(new TimeServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            // bind and start to accept incoming connections

            ChannelFuture f = b.bind(port).sync();
            System.out.println("启动服务");
            logger.info("启动服务");
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

        new TimerServer(port).run();
    }
}
