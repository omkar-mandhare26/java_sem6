package s1b;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class server extends JFrame {
    private JTextArea messageArea;
    private JTextField messageField;
    private PrintWriter out;
    private Socket client;

    public server() {
        setTitle("Chat Server");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        add(new JScrollPane(messageArea), "Center");

        messageField = new JTextField();
        JButton sendButton = new JButton("Send");
        JPanel panel = new JPanel();
        panel.add(messageField);
        panel.add(sendButton);
        add(panel, "South");

        sendButton.addActionListener(_ -> sendMessage());
        messageField.addActionListener(_ -> sendMessage());

        new Thread(this::startServer).start();
    }

    private void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(4050)) {
            messageArea.append("Server started on port 4050\n");
            client = serverSocket.accept();
            messageArea.append("Client connected\n");

            out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String message;
            while ((message = in.readLine()) != null) {
                messageArea.append("Client: " + message + "\n");
            }
        } catch (IOException e) {
            messageArea.append("Error: " + e.getMessage() + "\n");
        }
    }

    private void sendMessage() {
        if (client != null && !client.isClosed()) {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                out.println(message);
                messageArea.append("Server: " + message + "\n");
                messageField.setText("");
            }
        } else {
            messageArea.append("No client connected\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new server().setVisible(true));
    }
}
