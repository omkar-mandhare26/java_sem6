package s1b;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class client extends JFrame {
    private JTextField messageField;
    private JTextArea chatArea;
    private PrintWriter out;
    private Socket socket;

    public client() {
        setTitle("Chat Client");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), "Center");

        messageField = new JTextField();
        JButton sendButton = new JButton("Send");
        JPanel panel = new JPanel();
        panel.add(messageField);
        panel.add(sendButton);
        add(panel, "South");

        sendButton.addActionListener(_ -> sendMessage());
        messageField.addActionListener(_ -> sendMessage());

        connectToServer();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 4050);
            chatArea.append("Connected to server\n");

            out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        chatArea.append("Server: " + message + "\n");
                    }
                } catch (IOException e) {
                    chatArea.append("Disconnected from server\n");
                }
            }).start();

        } catch (IOException e) {
            chatArea.append("Error: " + e.getMessage() + "\n");
        }
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            out.println(message);
            chatArea.append("You: " + message + "\n");
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new client().setVisible(true));
    }
}
