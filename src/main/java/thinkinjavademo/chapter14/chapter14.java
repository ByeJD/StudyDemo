package thinkinjavademo.chapter14;

/**
 * @author Quan
 * @date 2017/9/19
 * @desciption
 */

/**
 * 通过Class.forName("类名")，将类载入到JVM中
 */
public class chapter14 {
    public static void main(String[] args) {

        System.out.println("inside main");
        new Candy();
        System.out.println("after creating candy");

        try {
            Class.forName("Gum");
        }catch (ClassNotFoundException e){
            System.out.println("Could not find Gum");
        }

        System.out.println("after Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("after createing cookie");
    }
}

class Candy{
    static{
        System.out.println("candy loading");
    }
}

class Cookie{
    static{
        System.out.println("Cookie loading");
    }
}

class Gum{
    static{
        System.out.println("Gum loading");
    }
}

/*inside main
candy loading
after creating candy
Could not find Gum
after Class.forName("Gum")
Cookie loading
after createing cookie*/
