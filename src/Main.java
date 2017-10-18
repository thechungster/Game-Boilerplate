import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // create the canvas that you will draw to
        ApplicationFrame applicationFrame = new ApplicationFrame();

        // create the jframe window that contains the canvas
        JFrame frame = new JFrame("Basic Application");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(applicationFrame);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(applicationFrame);
        frame.addMouseListener(applicationFrame);
        frame.setSize(new Dimension(ApplicationFrame.WIDTH, ApplicationFrame.HEIGHT));
        frame.setPreferredSize(new Dimension(ApplicationFrame.WIDTH, ApplicationFrame.HEIGHT));
        frame.setVisible(true);
    }
}
