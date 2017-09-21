package thinkinjavademo.chapter14;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Quan
 * @date 2017/9/20
 * @desciption
 */
interface Operation{
    String description();
    void command();
}

//interface Null{
//
//}
/**
 * 一个模型，一个名字和一个描述Robot行为的List<Operation>,Operation包含了一个描述和命令
 */
interface Robot{
    String name();
    String model();
    List<Operation> operations();

    // 嵌套类测试
    class Test{
        public static void test(Robot r){
            if(r instanceof Null){
                System.out.println("[Null Robot]");
            }
            System.out.println("Robot name: " + r.name());
            System.out.println("Robot model: " + r.model());

            for (Operation operation : r.operations()){
                System.out.println(operation.description());
                operation.command();
            }
        }

    }

}

class  SnowRemovalRobot implements Robot{

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    private String name;
    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series 11";
    }

    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    public String description() {
                        return name + " can shovel snow";
                    }

                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {

                    public String description() {
                        return name + " can chip ice";
                    }

                    public void command() {
                        System.out.println(name + " chipping ice");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " clear roof";
                    }

                    public void command() {
                        System.out.println(name + " clearing roof");
                    }
                }
        );
    }
}
public class EmptyObject2 {

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}
