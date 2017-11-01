package thinkinjavademo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Quan
 * @date 2017/11/2
 * @desciption
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;


    /**
     * 如果失败的概率比较低，那么即使存在缺陷，他们也可能看起来是正确的。
     * @return
     */
    @Override
    public int next() {
        ++currentEvenValue;   // 递增操作不是线程安全的
        Thread.yield();       // 增加出现失败的几率
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
