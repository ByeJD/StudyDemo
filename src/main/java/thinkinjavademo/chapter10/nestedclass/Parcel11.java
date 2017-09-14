package thinkinjavademo.chapter10.nestedclass;


import thinkinjavademo.chapter10.InnerClassInMethod.Contents;
import thinkinjavademo.chapter10.InnerClassInMethod.Destination;

/**
 * 定义：如果不需要内部类对象与其外部类对象之间有联系，那么可以将内部类声明为static,这通常称为嵌套类
 * 内部类和嵌套类的区别：
 * 普通内部类对象隐式的保存了一个指向它的外围类的对象
 *
 * 要创建的嵌套类的对象，不需要其外围类的对象
 * 不能从嵌套类的对象中方位非静态的外围类对象
 */
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination{
        public ParcelDestination(String label) {
            this.label = label;
        }

        private String label;
        public String readLabel() {
            return label;
        }

        // nested class can contain other static class
        public static void f(){}
        static int x = 11;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String s){
        return  new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("sdf");
    }
}


/**
 * 接口的内部类:
 * 放到接口中的任何类都自动的是public和static的，因为类是static的，
 * 如果你想要创建某些公共代码，使得他们可以被某个几口的所有的不同实现共用，使用借口内部的嵌套类会很方便
 */
/*public interface ClassInterface{
    void howhd();
    class Test implements ClassInterface{

        public void howhd() {
            System.out.println("howhd!");
        }

        public static void main(String[] args) {
            new Test().howhd();
        }
    }
}*/


/*interface A{}
interface B{}

class X implements A, B{

}
class Y implements A{
    B makeB(){
        // 匿名内部类
        return new B() {
        };
    }
}
public class MultiInnerfacese{

    static void takesA(A a){

    }
    static void takesB(B a){

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();

        takesA(x);
        takesA(y);

        takesB(y.makeB());
        takesB(x);
    }
}*/

//class D{}
//abstract class E{}
//class Z extends D{
//    E makeE(){return new E() {
//    };}
//}
//public class MultiImplementation{
//    static void takesD(D d){}
//    static void takesE(E d){}
//
//    public static void main(String[] args) {
//        Z z = new Z();
//        takesD(z);
//        takesE(z.makeE());
//    }
//}
