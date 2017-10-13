package thinkinjavademo.GenericDemo;

import java.util.Observable;

/**
 * @author Quan
 * @date 2017/10/13
 * @desciption
 */
public class SimpleHolder {
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    private Object object;

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObject("Item");
        String s = (String)holder.getObject();
    }

}
