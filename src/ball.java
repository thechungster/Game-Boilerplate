import java.awt.*;
import java.util.Random;

/**
 * Created by Tim on 1/7/2018.
 */
public class Ball {
    public int x, y, r;
    public float xVel = 0;
    public float yVel = 0;

    private MathLogic ml = new MathLogic();
    private boolean firstLaunch = true;
    private int maxVel;

    public Ball(int x, int y, int radius, int maxVel) {
        this.x = x;
        this.y = y;
        this.r = radius;
        this.maxVel = maxVel;
    }

    private void launchBall() {
        xVel = ml.randomFloat(maxVel);
        yVel = ml.findVelocity(xVel, maxVel);
    }

    private void updatePosition() {
        x += xVel;
        y += yVel;
    }

    public void render (Graphics g) {
        if(firstLaunch) {
            launchBall();
            firstLaunch = false;
        }
        updatePosition();
        g.setColor(new Color(0xFFFFFF));
        g.fillOval(x, y, r, r);
    }
}
