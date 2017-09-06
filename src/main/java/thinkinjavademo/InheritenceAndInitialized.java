package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/6
 * @desciption
 */
class Insect{
    static {
        System.out.println("insect static ");
    }
    {
        System.out.println("insect code block");
    }
    private int i = 9;
    protected int j;

    public Insect() {
        System.out.println("i = " + i + ", j = "+j);
        j=39;
    }
    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
class Beetle extends Insect{
    static {
        System.out.println("Beetle static ");
    }
    {
        System.out.println("Beetle code block");
    }
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");
    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        //System.out.println(Beetle.x2);
    }
}

