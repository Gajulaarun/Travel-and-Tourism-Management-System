package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    public CheckPackage() {
        setBounds(450, 200, 900, 600);

        // Package details
        String[][] packages = {
            {"GOLD PACKAGE", "10 Days and 9 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet",
             "Soft Drinks Free", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK PACKAGE", "SUMMER SPECIAL",
             "RS 15000/-", "package1.jpg"},

            {"SILVER PACKAGE", "6 Days and 7 Nights", "Toll Free", "Entrance", "Meet and Greet at Airport", 
             "Welcome Drinks on Arrival", "Night Safari", "Cruise with Dinner", "BOOK NOW", "WINTER SPECIAL", 
             "RS 22500/-", "package2.jpg"},

            {"BRONZE PACKAGE", "3 Days and 2 Nights", "Return Airfare", "Free Clubbing", "River Rafting", 
             "Horse Riding and Other Games", "Hard Drinks Free", "Daily Buffet", "BOOK NOW", "MONSOON SPECIAL",
             "RS 30000/-", "package3.jpg"}
        };

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create tabs for each package
        for (int i = 0; i < packages.length; i++) {
            JPanel packagePanel = createPackage(packages[i]);
            tabbedPane.addTab("Package " + (i + 1), null, packagePanel);
        }

        add(tabbedPane);

        setVisible(true);
    }

    // Method to create a package panel
    private JPanel createPackage(String[] pack) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 248, 240));  // Light Beige background

        // Labels for package details
        Color[] labelColors = {new Color(255, 153, 0), new Color(255, 69, 0), new Color(0, 102, 204), new Color(255, 69, 0), 
                               new Color(0, 102, 204), new Color(255, 69, 0), new Color(0, 102, 204), new Color(255, 69, 0)};
        int yPosition = 5;

        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setBounds(50, yPosition, 300, 30);
            label.setForeground(labelColors[i]);
            label.setFont(new Font("Serif", Font.BOLD, i == 0 ? 32 : 20));  // Classy Serif font for elegance
            panel.add(label);
            yPosition += (i == 0) ? 55 : 50;
        }

        // Image for the package
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[11]));
        Image scaledImage = icon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(350, 20, 500, 300);
        panel.add(imageLabel);

        // Labels below the image
        int belowImageYPosition = 340;
        Color[] belowImageColors = {new Color(47, 79, 79), new Color(255, 20, 147), new Color(169, 169, 169)};
        
        for (int i = 8; i < 11; i++) {
            JLabel label = new JLabel(pack[i]);
            label.setBounds(450, belowImageYPosition, 400, 30);
            label.setForeground(belowImageColors[i - 8]);
            label.setFont(new Font("SansSerif", Font.BOLD, 26));  // Modern Sans Serif font for clear readability
            panel.add(label);
            belowImageYPosition += (i == 8) ? 50 : 60; // Increase gap between these labels
        }

        return panel;
    }

    // Helper method to get Color from String
    private Color getColor(String colorName) {
        switch (colorName.toLowerCase()) {
            case "orange":
                return Color.ORANGE;
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "gray":
                return Color.GRAY;
            case "pink":
                return Color.PINK;
            case "darkgray":
                return Color.DARK_GRAY;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
