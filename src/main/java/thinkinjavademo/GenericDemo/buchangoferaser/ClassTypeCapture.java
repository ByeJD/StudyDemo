package thinkinjavademo.GenericDemo.buchangoferaser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Quan
 * @date 2017/10/18
 * @desciption
 */
class Building{}
class House extends Building{}

public class ClassTypeCapture<T>{
    Map<String,Class<?>> classMap = new HashMap<String, Class<?>>();

    public void addType(String typename,Class<?> kind){
        classMap.put(typename,kind);
    }

    public T createNew(String typeName){
        Class<?> kind = classMap.get(typeName);
        T t = null;
        try {
            t = (T) kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }


    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    Class<T> kind;

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {


        ClassTypeCapture<Building> ctt1  =new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2  =new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
//        true
//        true
//        false
//        true

    }
}