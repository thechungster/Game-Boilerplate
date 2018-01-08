import java.awt.*;

public class PlayArea {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
    public static final int BALL_RADIUS = 10;
    public static final int BALL_VELOCITY = 10;
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 80;
    private Ball ball;
    private Paddle p1;
    private Paddle p2;

    public PlayArea() {}


    private void checkCollisions() {
        if(ball.x >= WIDTH - BALL_RADIUS && ball.xVel > 0) { //if ball is going right and hits right wall
            ball.xVel *= -1;
        } else if(ball.x <= 0 && ball.xVel < 0) { // ball is going left and hits left wall
            ball.xVel *= -1;
        }
        if(ball.y >= HEIGHT - BALL_RADIUS && ball.yVel > 0) { // ball is going down and hits bottom wall
            ball.yVel *= -1;
        } else if(ball.y < BALL_RADIUS && ball.yVel < 0) { // going up and hits top wall
            ball.yVel *= -1;
        }
    }

    public void update() {
        checkCollisions();
        p1.update();
        p2.update();
    }

    public void render (Graphics g) {
        g.setColor(new Color(0x2b2b2b));
        g.fillRect(0, 0, 1200, 800);

        ball.render(g);
        p1.render(g);
        p2.render(g);
    }

    public void keyPressed(int keyCode) {
        System.out.println("called");
        if (keyCode == 38){// up key
            p1.setUpPressed(true);
        } else if(keyCode == 40) {
            p1.setDownPressed(true);
        }
    }

    public void keyReleased(int keyCode) {
        if (keyCode == 38){// up key
            p1.setUpPressed(false);
        } else if(keyCode == 40) {
            p1.setDownPressed(false);
        }
    }

    public void intialize() {
        ball = new Ball(WIDTH / 2, HEIGHT / 2, BALL_RADIUS, BALL_VELOCITY);
        p1 = new Paddle(WIDTH - PADDLE_WIDTH, HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, HEIGHT);
        p2 = new Paddle(0, HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, HEIGHT);
    }
}
