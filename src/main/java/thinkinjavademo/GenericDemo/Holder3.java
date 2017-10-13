/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.GenericDemo;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Holder3, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2017年10月13日 1:05 Exp $
 */

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }
    public T getA() {
        return a;
    }
    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<AutoMobile> autoMobileHolder3 = new Holder3<AutoMobile>(new AutoMobile());
        AutoMobile autoMobile = autoMobileHolder3.getA(); // 不用强制转换，编译器已经为我们完成。
    }
}
