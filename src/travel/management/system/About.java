
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    About()
    {
     setBounds(600, 200, 500, 550);
     setLayout(null);
     getContentPane().setBackground(Color.white);
     
     
     JLabel l1=new JLabel("ABOUT");
     l1.setBounds(200, 10, 100, 40);
     l1.setForeground(Color.red);
     l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
     add(l1);
     
     String s="Project Brief: Travel and Tourism Management System\n" +
"The Travel and Tourism Management System is a comprehensive application developed to streamline the booking and management processes for travel and tourism services. The system allows users to explore various travel packages, make reservations, and manage their travel itineraries seamlessly.\n" +
"\n" +
"Key Features:\n" +
"\n" +
"Package Selection: Users can browse and select from a variety of travel packages tailored to different destinations and experiences.\n" +
"User Registration and Login: Secure user authentication to manage personal accounts and view booking history.\n" +
"Booking and Payment: Integration of a payment gateway for secure transactions, allowing users to pay for selected packages directly through the platform.\n" +
"Itinerary Management: Users can view and manage their booked itineraries, including details like accommodation, transportation, and activities.\n" +
"Admin Panel: An administrative interface for managing packages, user accounts, and bookings.\n" +
"Technologies Used:\n" +
"\n" +
"Front-End and Back-End: Java Swing is used for creating the user interface and handling the application logic.\n" +
"Database: MySQL is utilized to store user data, package details, bookings, and payment information.\n" +
"Purpose:\n" +
"The primary goal of this project is to simplify the travel planning process by providing an all-in-one platform where users can explore, book, and manage their travel experiences with ease. The system aims to enhance user experience by offering a secure, intuitive, and efficient platform for managing travel arrangements.";
     
     TextArea area=new TextArea(s,10, 40, Scrollbar.VERTICAL);
     area.setEditable(false);
     area.setBounds(20,100,450,300); 
     add(area);
     
     JButton back=new JButton("Back");
        back.setBounds(220, 420, 100, 25);
        back.addActionListener(this);
        add(back);
     
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    
    public static void main(String args[])
    {
        new About();
    }
}
