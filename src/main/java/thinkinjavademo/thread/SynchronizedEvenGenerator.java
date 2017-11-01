package thinkinjavademo.thread;

/**
 * @author Quan
 * @date 2017/11/2
 * @desciption
 */
public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
      @Override
    public synchronized int next() {
        ++currentEvenValue;   // 递增操作不是线程安全的
        Thread.yield();       // 增加出现失败的几率
        ++currentEvenValue;
        return currentEvenValue;
    }
}
