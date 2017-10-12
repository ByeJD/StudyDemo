/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.GenericDemo;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Holder2, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2017年10月13日 0:59 Exp $
 */

public class Holder2 {
    private Object a;

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public Holder2(Object a) {

        this.a = a;
    }

    public static void main(String[] args) {
        Holder2 holder2 = new Holder2(new AutoMobile());
        AutoMobile a = (AutoMobile)holder2.getA();

        holder2.setA("Not a auto mobile");
        String s = (String)holder2.getA();

        holder2.setA(1);
        Integer x = (Integer)holder2.getA();

        String strTest = (String)holder2.getA(); // 编译时不会报错，但是运行时会报错


    }
}
