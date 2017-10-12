/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.GenericDemo.demo1;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Stack1, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2017年10月13日 0:28 Exp $
 */

public class Stack1<E> {
    private Object[] elements;
    private int size;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack1() {
        // 不能创建不可具体化(non-reifiable)的类型的数组
        // elements = new E[DEFAULT_INITIAL_CAPACITY];
        /**
         * 解决这个问题两种方法：
         * 1. 创建一个Object类型的数组，并将它转换为泛型数组类型,但是编译器会给出警告
         * 这种用法是合法的，但(整体上面不是类型安全的)
         * 编译器不能证明程序是类型安全的，但是我们自己知道，要确保未受检的转换不会危及到程序的安全性
         *
         * 一旦我们确保了未受检的转换时安全的，就要在尽可能小的范围内禁止警告，只要在构造器上面加入注解
         * @SuppressWarnings("unchecked")
         */
        elements =  new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }

    public E pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked") E result = (E)elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
