package thinkinjavademo.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author Quan
 * @date 2017/9/20
 * @desciption
 */

/**
 * 假设存在不同类型的Robot,需要为每个类型的Robot创建一个空对象，去执行一些特殊的操作，即提供空对象所代表的Robot确切的类型信息
 * 这些信息是通过动态代理捕获的。
 */
class NullRobotProxyHandler implements InvocationHandler{

    public NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    private String nullName;
    private Robot proxied = new NRobot();
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }

    private class NRobot implements Null,Robot {
        public String name() {
            return nullName;
        }

        public String model() {
            return nullName;
        }

        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }
}

class NullRobot{
    public static Robot newNullRobot(Class<? extends Robot> type){
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),new Class[]{Null.class,Robot.class},new NullRobotProxyHandler(type));
    }
}
public class EmptyObject2_1 {
    public static void main(String[] args) {
        Robot[] bots = {new SnowRemovalRobot("snowBase"),NullRobot.newNullRobot(SnowRemovalRobot.class)};
        for(Robot bot : bots){
            Robot.Test.test(bot);
        }

    }

}
