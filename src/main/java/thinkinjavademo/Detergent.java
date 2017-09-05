package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class Clearnser{
    private  String s = "Clearnser";
    public void append(String a){s += a;}
    // dilute 稀得，淡的
    public void dilute(){append(" dilute()");}
    public void apply(){append(" apply()");}
    // 擦洗，洗刷
    public void scrub(){append(" scrub()");}
    public String toString(){return  s;}

    public static void main(String[] args) {
        Clearnser x = new Clearnser();
        x.dilute();x.apply();x.scrub();
        System.out.println(x);
    }

}

// 洗涤剂
public class Detergent extends Clearnser {
    // change a method
    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub();// 为什么要使用super,因为如果不用super，就不知道调用谁的方法，会引起循环调用
    }

    // Add methods to the interface //泡沫
    public void foam(){append(" foam()");}
    // Test the new class
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();x.apply();x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Clearnser.main(args);
    }
}
