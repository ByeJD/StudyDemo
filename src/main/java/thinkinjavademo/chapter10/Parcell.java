/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.chapter10;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: Parcell, v0.1

 * @date 2017年09月13日 19:00 Exp $
 */

public class Parcell {
    class Contents{
        private  int i = 11;
        public int value(){return i;}
    }
    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel(){return label;}
    }

    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("123");

        // 调用内部类的方式
        Parcell.Destination destination = new Parcell().new Destination("123");

        //内部类拥有访问外部类的所有成员
    }
}
