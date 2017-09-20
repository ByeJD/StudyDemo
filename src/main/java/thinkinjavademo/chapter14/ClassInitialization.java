package thinkinjavademo.chapter14;

import java.util.Random;

/**
 * @author Quan
 * @date 2017/9/19
 * @desciption
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}
class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand=new Random(47);
    public static void main(String[] args){

        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        System.out.println(Initable.staticFinal);  //  无初始化

        System.out.println(Initable.staticFinal2);//开始初始化，非常数静态域

        System.out.println(Initable2.staticNonFinal);  // 无初始化

        try {
            Class initable3 = Class.forName("example.Initable3"); //立即初始化
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find Initable3");
            System.exit(1);
        }
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);



    }
}
