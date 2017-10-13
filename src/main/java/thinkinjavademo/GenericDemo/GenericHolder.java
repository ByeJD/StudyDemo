package thinkinjavademo.GenericDemo;

/**
 * @author Quan
 * @date 2017/10/13
 * @desciption
 */
public class GenericHolder<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }


    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<String>();
        holder.setObj("item");

        // 转型消失，setObj方法传入的值编译期，接受检查
        String s = holder.getObj();
    }
}
