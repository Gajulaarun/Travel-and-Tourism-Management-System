package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(new Color(245, 245, 245));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(new Color(0, 102, 204));
        text.setFont(new Font("Verdana", Font.BOLD, 30));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setForeground(new Color(0, 204, 102));
        bar.setBackground(Color.WHITE);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading! Please wait...");
        loading.setBounds(230, 150, 165, 30);
        loading.setForeground(new Color(255, 69, 0));
        loading.setFont(new Font("Verdana", Font.BOLD, 16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome "+ username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(new Color(255, 69, 0));
        lblusername.setFont(new Font("Verdana", Font.BOLD, 16));
        add(lblusername);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("s");
    }
}
