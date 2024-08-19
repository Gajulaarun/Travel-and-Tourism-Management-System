package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword;

    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(new Color(245, 245, 245));

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(50, 150, 250));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logg.png"));
        Image i2 = i1.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(110, 110, 180, 180);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        p2.setBackground(Color.white);
        p2.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("Arial", Font.BOLD, 18));
        lblusername.setForeground(new Color(50, 50, 50));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("Arial", Font.BOLD, 18));
        lblpassword.setForeground(new Color(50, 50, 50));
        p2.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 140, 300, 30);
        tfpassword.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(30, 144, 215));
        login.setForeground(Color.white);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setBorder(new LineBorder(new Color(0, 123, 255)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(30, 144, 215));
        signup.setForeground(Color.white);
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBorder(new LineBorder(new Color(0, 123, 255)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forgot Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(30, 144, 215));
        password.setForeground(Color.white);
        password.setFont(new Font("Arial", Font.BOLD, 14));
        password.setBorder(new LineBorder(new Color(0, 123, 255)));
        password.addActionListener(this);
        p2.add(password);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = new String(tfpassword.getPassword());

                String query = "SELECT * FROM account WHERE username='" + username + "' AND password='" + pass + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == password) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
