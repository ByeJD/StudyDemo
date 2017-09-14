/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Sequence, v0.1

 * @date 2017年09月13日 19:10 Exp $
 */
interface  Selector{
    boolean end();
    Object current();
    void next();
}
public class Sequence {

    Map<String,String> m = new HashMap<String, String>();
    private Object[] items;
    private int next = 0;
    public Sequence(int size){
        items = new Object[size];
    }
    public void add(Object x){
        if(next < items.length){
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector{

        private int i = 0;
        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if(i < items.length){
                i++;
            }
        }
    }

    private class ReverseSelector implements Selector{

        private int i = items.length;
        public boolean end() {
            return 0 == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if(i > 0){
                i--;
            }
        }
    }


    public Selector selector(){
        return new SequenceSelector();
    }

    public Selector reverseSelector(){
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i = 0;i < 10;i++){
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();

        while(!selector.end()){
            System.out.println(selector.current()+" ");
            selector.next();
        }
    }
}
