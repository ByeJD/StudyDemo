package thinkinjavademo.chapter8;

import java.util.Random;

/**
 * @author Quan
 * @date 2017/9/6
 * @desciption
 */
//class Shape {
//    public void draw() {}
//    public void erase() {}
//
//}
//
//class Circle extends Shape {
//    public void draw() { System.out.println("Circle.draw()"); }
//    public void erase() { System.out.println("Circle.erase()"); }
//}
//
//class Square extends Shape {
//    public void draw() { System.out.println("Square.draw()"); }
//    public void erase() { System.out.println("Square.erase()"); }
//}
//
//class Triangle extends Shape {
//    public void draw() { System.out.println("Triangle.draw()"); }
//    public void erase() { System.out.println("Triangle.erase()"); }
//}
//
//class RandomShapeGenerator {
//    private Random rand = new Random(47);
//    public Shape next() {
//        switch(rand.nextInt(3)) {
//            default:
//            case 0: return new Circle();
//            case 1: return new Square();
//            case 2: return new Triangle();
//        }
//    }
//}
//
//public class Shapes {
//    private static RandomShapeGenerator gen =
//            new RandomShapeGenerator();
//    public static void main(String[] args) {
//        Shape[] s = new Shape[9];
//        // Fill up the array with shapes:
//        for(int i = 0; i < s.length; i++)
//            s[i] = gen.next();
//        // Make polymorphic method calls:
//        for(Shape shp : s)
//            shp.draw();
//    }
//}
/* Output:
Triangle.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Square.draw()
Triangle.draw()
Circle.draw()
随机选择几何形状是为了让大家理解：在编译时，编译器不需要获得任何特殊信息就能进行正确的调用。对draw()方法的所有调用都是通过动态绑定进行的
*/
class Instrument {
    void play(Note n) { System.out.println("Instrument.play() " + n); }
    String what() { return "Instrument"; }
    void adjust() { System.out.println("Adjusting Instrument"); }
}

class Wind extends Instrument {
    void play(Note n) { System.out.println("Wind.play() " + n); }
    String what() { return "Wind"; }
    void adjust() { System.out.println("Adjusting Wind"); }
}

class Percussion extends Instrument {
    void play(Note n) { System.out.println("Percussion.play() " + n); }
    String what() { return "Percussion"; }
    void adjust() { System.out.println("Adjusting Percussion"); }
}

class Stringed extends Instrument {
    void play(Note n) { System.out.println("Stringed.play() " + n); }
    String what() { return "Stringed"; }
    void adjust() { System.out.println("Adjusting Stringed"); }
}

class Brass extends Wind {
    void play(Note n) { System.out.println("Brass.play() " + n); }
    void adjust() { System.out.println("Adjusting Brass"); }
}

class Woodwind extends Wind {
    void play(Note n) { System.out.println("Woodwind.play() " + n); }
    String what() { return "Woodwind"; }
}

public class Music3 {
    public static void tune(Instrument i) {

        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {

        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}


