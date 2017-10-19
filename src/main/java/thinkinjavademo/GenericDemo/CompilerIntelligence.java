package thinkinjavademo.GenericDemo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Quan
 * @date 2017/10/19
 * @desciption https://segmentfault.com/a/1190000005337789
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist =
                Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is ‘Object’
        flist.indexOf(new Apple()); // Argument is ‘Object’

        //flist.add(new Apple());   无法编译
    }
}