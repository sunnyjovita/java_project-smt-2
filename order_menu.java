package com.shop;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class order_menu {
    private JFrame frame;
    private JLabel name, number, address;
    private JTextField NameTextField, NumberTextField;
    private JButton confirmButton, backButton;
    private JTextArea textArea;

    void CreateAndShowGUI() throws IOException{
        frame = new JFrame("Order Form");
        frame.setBounds(100,100,420,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // make the panel fix in the layer (good position)
        frame.setLocationRelativeTo(null); // make the frame fix in the layer

        // label for title
        JLabel fillDetails = new JLabel("Fill in Details");
        fillDetails.setBounds(145,11,131,26);
        fillDetails.setFont(new Font("Times new roman", Font.BOLD, 18));
        fillDetails.setForeground(Color.DARK_GRAY);
        frame.getContentPane().add(fillDetails);

        // create name textfield
        name = new JLabel("Name");
        name.setBounds(10,46,46,14);
        frame.getContentPane().add(name);

        NameTextField = new JTextField();
        NameTextField.setBounds(82, 43, 176, 20);
        frame.getContentPane().add(NameTextField);

        // create telephone number textfield
        number = new JLabel("Tel No");
        number.setBounds(10,92,46,14);
        frame.getContentPane().add(number);

        NumberTextField = new JTextField();
        NumberTextField.setBounds(82,89,176,20);
        frame.getContentPane().add(NumberTextField);

        // create address textfield
        address = new JLabel("Address");
        address.setBounds(10, 137, 62, 14);
        frame.getContentPane().add(address);

        // for the address text filed, i didn't use JTextField, because it'll display the text from the middle, and
        // can't wrap the text to be inside the border,
        // so i used textArea and Border to keep the text inside the border.
//        AddressTextField = new JTextField();
//        AddressTextField.setBounds(82,132,236,85);
//        frame.getContentPane().add(AddressTextField);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea = new JTextArea();
        textArea.setBounds(82, 132, 236, 85);
        // outline the box
        textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // make sure the text is not out of the textfield.
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.getContentPane().add(textArea);

        // create backbutton
        backButton = new JButton("Cancel ");
        backButton.setBounds(130, 228, 89, 23);
        frame.getContentPane().add(backButton);

        // create confirm button
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(229, 228, 89, 23);
        frame.getContentPane().add(confirmButton);

        // backbutton action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    items_menu item = new items_menu();
                    item.createandshowGUI();
                    frame.setVisible(true);
                    frame.dispose();
                } catch(IOException e1){
                    e1.printStackTrace();
                }
            }
        });

        // confirm button action
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(NameTextField.getText().equals("") || textArea.getText().equals("") || NumberTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Field can not be empty");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Your items will be delivered soon, thank you for ordering");
                    // make it return to the first frame after success ordering
                    try{
                        MainMenu m = new MainMenu();
                        m.main(null);
                        frame.setVisible(true);
                        frame.dispose();

                    } catch(IOException e2){
                        e2.printStackTrace();
                    }
                }
            }

        });

        // input image
        Image image = ImageIO.read(this.getClass().getResource("olshop.png"));
        Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        JLabel lblNewLabel = new JLabel(imageIcon);
        lblNewLabel.setBounds(268, 19, 126, 90);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }

    public void setVisible(boolean b) throws IOException {
        // TODO Auto-generated method stub
    }


}





