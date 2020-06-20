package com.shop;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class items_menu {
    static private JFrame frame;
    static private JButton backButton, orderButton;
    static private JTable table;
    static private JTextField textField;

    static private JCheckBox cashless, cod;
    static private GridBagConstraints gbc;

    static DefaultTableModel dtm;

    private static final int ELEMENTSclothes = 9;
    Double[] priceClothes;

    private static final int ELEMENTSaccess = 5;
    Double[] priceAccessories;

    private static final int ELEMENTdaily = 4;
    Double[] priceDaily;

    private static final int ELEMENTfurni = 7;
    Double[] priceFurni;

    private static final int ELEMENTelec = 5;
    Double[] priceELec;

    double totalPrice = 0;
    double totalQuantity = 0;
    double totalClothes = 0;
    double totalAccessories = 0;
    double totalDaily = 0;
    double totalFurni = 0;
    double totalElec = 0;

    static private JLabel[] clothesImage;
    static private JLabel[] clothesLabel;
    private String[] fileClothes;
    private JSpinner[] numSpinner;

    static private JLabel[] accessImage;
    static private JLabel[] accessLabel;
    private String[] fileAccess;
    private JSpinner[] numSpinnerAccess;

    static private JLabel[] dailyImage;
    static private JLabel[] dailyLabel;
    private String[] fileDaily;
    private JSpinner[] numSpinnerDaily;

    static private JLabel[] furniImage;
    static private JLabel[] furniLabel;
    private String[] fileFurni;
    private JSpinner[] numSpinnerFurni;

    static private JLabel[] elecImage;
    static private JLabel[] elecLabel;
    private String[] fileElec;
    private JSpinner[] numSpinnerElec;

    double c1, c2, c3, c4, c5, c6, c7, c8, c9;
    double clothes1, clothes2, clothes3, clothes4, clothes5, clothes6, clothes7, clothes8, clothes9;

    double a1,a2,a3,a4,a5;
    double access1, access2, access3, access4, access5;

    double f1,f2,f3,f4,f5,f6,f7;
    double furni1, furni2, furni3, furni4, furni5, furni6, furni7;

    double d1,d2,d3,d4;
    double daily1, daily2, daily3, daily4;

    double e1,e2,e3,e4,e5;
    double elec1, elec2, elec3, elec4, elec5;

    public void createandshowGUI() throws IOException {
        frame = new JFrame("Main Menu");
        frame.setBounds(100, 100, 750, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // make the panel fix in the layer (good position)
        frame.setLocationRelativeTo(null); // make the frame fix in the layer

        JLabel lblFoodOrdered = new JLabel("Total Ordered");
        lblFoodOrdered.setBounds(519, 11, 81, 10);
        frame.getContentPane().add(lblFoodOrdered);

        // make a table
        table = new JTable();
        // create rows, and columns with null object values by using dtm
        dtm = new DefaultTableModel(0, 0);
        String header[] = new String[]{"Item", "Qty", "Price", "Spinner"};
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        table = new JTable();
        table.setModel(dtm);
        table.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
        table.setSize(245, 300); // width,height
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
        table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
        // set the width to 0 to hide the spinner

        // remove the boarder cells
        table.setShowGrid(false);
        frame.getContentPane().add(table);

        // ADD LABEL (TOTAL)
        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(519, 340, 46, 14);
        frame.getContentPane().add(lblTotal);

        // ADD TEXT FIELD for total
        textField = new JTextField();
        textField.setBounds(585, 340, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // ADD LABEL (PAYMENT)
        JLabel payment = new JLabel("Payment method:");
        payment.setBounds(475, 365, 100, 14);
        frame.getContentPane().add(payment);

        // payment checkbox
        cod = new JCheckBox("CoD (Cash on Delivery)");
        cod.setBounds(475, 385, 200, 14);
        cashless = new JCheckBox("Cashless");
        cashless.setBounds(475, 405, 200, 14);
        frame.getContentPane().add(cod);
        frame.getContentPane().add(cashless);

        // BUTTON ORDER
        orderButton = new JButton("Order");
        orderButton.setBounds(500, 440, 89, 23);
        frame.getContentPane().add(orderButton);

        // BUTTON BACK
        backButton = new JButton("Back");
        backButton.setBounds(610, 440, 89, 23);
        frame.getContentPane().add(backButton);

        // method for switch to another panel using JTabbed pane
        // to switch between a group of components by clicking on a tab with a given title
        // set it to the top
        // put each section in the different panels (easier to maintain)
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        addIt(tabbedPane, "Clothes");
        addIt2(tabbedPane, "Accessories");
        addIt3(tabbedPane, "Daily Needs");
        addIt4(tabbedPane, "Furniture");
        addIt5(tabbedPane, "Electronics");

        tabbedPane.setBounds(18, 11, 450, 450);

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);

        // using this addActionListener as the response to the Jbutton objects.
        // by using this, actionPerformed is invoked automatically whenever the users click the button.

        // backbutton action
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    MainMenu m = new MainMenu();
                    m.main(null);
                    m.setVisible(true);
                    frame.dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // orderbutton action
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "You haven't ordered anything yet");
                } else {
                    try {
                        order_menu o = new order_menu();
                        o.CreateAndShowGUI();
                        frame.setVisible(true);
                        frame.dispose();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });

        // payment choice 1 (cod)
        cod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (cod.isSelected() && cashless.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You can only choose one method");
                }
            }
        });

        // payment choice 2 (cashless)
        cashless.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (cashless.isSelected() && cod.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You can only choose one method");
                }
            }
        });
    }

    // panel for clothes
    void addIt(JTabbedPane tabbedPane, String text) throws IOException {
        JPanel p1 = new JPanel(new GridBagLayout());
        // using gridbaglayout to set the pics, labels, and spinners, since it allows to position the components that relative to others by using constraints.
        gbc = new GridBagConstraints();
        // insets() = Constructs a new Insets instance with four different offsets.
        gbc.insets = new Insets(10, 0, 0, 0);

        clothesImage = new JLabel[ELEMENTSclothes];
        clothesLabel = new JLabel[ELEMENTSclothes];
        numSpinner = new JSpinner[ELEMENTSclothes];
        fileClothes = new String[ELEMENTSclothes];
        priceClothes = new Double[ELEMENTSclothes];

        fileClothes[0] = new String("black t-shirt.png");
        fileClothes[1] = new String("white polo shirt.png");
        fileClothes[2] = new String("brown sweater.png");
        fileClothes[3] = new String("grey sweater.png");
        fileClothes[4] = new String("jeans.png");
        fileClothes[5] = new String("rainbow gloves.png");
        fileClothes[6] = new String("red scarf.png");
        fileClothes[7] = new String("rip jeans.png");
        fileClothes[8] = new String("socks.png");

        clothesLabel[0] = new JLabel("T-shirt");
        clothesLabel[1] = new JLabel("Shirt");
        clothesLabel[2] = new JLabel("Brown Sweater");
        clothesLabel[3] = new JLabel("Grey Sweater");
        clothesLabel[4] = new JLabel("Blue Jeans");
        clothesLabel[5] = new JLabel("Rainbow Gloves");
        clothesLabel[6] = new JLabel("Red Scarf");
        clothesLabel[7] = new JLabel("Ripped Jeans");
        clothesLabel[8] = new JLabel("Socks");

        priceClothes[0] = 79.0;
        priceClothes[1] = 99.0;
        priceClothes[2] = 120.0;
        priceClothes[3] = 120.0;
        priceClothes[4] = 179.0;
        priceClothes[5] = 56.0;
        priceClothes[6] = 60.0;
        priceClothes[7] = 200.0;
        priceClothes[8] = 45.0;
//        priceClothes[9] = 250.0;

        // set the pics, labels, spinners by looping it.
        for (int i = 0; i < ELEMENTSclothes; i++) {
            // read the image
            Image image = ImageIO.read(this.getClass().getResource(fileClothes[i]));
            // set the picture height and width
            Image imageScaled = image.getScaledInstance(90, 105, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            // set spinner from 1 to 10
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); //set the  value,minimum,maximum,stepSize for the spinner
            numSpinner[i] = new JSpinner(spnummodel);
            numSpinner[i].addChangeListener(listener);
            clothesImage[i] = new JLabel(imageIcon);
        }

        // set the picture using gridx and gridy
        // gridx is for columns
        // gridy is for rows
        gbc.gridx = 0; // gridx 0 represents the most left cell for which component will be placed
        for (int i = 0; i < ELEMENTSclothes; i++) {
            // make 3 columns
            int columns = 3;
            if (i % columns == 0) {
                gbc.gridy += 2;
                gbc.gridx = 0;
            }

            p1.add(clothesImage[i], gbc);
            gbc.gridy++; // add one row for food label
            p1.add(clothesLabel[i], gbc);
            gbc.gridy--; // remove one row
            gbc.gridx++; // add one column for numSpinner
            p1.add(numSpinner[i], gbc);
            gbc.gridx++; // add one column for move to the next column
            tabbedPane.addTab(text, p1);
        }
    }

    // for void addIt2, addIt3, and so on, they are same as addIt function. just change the pic, and labels.
    void addIt2(JTabbedPane tabbedPane, String text) throws IOException{
        JPanel p2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);

        accessImage = new JLabel[ELEMENTSaccess];
        accessLabel = new JLabel[ELEMENTSaccess];
        numSpinnerAccess = new JSpinner[ELEMENTSaccess];
        fileAccess = new String[ELEMENTSaccess];
        priceAccessories = new Double[ELEMENTSaccess];

        fileAccess[0] = new String("camellia earrings.png");
        fileAccess[1] = new String("diamond earrings.png");
        fileAccess[2] = new String("dream catcher pendant.png");
        fileAccess[3] = new String("elk ivory gemstone.png");
        fileAccess[4] = new String("flower necklace.png");
        accessLabel[0] = new JLabel("Clara Earrings");
        accessLabel[1] = new JLabel("Diamond Earrings");
        accessLabel[2] = new JLabel("Star Pendant");
        accessLabel[3] = new JLabel("Ivory Gemstone");
        accessLabel[4] = new JLabel("Flower Necklace");
        priceAccessories[0] = 180.0;
        priceAccessories[1] = 210.0;
        priceAccessories[2] = 152.5;
        priceAccessories[3] = 143.0;
        priceAccessories[4] = 257.0;

        // read the image
        for(int i=0; i<ELEMENTSaccess; i++){
            Image image = ImageIO.read(this.getClass().getResource(fileAccess[i]));
            // set height and width
            Image imageScaled = image.getScaledInstance(90,105, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); //set the  value,minimum,maximum,stepSize for the spinner
            numSpinnerAccess[i] = new JSpinner(spnummodel);
            numSpinnerAccess[i].addChangeListener(listenerAccess);
            accessImage[i] = new JLabel(imageIcon);
        }

        gbc.gridx = 0;
        int columns = 3;
        for(int i=0; i<ELEMENTSaccess; i++){
            if(i%columns == 0){
                gbc.gridx = 0;
                gbc.gridy += 2;
            }

            p2.add(accessImage[i], gbc);
            gbc.gridy++;
            p2.add(accessLabel[i], gbc);
            gbc.gridy--;
            gbc.gridx++;
            p2.add(numSpinnerAccess[i], gbc);
            gbc.gridx++;
            tabbedPane.addTab(text, p2);
        }
    }

    void addIt3(JTabbedPane tabbedPane, String text) throws  IOException{
        JPanel p3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);

        dailyImage = new JLabel[ELEMENTdaily];
        dailyLabel = new JLabel[ELEMENTdaily];
        numSpinnerDaily = new JSpinner[ELEMENTdaily];
        fileDaily = new String[ELEMENTdaily];
        priceDaily = new Double[ELEMENTdaily];

        fileDaily[0] = new String("Educational books.png");
        fileDaily[1] = new String("lamp1.png");
        fileDaily[2] = new String("pencils.png");
        fileDaily[3] = new String("perfume.png");
        dailyLabel[0] = new JLabel("Books");
        dailyLabel[1] = new JLabel("Lamp");
        dailyLabel[2] = new JLabel("Pencils");
        dailyLabel[3] = new JLabel("Perfume");
        priceDaily[0] = 73.0;
        priceDaily[1] = 80.0;
        priceDaily[2] = 35.0;
        priceDaily[3] = 152.0;

        // read the image;
        for(int i=0; i<ELEMENTdaily; i++){
            Image image = ImageIO.read(this.getClass().getResource(fileDaily[i]));
            Image imageScaled = image.getScaledInstance(90,105, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0,0,10,1);
            numSpinnerDaily[i] = new JSpinner(spnummodel);
            numSpinnerDaily[i].addChangeListener(listenerDaily);
            dailyImage[i] = new JLabel(imageIcon);

        }

        gbc.gridx = 0;
        int columns = 3;
        for(int i=0; i<ELEMENTdaily; i++){
            if(i%columns == 0){
                gbc.gridx = 0;
                gbc.gridy += 2;
            }

            p3.add(dailyImage[i], gbc);
            gbc.gridy++;
            p3.add(dailyLabel[i], gbc);
            gbc.gridy--;
            gbc.gridx++;
            p3.add(numSpinnerDaily[i], gbc);
            gbc.gridx++;
            tabbedPane.addTab(text, p3);
        }

    }

    void addIt4(JTabbedPane tabbedPane, String text) throws IOException{
        JPanel p4 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);

        furniImage = new JLabel[ELEMENTfurni];
        furniLabel = new JLabel[ELEMENTfurni];
        numSpinnerFurni = new JSpinner[ELEMENTfurni];
        fileFurni = new String[ELEMENTfurni];
        priceFurni = new Double[ELEMENTfurni];

        fileFurni[0] = new String("cooking pan.png");
        fileFurni[1] = new String("cup.png");
        fileFurni[2] = new String("g.png");
        fileFurni[3] = new String("office chair.png");
        fileFurni[4] = new String("red sofa.png");
        fileFurni[5] = new String("wooden table.png");
        fileFurni[6] = new String("kettle.png");
        furniLabel[0] = new JLabel("Cooking pan");
        furniLabel[1] = new JLabel("Cup");
        furniLabel[2] = new JLabel("Glass");
        furniLabel[3] = new JLabel("Chair");
        furniLabel[4] = new JLabel("Red sofa");
        furniLabel[5] = new JLabel("Wooden table");
        furniLabel[6] = new JLabel("Kettle");

        priceFurni[0] = 170.0;
        priceFurni[1] = 70.0;
        priceFurni[2] = 110.0;
        priceFurni[3] = 250.0;
        priceFurni[4] = 599.0;
        priceFurni[5] = 148.0;
        priceFurni[6] = 80.0;


        // read the image
        for(int i=0; i<ELEMENTfurni; i++){
            Image image = ImageIO.read(this.getClass().getResource(fileFurni[i]));
            // set height and width
            Image imageScaled = image.getScaledInstance(90,105, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); //set the  value,minimum,maximum,stepSize for the spinner
            numSpinnerFurni[i] = new JSpinner(spnummodel);
            numSpinnerFurni[i].addChangeListener(listenerFurni);
            furniImage[i] = new JLabel(imageIcon);

        }

        gbc.gridx = 0;
        int columns = 3;
        for(int i=0; i<ELEMENTfurni; i++){
            if(i%columns == 0){
                gbc.gridx = 0;
                gbc.gridy += 2;
            }

            p4.add(furniImage[i], gbc);
            gbc.gridy++;
            p4.add(furniLabel[i], gbc);
            gbc.gridy--;
            gbc.gridx++;
            p4.add(numSpinnerFurni[i], gbc);
            gbc.gridx++;
            tabbedPane.addTab(text, p4);
        }
    }


    void addIt5(JTabbedPane tabbedPane, String text) throws IOException{
        JPanel p5 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,0,0,0);

        elecImage = new JLabel[ELEMENTelec];
        elecLabel = new JLabel[ELEMENTelec];
        numSpinnerElec = new JSpinner[ELEMENTelec];
        fileElec = new String[ELEMENTelec];
        priceELec = new Double[ELEMENTelec];

        fileElec[0] = new String("Mouse.png");
        fileElec[1] = new String("Nikon Camera.png");
        fileElec[2] = new String("Radio.png");
        fileElec[3] = new String("Samsung mobile phone.png");
        fileElec[4] = new String("White drone.png");
        elecLabel[0] = new JLabel("Mouse");
        elecLabel[1] = new JLabel("Camera");
        elecLabel[2] = new JLabel("Radio");
        elecLabel[3] = new JLabel("Handphone");
        elecLabel[4] = new JLabel("White drone");
        priceELec[0] = 150.0;
        priceELec[1] = 560.0;
        priceELec[2] = 1100.0;
        priceELec[3] = 2000.0;
        priceELec[4] = 3000.0;

        // read the image
        for(int i=0; i<ELEMENTelec; i++){
            Image image = ImageIO.read(this.getClass().getResource(fileElec[i]));
            // set height and width
            Image imageScaled = image.getScaledInstance(90,105, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); //set the  value,minimum,maximum,stepSize for the spinner
            numSpinnerElec[i] = new JSpinner(spnummodel);
            numSpinnerElec[i].addChangeListener(listenerElec);
            elecImage[i] = new JLabel(imageIcon);

        }

        gbc.gridx = 0;
        int columns = 3;
        for(int i=0; i<ELEMENTelec; i++){
            if(i%columns == 0){
                gbc.gridx = 0;
                gbc.gridy += 2;
            }

            p5.add(elecImage[i], gbc);
            gbc.gridy++;
            p5.add(elecLabel[i], gbc);
            gbc.gridy--;
            gbc.gridx++;
            p5.add(numSpinnerElec[i], gbc);
            gbc.gridx++;
            tabbedPane.addTab(text, p5);
        }
    }

    // I'm using ChangeListener rather than ActionListener because
    // change listener is not notified of what has changed, but simply that the source object has changed.
    // Therefore, a change listener is most useful when it is only necessary to know when an object has changed in any way.

    ChangeListener listener = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            // set the picture, spinner, and the label in the column and row
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {

                    if (dtm.getValueAt(row, 0).equals("T-shirt")) {
                        // set quantity in the column 1
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        // set the total price of the quantity in column 2
                        dtm.setValueAt(c1 * quantity, row, 2);
                        clothes1 = c1 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Shirt")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c2 * quantity, row, 2);
                        clothes2 = c2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Brown Sweater")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c3 * quantity, row, 2);
                        clothes3 = c3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Grey Sweater")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c4 * quantity, row, 2);
                        clothes4 = c4 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Blue Jeans")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c5 * quantity, row, 2);
                        clothes5 = c5 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Rainbow Gloves")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c6 * quantity, row, 2);
                        clothes6 = c6 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Red Scarf")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c7 * quantity, row, 2);
                        clothes7 = c7 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Ripped Jeans")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c8 * quantity, row, 2);
                        clothes8 = c8 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Socks")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(c9 * quantity, row, 2);
                        clothes9 = c9 * quantity;
                    }

                    // remove the row of the quantity is zero
                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }

                    totalClothes = clothes1 + clothes2 + clothes3 + clothes4 + clothes5 + clothes6 + clothes7 + clothes8 + clothes9;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    return;
                }
            }

            // there is no row with JSpinner( because it is hidden) , we have to add it
            for (int i = 0; i < ELEMENTSclothes; i++) {
                // this is for the 'clicked' Spinner
                if (numSpinner[i] == e.getSource()) {
                    totalPrice = priceClothes[i];
                    switch (clothesLabel[i].getText()) {
                        case "T-shirt":
                            // this price will be displayed at the total
                            c1 = 79.0;
                            clothes1 = c1;
                            break;
                        case "Shirt":
                            c2 = 99.0;
                            clothes2 = c2;
                            break;
                        case "Brown Sweater":
                            c3 = 120.0;
                            clothes3 = c3;
                            break;
                        case "Grey Sweater":
                            c4 = 120.0;
                            clothes4 = c4;
                            break;
                        case "Blue Jeans":
                            c5 = 179.0;
                            clothes5 = c5;
                            break;
                        case "Rainbow Gloves":
                            c6 = 56.0;
                            clothes6 = c6;
                            break;
                        case "Red Scarf":
                            c7 = 60.0;
                            clothes7 = c7;
                            break;
                        case "Ripped Jeans":
                            c8 = 200.0;
                            clothes8 = c8;
                            break;
                        case "Socks":
                            c9 = 45.0;
                            clothes9 = c9;
                            break;
                    }
                    totalClothes = clothes1 + clothes2 + clothes3 + clothes4 + clothes5 + clothes6 + clothes7 + clothes8 + clothes9;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    dtm.addRow(new Object[]{clothesLabel[i].getText(), quantity, totalPrice, numSpinner[i]});
                    return;
                }
            }
        }
    };

    ChangeListener listenerAccess = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            for(int row=0; row<rows; row++){
                if(dtm.getValueAt(row,3) == e.getSource()){
                    if(dtm.getValueAt(row,0).equals("Clara Earrings")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(a1*quantity, row, 2);
                        access1 = a1*quantity;
                    } else if(dtm.getValueAt(row,0).equals("Diamond Earrings")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(a2*quantity, row, 2);
                        access2 = a2*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Star Pendant")){
                        dtm.setValueAt(quantity, row,1);
                        dtm.setValueAt(a3*quantity, row, 2);
                        access3 = a3*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Ivory Gemstone")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(a4*quantity, row, 2);
                        access4 = a4*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Flower Necklace")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(a5*quantity, row, 2);
                        access5 = a5*quantity;
                    }

                    // remove row if the quantity is 0
                    if(quantity == 0){
                        dtm.removeRow(row);
                    }

                    totalAccessories = access1 + access2 + access3 + access4 +access5;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    return;
                }
            }

            // add spinner because we hide it;
            for(int i=0; i<ELEMENTSaccess; i++){
                if(numSpinnerAccess[i] == e.getSource()){
                    totalPrice = priceAccessories[i];
                    switch (accessLabel[i].getText()){
                        case "Clara Earrings":
                            a1 = 180.0;
                            access1 = a1;
                            break;
                        case "Diamond Earrings":
                            a2 = 210.0;
                            access2 = a2;
                            break;
                        case "Star Pendant":
                            a3 = 152.5;
                            access3 = a3;
                            break;
                        case "Ivory Gemstone":
                            a4 = 143.0;
                            access4 = a4;
                            break;
                        case "Flower Necklace":
                            a5 = 257.0;
                            access5 = a5;
                            break;

                    }

                    totalAccessories = access1 + access2 + access3 + access4 + access5;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity+"");
                    dtm.addRow(new Object[]{accessLabel[i].getText(), quantity, totalPrice, numSpinnerAccess[i]});
                }
            }
        }
    };

    ChangeListener listenerDaily = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            for(int row=0; row<rows; row++){
                if(dtm.getValueAt(row,3) == e.getSource()){
                    if(dtm.getValueAt(row,0).equals("Books")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(d1*quantity, row, 2);
                        daily1 = d1*quantity;
                    } else if(dtm.getValueAt(row,0).equals("Lamp")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(d2*quantity, row, 2);
                        daily2 = d2*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Pencils")){
                        dtm.setValueAt(quantity, row,1);
                        dtm.setValueAt(d3*quantity, row, 2);
                        daily3 = d3*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Perfume")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(d4*quantity, row, 2);
                        daily4 = d4*quantity;
                    }

                    // remove row if the quantity is 0
                    if(quantity == 0){
                        dtm.removeRow(row);
                    }

                    totalDaily = daily1 + daily2 + daily3 + daily4;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    return;
                }
            }

            // add spinner because we hide it;
            for(int i=0; i<ELEMENTdaily; i++){
                if(numSpinnerDaily[i] == e.getSource()){
                    totalPrice = priceDaily[i];
                    switch (dailyLabel[i].getText()){
                        case "Books":
                            d1 = 73.0;
                            daily1 = d1;
                            break;
                        case "Lamp":
                            d2 = 80.0;
                            daily2 = d2;
                            break;
                        case "Pencils":
                            d3 = 35.0;
                            daily3 = d3;
                            break;
                        case "Perfume":
                            d4 = 152.0;
                            daily4 = d4;
                            break;

                    }

                    totalDaily = daily1 + daily2 + daily3 + daily4;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity+"");
                    dtm.addRow(new Object[]{dailyLabel[i].getText(), quantity, totalPrice, numSpinnerDaily[i]});
                }
            }
        }
    };

    ChangeListener listenerFurni = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            // set the picture, spinner, and the label in the column and row
            for (int row = 0; row < rows; row++) {
                if (dtm.getValueAt(row, 3) == e.getSource()) {

                    if (dtm.getValueAt(row, 0).equals("Cooking pan")) {
                        // set quantity in the column 1
                        dtm.setValueAt(quantity, row, 1); // obj, row, column
                        // set the total price of the quantity in column 2
                        dtm.setValueAt(f1 * quantity, row, 2);
                        furni1 = f1 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Cup")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f2 * quantity, row, 2);
                        furni2 = f2 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Glass")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f3 * quantity, row, 2);
                        furni3 = f3 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Chair")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f4 * quantity, row, 2);
                        furni4 = f4 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Red sofa")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f5 * quantity, row, 2);
                        furni5 = f5 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Wooden table")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f6 * quantity, row, 2);
                        furni6 = f6 * quantity;
                    } else if (dtm.getValueAt(row, 0).equals("Kettle")) {
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(f7 * quantity, row, 2);
                        furni7 = f7 * quantity;
                    }

                    // remove the row of the quantity is zero
                    if (quantity == 0) {
                        dtm.removeRow(row);
                    }

                    totalFurni = furni1 + furni2 + furni3 + furni4 + furni5 + furni6 + furni7;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    return;
                }
            }

            // there is no row with JSpinner( because it is hidden) , we have to add it
            for (int i = 0; i < ELEMENTfurni; i++) {
                // this is for the 'clicked' Spinner
                if (numSpinnerFurni[i] == e.getSource()) {
                    totalPrice = priceFurni[i];
                    switch (furniLabel[i].getText()) {
                        case "Cooking pan":
                            f1 = 170.0;
                            furni1 = f1;
                            break;
                        case "Cup":
                            f2 = 70;
                            furni2 = f2;
                            break;
                        case "Glass":
                            f3 = 110;
                            furni3 = f3;
                            break;
                        case "Chair":
                            f4 = 250.0;
                            furni4 = f4;
                            break;
                        case "Red sofa":
                            f5 = 599.9;
                            furni5 = f5;
                            break;
                        case "Wooden table":
                            f6 = 148.0;
                            furni6 = f6;
                            break;
                        case "Kettle":
                            f7 = 80;
                            furni7 = f7;
                            break;
                    }


                    totalFurni = furni1 + furni2 + furni3 + furni4 + furni5 + furni6 + furni7;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    dtm.addRow(new Object[]{furniLabel[i].getText(), quantity, totalPrice, numSpinnerFurni[i]});
                    return;
                }
            }
        }
    };

    ChangeListener listenerElec = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            final int quantity = (int) ((JSpinner) e.getSource()).getValue();
            final int rows = table.getRowCount();
            for(int row=0; row<rows; row++){
                if(dtm.getValueAt(row,3) == e.getSource()){
                    if(dtm.getValueAt(row,0).equals("Mouse")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(e1*quantity, row, 2);
                        elec1 = e1*quantity;
                    } else if(dtm.getValueAt(row,0).equals("Camera")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(e2*quantity, row, 2);
                        elec2 = e2*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Radio")){
                        dtm.setValueAt(quantity, row,1);
                        dtm.setValueAt(e3*quantity, row, 2);
                        elec3 = e3*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("Handphone")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(e4*quantity, row, 2);
                        elec4 = e4*quantity;
                    } else if(dtm.getValueAt(row, 0).equals("White drone")){
                        dtm.setValueAt(quantity, row, 1);
                        dtm.setValueAt(e5*quantity, row, 2);
                        elec5 = e5*quantity;
                    }

                    // remove row if the quantity is 0
                    if(quantity == 0){
                        dtm.removeRow(row);
                    }

                    totalElec = elec1 + elec2 + elec3 + elec4 + elec5;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity + "");
                    return;
                }
            }

            // add spinner because we hide it;
            for(int i=0; i<ELEMENTelec; i++){
                if(numSpinnerElec[i] == e.getSource()){
                    totalPrice = priceELec[i];
                    switch (elecLabel[i].getText()){
                        case "Mouse":
                            e1 = 150.0;
                            elec1 = e1;
                            break;
                        case "Camera":
                            e2 = 560.0;
                            elec2 = e2;
                            break;
                        case "Radio":
                            e3 = 1100.0;
                            elec3 = e3;
                            break;
                        case "Handphone":
                            e4 = 2000.0;
                            elec4 = e4;
                            break;
                        case "White drone":
                            e5 = 3000.0;
                            elec5 = e5;
                            break;

                    }

                    totalElec = elec1 + elec2 + elec3 + elec4 + elec5;
                    totalQuantity = totalClothes + totalAccessories + totalDaily + totalFurni + totalElec;
                    textField.setText(totalQuantity+"");
                    dtm.addRow(new Object[]{elecLabel[i].getText(), quantity, totalPrice, numSpinnerElec[i]});
                }
            }
        }
    };

    public void setVisible(boolean b) throws IOException {
    }
}
