/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2017
 */
package thinkinjavademo.GenericDemo;

import scala.Int;

import java.util.ArrayList;

/**
 * 用途描述
 *
 * @author 刘全权
 * @version $Id: ErasedTypeEquivalence, v0.1
 * @company 杭州信牛网络科技有限公司
 * @date 2017年10月13日 1:27 Exp $
 */

/**
 * 类型擦除
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2); // true
    }

    // 泛型重载：不能重载，因为ArrayList<String>和ArrayList<Integer>是相同类型的
//    public void f1(ArrayList<Integer> integerArrayList){}
//    public void f1(ArrayList<String> integerArrayList){}
}
