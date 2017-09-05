package thinkinjavademo;

import java.util.Random;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class Value{
    int i; // package access

    public Value(int i) {
        this.i = i;
    }
}
public class FinalDemo {
    private static Random rand = new Random(47);
    private String id;

    public FinalDemo(String id) {
        this.id = id;
    }

    // Can be compile-time constants
    private final int valueoOne = 9;
    private static final int VALUE_TWO = 99;

    // Typical public constant
    public static final int VALUE_THREE = 39;

    // Can not be compile-time constants:
    private  final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    // Arrays:
    private final int[] a = {1,2,3,4};

    @Override
    public String toString() {
        return "FinalDemo{" +
                "id='" + id + '\'' +
                ", i4=" + i4 +", INT_5= "+INT_5+
                '}';
    }

    public static void main(String[] args) {
        FinalDemo finalDemo = new FinalDemo("finalDemo");
        //! finalDemo.valueoOne++; // ERROR:cannot change value
        finalDemo.v2.i++;          // Object isn't constant

        finalDemo.v1 = new Value(12);  // Ok -- not final
        //! finalDemo.v2 = new Value(11);  // ERROR: v2 is final

        for (int i = 0; i < finalDemo.a.length; i++) {
            finalDemo.a[i]++;
        }

        //! fd1.VAL_3 = new Value(1);  // change reference
        //! fd1.a = new int[3];

        System.out.println(finalDemo);
        System.out.println("createing new finademo");
        FinalDemo finalDemo1 = new FinalDemo("df2");
        System.out.println(finalDemo);
        System.out.println(finalDemo1);
    }
}
