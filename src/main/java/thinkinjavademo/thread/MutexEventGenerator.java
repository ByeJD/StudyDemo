package thinkinjavademo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Quan
 * @date 2017/11/2
 * @desciption
 */
public class MutexEventGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;   // 递增操作不是线程安全的
            Thread.yield();       // 增加出现失败的几率
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }
}
