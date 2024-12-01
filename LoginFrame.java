import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame {
    private String username = "james3302";
    private String password = "pass";

    public static void main(String[] args) {
        LoginFrame login = new LoginFrame();
        login.createLoginWindow();
    }

    public void createLoginWindow() {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JTextField txtUsername = new JTextField(15);
        JPasswordField txtPassword = new JPasswordField(15);

        JButton btnLogin = new JButton("Login");
        JButton btnCancel = new JButton("Cancel");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.equals(txtUsername.getText()) && password.equals(new String(txtPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtUsername.requestFocus();
            }
        });
    }
}
