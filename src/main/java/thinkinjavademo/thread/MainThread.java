package thinkinjavademo.thread;

/**
 * @author Quan
 * @date 2017/11/1
 * @desciption
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
