package thinkinjavademo.chapter8;

/**
 * @author Quan
 * @date 2017/9/6
 * @desciption
 */
public class PrivateOverride {
    private void f() { System.out.println("private f()"); }
    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    public void f() { System.out.println("public f()"); }
}

