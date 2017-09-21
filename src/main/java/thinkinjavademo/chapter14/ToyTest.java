package thinkinjavademo.chapter14;

/**
 * @author Quan
 * @date 2017/9/19
 * @desciption
 */

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
//    public Toy() {
//    }
    public Toy(int i) {
    }
}
class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    public FancyToy(int i) {
        super(i);
    }
}
public class ToyTest {
    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName()+
        "  is interface? [" + cc.isInterface() + "]");

        System.out.println("Simple name : " + cc.getSimpleName());

        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c  = Class.forName("thinkinjavademo.chapter14.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("can not find fancy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces()){
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;

        try {
            // 如果将Toy的默认构造器注释掉，不能实例化，抛出异常
            obj = up.newInstance();
        }catch (InstantiationException e){
            System.out.println("can not instantiate");
            System.exit(1);
        }catch (IllegalAccessException e) {
            System.out.println("can not access");
            System.exit(1);
        }

        printInfo(obj.getClass());






















    }



}
