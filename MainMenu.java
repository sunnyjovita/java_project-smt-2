package com.shop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

public class MainMenu extends JPanel{

    public static void main(String args[]) throws IOException{
        // create a frame using JFrame for the window/the main display, and add panels inside the frame.
        MainMenu m = new MainMenu();
        m.createandshowGUI();
        frame = new JFrame("LogIn");
        // add anything from MainMenu to frame by using getContentPane
        frame.getContentPane().add(m);
        // set the frame in the middle screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // use static for the frame because the frame is inside the static class
    private JPanel panel1, panel2;
    static private JFrame frame;
    private JButton orderButton;
    private JButton LoginButton;
    private JLabel picLabel, title;

    public void createandshowGUI() throws IOException{
        JPanel panel = new JPanel(new BorderLayout());

        // input the image and set the scale, and set it to be an icon
        Image image = ImageIO.read(this.getClass().getResource("olshop.png"));
        Image imageScaled = image.getScaledInstance(350, 300, image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        picLabel = new JLabel(imageIcon);

        // create a title
        Box b1 = Box.createVerticalBox();
        title = new JLabel("Eco-Store ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Times new roman", Font.PLAIN + Font.BOLD, 35));
        title.setForeground(Color.DARK_GRAY);

        // add order button
        panel1 = new JPanel();
        Box b2 = Box.createVerticalBox();
        orderButton = new JButton("Order now >>");
        panel1.add(orderButton);
        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add login button
        panel2 = new JPanel();
        LoginButton = new JButton("Log In >>");
        panel2.add(LoginButton);
        LoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(picLabel, BorderLayout.CENTER);
        panel.add(b1, BorderLayout.NORTH);
        b1.add(title);
        panel.add(b2, BorderLayout.SOUTH);
        b2.add(panel1);
        b2.add(panel2);
        add(panel);

        // orderButton Action
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    items_menu item = new items_menu();
                    item.createandshowGUI();
                    frame.setVisible(true);

                    // dispose the previous frame
                    frame.dispose();

                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });

        // Loginbutton Action
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Login log = new Login();
                    log.createandshowGUI();
                    frame.setVisible(true);

                    // dispose the previous frame
                    frame.dispose();
                } catch(IOException e2){
                    e2.printStackTrace();
                }
            }
        });

    }

}
