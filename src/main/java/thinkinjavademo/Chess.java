package thinkinjavademo;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
class Game{
    public Game(int i) {
        System.out.println("Game Constructor");
    }
}

class BoardGame extends Game{

    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame Constructor"); // 必须放在super(i)的后面
    }
}


public class Chess extends BoardGame{
    public Chess() {
        super(11);
        System.out.println("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
