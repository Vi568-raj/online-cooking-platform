package ui;

import javax.swing.*;
import models.User;
import services.DataStore;

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle("Cooking Learning System - Login");
        setSize(400, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Cooking Learning System", SwingConstants.CENTER);
        title.setBounds(50, 10, 300, 30);
        add(title);

        JLabel userL = new JLabel("Username:");
        userL.setBounds(50, 60, 100, 25);
        add(userL);

        JTextField userF = new JTextField();
        userF.setBounds(150, 60, 180, 25);
        add(userF);

        JLabel passL = new JLabel("Password:");
        passL.setBounds(50, 100, 100, 25);
        add(passL);

        JPasswordField passF = new JPasswordField();
        passF.setBounds(150, 100, 180, 25);
        add(passF);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 145, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String username = userF.getText();
            String password = new String(passF.getPassword());

            User loggedUser = DataStore.login(username, password);
            if (loggedUser != null) {
                JOptionPane.showMessageDialog(this, "Login successful as " + loggedUser.getRole());
                dispose();
                if ("admin".equals(loggedUser.getRole())) {
                    new AdminDashboard();
                } else {
                    new StudentDashboard();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
