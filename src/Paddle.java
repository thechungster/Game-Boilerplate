import java.awt.*;


public class Paddle {

    public int x, y;
    private int PADDLE_WIDTH = 20;
    private int PADDLE_HEIGHT = 80;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private int WINDOW_HEIGHT;
    private final int PADDLE_SPEED = 15;

    public Paddle(int x, int y, int width, int height, int wh) {
        this.x = x;
        this.y = y;
        PADDLE_WIDTH = width;
        PADDLE_HEIGHT = height;
        WINDOW_HEIGHT = wh;
    }

    public void setUpPressed(boolean b) {
        upPressed = b;
    }

    public void setDownPressed(boolean b) {
        downPressed = b;
    }

    public void update() {
        if(downPressed) {
            y += PADDLE_SPEED;
            y = y > WINDOW_HEIGHT - PADDLE_HEIGHT ? WINDOW_HEIGHT - PADDLE_HEIGHT : y;
        } else if (upPressed) {
            y -= PADDLE_SPEED;
            y = y < 0 ? 0 : y;
        }
    }

    public void render(Graphics g) {
        g.setColor( new Color(0x0));
        g.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

}
