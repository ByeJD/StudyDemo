package thinkinjavademo.GenericDemo;

import java.awt.*;

/**
 * @author Quan
 * @date 2017/10/19
 * @desciption
 */
interface HasColor{java.awt.Color getColor();}

class Colored<T extends HasColor>{
    T item;
    Colored(T item){this.item = item;}
    T getItem(){return getItem();}
    java.awt.Color color(){return item.getColor();}
}
class Dimension{public int x,y,z;}

// Multiple bouds:必须类在前，接口在后
class ColredDimension<T extends Dimension & HasColor>{
    T item;

    public ColredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){return item.getColor();}

    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}

interface Weight{int weight();}

class Solid<T extends Dimension & HasColor & Weight>{
    T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){return item.getColor();}

    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}

    int weight(){return item.weight();}
}

class Bounded extends Dimension implements HasColor,Weight{

    public Color getColor() {
        return null;
    }

    public int weight() {
        return 0;
    }
}

/**
 * 目的：泛型边界的基本使用方法
 * 1.如果泛型T继承了F,那么在泛型中调用F的方法，
 * 2.泛型是可以多次限定上界，泛型继承的顺序：最多一个类，n个接口，接口之间用&
 *
 */
public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.getX();
    }
}
