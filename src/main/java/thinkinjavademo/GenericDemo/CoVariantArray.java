package thinkinjavademo.GenericDemo;

import java.util.ArrayList;

/**
 * @author Quan
 * @date 2017/10/19
 * @desciption
 */

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}


/**
 * 向导出类型的数据赋予其基类型的数组
 * 泛型设计的目的之一是要使这种运行时期的错误在编译期就能发现，看看用泛型容器类来代替数组会发生什么
 */
public class CoVariantArray {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];

        fruit[0] =new Apple();
        fruit[1] = new Jonathan();

        // 运行时类型是Apple[],不是Fruit[]或者Orange[],编译器允许你将Fruit类型放入到这个数组中，在运行时数组机制知道他处理的是Apple[].
        // 这时数组会抛出异常
        try{
            // Compiler allows you to add Fruit
            fruit[0] = new Fruit();// ArrayStoreException
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            fruit[0] = new Orange();// ArrayStoreException
        }catch (Exception e){
            System.out.println(e);
        }

        // 不兼容的类型
        //ArrayList<Fruit> flist = new ArrayList<Apple>();

    }
}
