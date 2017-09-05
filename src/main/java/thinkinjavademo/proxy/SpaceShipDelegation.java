package thinkinjavademo.proxy;

/**
 * @author Quan
 * @date 2017/9/5
 * @desciption
 */
public class SpaceShipDelegation {
    private SpaceShipControls controls = new SpaceShipControls();
    private String name;

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    void up(int velocity){
        controls.up(velocity);
    }
    void down(int velocity){
        controls.down(velocity);
    }
    void left(int velocity){
        controls.left(velocity);
    }
    void right(int velocity){
        controls.right(velocity);
    }
    void forward(int velocity){
        controls.forward(velocity);
    }
    void back(int velocity){
        controls.back(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NEA Protector");
        protector.forward(100);
    }

}
