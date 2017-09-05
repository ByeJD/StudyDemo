package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class Poppet{
    private int i;

    public Poppet(int i) {
        this.i = i;
    }
}
public class BlankFinal {
    private final int i = 0; // initialized final
    private final int j;     // blank final
    private final Poppet p;  // blank final reference

    // blank finals MUST be initialized in the constructor
    public BlankFinal() {
        this.j = 1;
        this.p = new Poppet(1);
    }

    public BlankFinal(int x) {
        this.j = x;
        this.p = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(1);
    }
}
