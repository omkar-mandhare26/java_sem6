import javax.swing.*;
import java.util.concurrent.*;

public class BlinkingImage extends JFrame {
    public BlinkingImage() {
        JLabel label = new JLabel(new ImageIcon("./wallpaper.jpg"));
        add(label);

        ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
        ex.scheduleAtFixedRate(() -> label.setVisible(!label.isVisible()), 0, 1, TimeUnit.SECONDS);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlinkingImage::new);
    }
}
