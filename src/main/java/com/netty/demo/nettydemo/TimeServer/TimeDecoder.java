package com.netty.demo.nettydemo.TimeServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * @author Quan
 * @date 2017/9/4
 * @desciption
 */
public class TimeDecoder extends ReplayingDecoder<Void> {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 4) {
            return;
        }

        out.add(new UnixTime(in.readUnsignedInt()));
    }

}
