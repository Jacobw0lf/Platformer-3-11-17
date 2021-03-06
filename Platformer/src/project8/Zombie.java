package project8;

public class Zombie extends Sprite {

    private final int INITIAL_X = 400;

    public Zombie(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("Images/Zombie250.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }
}