package thinkinjavademo.GenericDemo.buchangoferaser;

/**
 * @author Quan
 * @date 2017/10/18
 * @desciption
 */
public class Erased<T> {
    private final int SIZE = 100;
    public static void f(Object arg){
//        if(arg instanceof  T){}   // error
//        T var = new T();           // error
//        T[] array = new T[SIZE];   // error
    }
}


