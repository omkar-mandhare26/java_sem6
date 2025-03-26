import javax.swing.*;
import java.awt.*;

public class s1a extends JFrame {
    private int x = 0, speed = 5;
    private String text = "Martin Garrix is GOAT";

    public s1a() {
        setSize(400, 100);
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.drawString(text, x, 50);
            }
        };
        add(panel);

        Timer timer = new Timer(50, _ -> {
            x += speed;
            if (x > 250 || x < 0) {
                speed = -speed;
            }
            panel.repaint();
        });
        timer.start();
    }

    public static void main(String[] args) {
        new s1a().setVisible(true);
    }
}
