import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApplicationFrame extends JPanel implements KeyListener, MouseListener, Runnable {

    private PlayArea pong;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;
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
        pong.update();
    }

    private void render(Graphics g) {
        // rendering goes here
        // this is run every tick
        pong.render(g);
    }

    private void initialize() {
        // this method is called before the game loop begins so that variables can be initialized
        pong = new PlayArea();
        pong.intialize();
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
        if(e.getKeyCode() == 38 || e.getKeyCode() == 40){// up key
            pong.keyPressed(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // this method is called when a key is released
        if(e.getKeyCode() == 38 || e.getKeyCode() == 40){// up key
            pong.keyReleased(e.getKeyCode());
        }
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
