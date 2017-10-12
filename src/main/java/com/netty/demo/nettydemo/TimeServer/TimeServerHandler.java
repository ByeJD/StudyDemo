package com.netty.demo.nettydemo.TimeServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.channels.Channels;

/**
 * @author Quan
 * @date 2017/9/4
 * @desciption
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当一个链接被建立并准备产生交通的时候，channelActive被激活
     * @param ctx
     */
    @Override
    public void channelActive(final ChannelHandlerContext ctx){

//        System.out.println("channel active");
//        final ByteBuf time = ctx.alloc().buffer(4);
//        time.writeInt((int)(System.currentTimeMillis() / 1000L + 2208988800L));
//
//        final ChannelFuture f = ctx.writeAndFlush(time);
//
//        f.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture future) throws Exception {
//                assert f == future;
//                ctx.close();
//            }
//        });
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
