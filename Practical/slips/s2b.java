import java.applet.Applet;
import java.awt.*;

public class s2b extends Applet implements Runnable {
    private int offset = 0;
    private Thread t;

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            offset = (offset + 5) % 20;
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(100, 100 + offset, 100, 30);
        g.setColor(Color.WHITE);
        g.fillRect(100, 130 + offset, 100, 30);
        g.setColor(Color.GREEN);
        g.fillRect(100, 160 + offset, 100, 30);
        g.setColor(Color.BLUE);
        g.drawOval(140, 130 + offset, 20, 20);
    }
}
