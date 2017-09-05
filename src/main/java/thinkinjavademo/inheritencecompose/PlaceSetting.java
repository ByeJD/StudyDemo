package thinkinjavademo.inheritencecompose;

import sun.java2d.loops.CustomComponent;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class Plate{
    public Plate(int i) {
        System.out.println("plate  constructor");
    }
}

class DinnerPlate extends Plate{
    public DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate constructor");
    }
}

// 用具
class Utensil{
    public Utensil(int i) {
        System.out.println("Utensil constructor");
    }
}

class Spoon extends Utensil{
    public Spoon(int i) {
        super(i);
        System.out.println("Spoon constructor");
    }
}

class Knife extends Utensil{
    public Knife(int i) {
        super(i);
        System.out.println("Knife constructor");
    }
}

class Fork extends Utensil{
    public Fork(int i) {
        super(i);
        System.out.println("fork constructor");
    }
}

class Custom {
    public Custom(int i) {
        System.out.println("Custom constructor");
    }
}

public class PlaceSetting extends Custom {
    private Spoon  sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;


    public PlaceSetting(int i) {
        super(i+1);
        sp = new Spoon(i+2);
        frk = new Fork(i+3);
        kn = new Knife(i+4);
        pl = new DinnerPlate(i+5);
        System.out.println("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting placeSetting = new PlaceSetting(9);
    }
}
