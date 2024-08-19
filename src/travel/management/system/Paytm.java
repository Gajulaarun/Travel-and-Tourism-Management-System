package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Paytm extends JFrame implements ActionListener {
    
    Paytm() {
        setBounds(500, 200, 800, 600);
        setTitle("Paytm Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try {
            pane.setPage("https://paytm.com/rent-payment");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.setOpaque(false);  // Make panel transparent
        
        // Create and style the Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setIcon(new ImageIcon("path/to/back_icon.png")); // Add your own icon
        back.setPreferredSize(new Dimension(150, 40));
        back.addActionListener(this);
        buttonPanel.add(back);
        
        // Create and style the Open in Browser button
        JButton openInBrowser = new JButton("Open in Browser");
        openInBrowser.setFont(new Font("Arial", Font.BOLD, 14));
        openInBrowser.setBackground(new Color(0, 128, 255));
        openInBrowser.setForeground(Color.WHITE);
        openInBrowser.setFocusPainted(false);
        openInBrowser.setIcon(new ImageIcon("path/to/browser_icon.png")); 
        openInBrowser.setPreferredSize(new Dimension(180, 40));
        openInBrowser.addActionListener(e -> openWebpage("https://paytm.com/rent-payment"));
        buttonPanel.add(openInBrowser);
        
        // Add the button panel at the bottom
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        
    }
    
    private void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new Paytm();
    }
}
