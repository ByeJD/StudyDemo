package designpatternstudy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// Component（抽象构件）
abstract class MyInputStream{
    public abstract void read();
}


// ConcreteComponent（具体构件),装饰器可以给它增加额外的职责（方法）
class MyFileInputStream extends  MyInputStream{

    @Override
    public void read() {

    }
}

//Decorator（抽象装饰类):规范化 装饰品，可以理解为这个装饰品是否合格
// 需要注意的是在Decorator中并未真正实现operation()方法，而只是调用原有component对象的operation()方法，它没有真正实施装饰，而是提供一个统一的接口，将具体装饰过程交给子类完成。
class MyFilterInputStream extends MyInputStream{

    //注入一个抽象构件类型的对象
    public MyFilterInputStream(MyInputStream myInputStream) {
        this.myInputStream = myInputStream;
    }

    private MyInputStream myInputStream;  //维持一个对抽象构件对象的引用
    @Override
    public void read() {
        myInputStream.read();
    }
}

// ConcreteDecorator（具体装饰类）
class MyBufferedInputStream extends  MyFilterInputStream{

    public MyBufferedInputStream(MyInputStream myInputStream) {
        super(myInputStream);
    }

    public void read()
    {
        super.read();
        addedBehavior();
    }

    public void addedBehavior(){

    }


    public static void main(String[] args) throws FileNotFoundException {
//        File file = new File ("hello.txt");
//        FileInputStream in=new FileInputStream(file);
//        BufferedInputStream inBuffered=new BufferedInputStream (in);
        MyBufferedInputStream myBufferedInputStream = new MyBufferedInputStream(new MyFileInputStream());
    }
}

