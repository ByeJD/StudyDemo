package thinkinjavademo.chapter10.InnerClassInMethod;






public class Parcel5 {

    // 演示在方法内部创建类，PDestination是方法的的一部分，不是Parcel5的一部分，在方法外部不能访问PDestination
    // 仍然可以在其他的类中创建PDestinatio类，不会引起冲突,，注意这里的class 不能有修饰符
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            public String readLabel() {
                return null;
            }

            private PDestination(String label) {
                this.label = label;
            }
        }
        return new PDestination(s);
    }
}
