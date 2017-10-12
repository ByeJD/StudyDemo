/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.GenericDemo;

import org.apache.zookeeper.server.ObserverBean;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Stack, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2017年10月12日 22:35 Exp $
 */

public class Stack {
    private Object[] elements;
    private int size;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements,2 * size + 1);
        }
    }

    public Object pop(){
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
