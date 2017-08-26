package com.netty.demo.nio;

import com.sun.corba.se.impl.encoding.CodeSetConversion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Quan
 * @date 2017/8/24
 * @desciption
 */
public class MultiplexerTimerServer  implements  Runnable{

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;


    /**
     * 初始化多路复用器
     * @param port
     */
    public MultiplexerTimerServer(int port){
        try {

            /** 创建reactor线程 */
            selector = selector.open();

            /** 打开ServerSocketChannel,用于监听客户端连接，它是所有客户端连接的父管道 */
            serverSocketChannel = ServerSocketChannel.open();

            /** 设置链接为非阻塞模式 */
            serverSocketChannel.configureBlocking(false);

            /** 绑定监听端口 */
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);

            /** 将ServerSocketChannel注册到Selector上,并监听SelectionKey.OP_ACCEPT操作位 */
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port: "+ port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = false;
    }


    public void run() {
        while (!stop){
            System.out.println("run");
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeySet.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                    }catch (Exception e){
                        if(key != null){
                            key.cancel();
                        }
                        if(key.channel() != null){
                            key.channel().close();
                        }
                    }

                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }

        // 多路复用器关闭后，所有注册在上面的Channel和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
        if(selector != null){
            try{
                selector.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){

            // 处理新接入的请求和消息
            if(key.isAcceptable()){
                // Accept the new connection
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                // Add the new connection to the selector
                sc.register(selector,SelectionKey.OP_READ);
            }

            if(key.isReadable()){
                //read the data
                SocketChannel sc = (SocketChannel)key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);

                if(readBytes > 0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY　TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
                    doWrite(sc,currentTime);
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else {
                    ; // 读到0字节忽略
                }
            }
        }
    }


    private void doWrite(SocketChannel channel, String response) throws IOException{

        if(response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
