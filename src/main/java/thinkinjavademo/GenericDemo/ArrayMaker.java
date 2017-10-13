package thinkinjavademo.GenericDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Quan
 * @date 2017/10/13
 * @desciption
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    /**
     * 即使kind被存储为Class<T>,擦除意味着它实际被存储为Class,没有任何参数，因此在创建数组时，Array.newInstance()实际上并未拥有kind所蕴含的类型信息，因此这
     * 不会产生具体的结果，所以必须转型，但是这会产生一条警告
     * @param size
     * @return
     */
    T[] create(int size){
        return (T[]) Array.newInstance(kind,size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringArrayMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
