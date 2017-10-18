import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplicationFrame extends JPanel implements KeyListener, MouseListener, Runnable {
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    private Point center;
    private double time;

    public ApplicationFrame() {
        // enable double buffering so there's no flickering
        setDoubleBuffered(true);

        initialize();

        // call the 'run' method in a new thread
        new Thread(this).start();
    }

    private void update() {
        // logic goes here
        // this is run every tick

        time += 0.01;
    }

    private void render(Graphics g) {
        // rendering goes here
        // this is run every tick

        g.setColor(new Color(0x2b2b2b));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        int x = (int) Math.round(center.x + Math.cos(time) * WIDTH / 3.0);
        int y = (int) Math.round(center.y + Math.sin(time) * HEIGHT / 3.0);

        g.setColor(new Color(0xffffff));
        g.fillRect(x - 2, y - 2, 4, 4);
    }

    private void initialize() {
        // this method is called before the game loop begins so that variables can be initialized

        center = new Point(WIDTH / 2, HEIGHT / 2);
        time = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // this method is called when a key is pressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // this method is called when a key is released
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // this method is called when the mouse is pressed
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // this method is called when the mouse is released
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        // new thread loop that runs the game logic

        while (true) {
            update();
            repaint();

            try {
                Thread.sleep(17L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
