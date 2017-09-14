package thinkinjavademo.chapter10;

import java.util.LinkedList;

/**
 * @author Quan
 * @date 2017/9/13
 * @desciption:
 */
interface  Contents{
    int value();
}

interface Destination {
    String readLabel();
}

public class Parcel7 {
    // contents()方法表示将返回值的生成和表示这个返回值的类的定义结合在一起，另外这个类是没有名字的
    // 这中奇怪的语法表示创建一个继承自Contents的匿名类的对象，通过new表达式返回的引用自动向上转型为对Contents的引用
    public Contents contents(){
        return new Contents(){
            private int i = 11;
            public int value(){return i;}
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }

    LinkedList<Integer> linkedList = new LinkedList<Integer>();
}


/*public class Parcel7b {
    class MyContents implements Contents{
        private int i = 11;
        public int value(){return i;}
    }
    public Contents contents(){
        return new MyContents();
    }

    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
    }
}*/


/**
 * 如果你的基类需要一个有参数的构造函数怎么办？
 * 虽然这里的Wrapping只是一个具有具体实现的普通类，但是它还是被其导出类当作公共接口使用
 */
/*class Wrapping{
    private int i = 11;

    public Wrapping(int i) {
        this.i = i;
    }

    public int value() {
        return i;
    }
}
public class Parcel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            //private int i = 11;
            public int value(){return super.value() * 47 ;}
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping wrapping = p.wrapping(10);
    }
}*/


/**
 * 在匿名类中定义字段时，还能够对其执行初始化操作
 * 如果定义一个匿名内部类，并且希望它使用一个在其外部定义的对象，那么编译器会要求该参数引用是final的
 */

/*public class Parcel9 {
    public Destination destination(final String dest){
        return new Destination(){
            public String readLabel() {
                return null;
            }
            private String lable = dest;

        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination c = p.destination("123");
    }
}*/




