package thinkinjavademo.GenericDemo.buchangoferaser;

/**
 * @author Quan
 * @date 2017/10/19
 * @desciption
 */
class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x = kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Employee{}

/**
 * 可以编译，但是会因为ClassAsFactory<Integer>而失败，因为Integer没有默认的构造函数，该错误不是在编译期产生的，这种方式不建议使用
 *
 */
public class CreateTypeInstanceDemo1 {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);

        System.out.println("ClassAsFactory<Employee> succeeded");

        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }


        /**
         * ClassAsFactory<Employee> succeeded
           ClassAsFactory<Integer> failed
         */
    }
}
