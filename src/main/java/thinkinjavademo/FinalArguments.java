package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class GIZmo{
    public void spin(){}
}
public class FinalArguments {

    void with(final GIZmo g){
        //! g = new GIZmo(); // illegal --g is final
    }

    void without(GIZmo g){
        g = new GIZmo(); // ok -- g is not final
        g.spin();
    }

    // void f(final int i){i++;}  // can't change
    // you can only read from a final primitive

    int g(final int i){return i+1;}

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.with(null);
        bf.without(null);
    }
}
