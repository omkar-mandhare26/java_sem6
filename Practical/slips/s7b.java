import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class s7b implements Runnable {
    private JTextField textField;

    public s7b(JTextField textField) {
        this.textField = textField;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            textField.setText(String.valueOf(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Display");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setHorizontalAlignment(JTextField.CENTER);

        JButton button = new JButton("Start");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new s7b(textField));
                thread.start();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
