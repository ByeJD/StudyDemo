package thinkinjavademo.chapter10.InnerClassInMethod;

/**
 * 10.5 example
 * @author Quan
 * @date 2017/9/13
 * @desciption 如何在任意作用域中嵌入一个内部类
 */
public class Parcel6 {
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String id) {
                    this.id = id;
                }
                String getSlip(){return id;}
            }

            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // cannot use it here! out of scope;
    }

    public void track(){internalTracking(true);}

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
