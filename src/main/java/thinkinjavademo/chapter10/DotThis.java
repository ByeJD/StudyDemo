/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.chapter10;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: DotThis, v0.1

 * @date 2017年09月13日 19:56 Exp $
 */

// 知识点1：如果需要生成对外部类对象的引用，可以使用外部类的名字后面紧跟原点和this
public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }
    // 在拥有外部类对象之前不可能创建内部类对象
    //
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
}

// 知识点2：创建内部类的对象，使用new语法
class DotNew{
    public class Inner{

    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dn1 = dn.new Inner();
    }
}
