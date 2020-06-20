package com.shop;

import javax.swing.*;
import java.awt.*;
import javax.swing.Box;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login extends JPanel {
    static private JButton LoginButton, BackButton;
    static private JFrame frame;
    static private JPanel panel1, panel2, panel3, panel4, panel5;
    static private JTextField usernameField;
    static private JPasswordField passwordField;
    static private JLabel userLabel, passLabel;


    public void createandshowGUI() throws IOException{
        JPanel panel = new JPanel(new BorderLayout());
//        final String back[] = new String[]{};

        // add login button
        panel1 = new JPanel();
        Box b1 = Box.createVerticalBox();
        LoginButton = new JButton("Log In");
        panel1.add(LoginButton);

        // Add username textfield
        panel2 = new JPanel();
        Box b2 = Box.createVerticalBox();
        usernameField = new JTextField(15);
        userLabel = new JLabel("Username");
        panel2.add(userLabel);
        panel2.add(usernameField);

        // Add password textfield
        panel3 = new JPanel();
        passwordField = new JPasswordField(15);
        passLabel = new JLabel("Password ");
        panel3.add(passLabel);
        panel3.add(passwordField);

        // Add back button
        panel4 = new JPanel();
        BackButton = new JButton("Back");
        panel4.add(BackButton);

        // Add checkbox
        panel5 = new JPanel();
        JCheckBox ShowPass = new JCheckBox("Show Password");
        panel5.add(ShowPass);

        // Login button and back button
        panel.add(b1, BorderLayout.SOUTH);
        b1.add(panel1);
        b1.add(panel4);

        // input username and password textfield to panel
        panel.add(b2, BorderLayout.NORTH);
        b2.add(panel2);
        b2.add(panel3);
        b2.add(panel5);
        add(panel);

        // backbutton action
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    MainMenu m = new MainMenu();
                    // can use main(back) or main(null), anything that is []
//                    m.main(back);
                    m.main(null);
                    m.setVisible(true);

                    frame.dispose();
                }
                catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });

        // loginbutton action
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    String uname = usernameField.getText();
                    String passw = passwordField.getText();
                    if(uname.equals("hellosunny")&&passw.equals("javaproject")){
                        items_menu item = new items_menu();
                        item.createandshowGUI();
                        frame.setVisible(true);

                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                        usernameField.setText("");
                        passwordField.setText("");
                    }
                } catch(IOException e2){
                    e2.printStackTrace();
                }

            }
        });

        // show password action
        ShowPass.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ShowPass.isSelected()){
                    // to set the character to be appear or not
                    passwordField.setEchoChar((char)0);
                }else{
                    passwordField.setEchoChar('*');
                }
            }

        });

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}

