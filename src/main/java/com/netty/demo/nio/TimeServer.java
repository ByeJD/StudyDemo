package com.netty.demo.nio;

import java.io.IOException;

/**
 * @author Quan
 * @date 2017/8/20
 * @desciption
 */
public class TimeServer {

    public static void main(String[] args)  throws IOException{
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }

        }

        MultiplexerTimerServer timerServer = new MultiplexerTimerServer();

        new Thread(timerServer,"NIO-MultiplexerTimerServer-001").start();
    }
}
