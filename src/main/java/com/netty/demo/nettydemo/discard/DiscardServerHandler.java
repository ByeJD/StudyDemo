/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package com.netty.demo.nettydemo.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;


/**
 * 用途描述
 *
 * @author 刘全权
 * @date 2017年08月27日 12:50 Exp $
 */

/**
 * Handles a server-side channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx,Object msg){
        // Discard the received data silently

//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
//            ReferenceCountUtil.release(msg); // (2)
//        }
//        ctx.write("test : "+msg);
//        ctx.flush();
        ctx.write("sdf"+msg); // (1)
        ctx.flush(); // (2)
    }

    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        // close the connection when the exception is raised
        cause.printStackTrace();
        ctx.close();
    }

    public static void main(String[] args) {
//        Map<String, Charset> charsets = Charset.availableCharsets();
//        // 迭代遍历出编码方式
//        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue().name());
//        }

    }
}
