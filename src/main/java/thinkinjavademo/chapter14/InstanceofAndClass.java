package thinkinjavademo.chapter14;

/**
 * @author Quan
 * @date 2017/9/20
 * @desciption
 */

/**
 * instanceof 和 class 的等价性
 * instanceof:止咳将其与命名类型比较，不能跟class比较， x instanceof y 表示x是不是y的类型的实例？如果是，true,
 *
 * 演示的目的：iinstanceof和isInstance生成的结果完全相同，equals()和==也一样，
 * instanceof保持了类型的概念，它是指你是这个类吗，或者你是这个类的派生类吗
 * 如果是用==表示你是不是这个类，没有考虑继承，它或者是这个类的确切的类，或者不是
 * */
class Base{}
class Derived extends Base{}
public class InstanceofAndClass {
    static void test(Object x){
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));

        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}

/*

Testing x of type class thinkinjavademo.chapter14.Base
x instanceof Base true
x instanceof Derived false   x是 Derived的类型吗，另一种问法： 父类是子类的类型吗？不是
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class) true
x.getClass().equals(Derived.class) false
Testing x of type class thinkinjavademo.chapter14.Derived
x instanceof Base true  // 子类是父类的一种类型，Base类型的实例是x吗
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class) false
x.getClass().equals(Derived.class) true
*/
