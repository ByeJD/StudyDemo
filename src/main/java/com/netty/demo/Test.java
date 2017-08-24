package com.netty.demo;

/**
 * @author Quan
 * @date 2017/8/20
 * @desciption
 */
public class Test extends Thread {
    public static int i = 1;
    public static void main(String[] args) {
        new Test().start();
    }
    public void run(){
        while (i < 10){
            System.out.println(i++);
        }
    }

}
