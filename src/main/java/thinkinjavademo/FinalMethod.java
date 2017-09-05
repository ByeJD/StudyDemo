package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/6
 * @desciption
 */
class T{
    public final void method(){
        System.out.println("T public method");
    }
    private final void privateMethod(){
        System.out.println("T private method");
    }
}
public class FinalMethod extends T {

    // 相当于添加了一个新的方法
    private final void privateMethod(){
        System.out.println("FinalMethod private method");
    }

    //public final void method(){}  // ! 不能被继承
    public static void main(String[] args) {
        FinalMethod finalMethod = new FinalMethod();
        finalMethod.method();
    }
}
