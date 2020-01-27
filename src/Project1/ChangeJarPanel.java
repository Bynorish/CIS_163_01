package Project1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class ChangeJarPanel here.
 *
 * @author Roger Ferguson
 */
public class ChangeJarPanel extends JPanel {

    private ChangeJar jar;
    private ChangeJar savedJar;


    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    JButton takeOutButton, AddPenny, RemovePenny, TakeOutAmount, AddAmount, Save, Update, NewEmptyJar, NewJarFromSaved, NewJarFromInts;
    JLabel qAvailable, dAvailable, nAvailable, pAvailable, SavedJar;
    JTextField qField, dField, nField, pField, DoubleField;
    private JButton[] buttons = {takeOutButton, AddPenny, RemovePenny, TakeOutAmount, AddAmount, Save, Update, NewEmptyJar, NewJarFromSaved, NewJarFromInts};
    /**
     * labels for message and credits
     */
    JLabel message, credits, StrDouble;

    public ChangeJarPanel() {

        // create the game object as well as the ChangeJarGUI Frame
        jar = new ChangeJar(10, 2, 3, 4);
        savedJar = new ChangeJar();
        // set the layout to GridBag
        setLayout(new GridLayout(13, 3));
        setBackground(Color.lightGray);

        // get Die #2 from game and place on ChangeJarGUI
        qField = new JTextField("0", 3);
        add(new JLabel("Quarters:"));
        add(qField);
        qAvailable = new JLabel();
        qAvailable.setText(Integer.toString(jar.getQuarters()));
        add(qAvailable);

        dField = new JTextField("0", 3);
        add(new JLabel("Dimes:"));
        add(dField);
        dAvailable = new JLabel();
        dAvailable.setText(Integer.toString(jar.getDimes()));
        add(dAvailable);


        nField = new JTextField("0", 3);
        add(new JLabel("Nickels:"));
        add(nField);
        nAvailable = new JLabel();
        nAvailable.setText(Integer.toString(jar.getNickels()));
        add(nAvailable);


        pField = new JTextField("0", 3);
        add(new JLabel("Pennies:"));
        add(pField);
        pAvailable = new JLabel();
        pAvailable.setText(Integer.toString(jar.getPennies()));
        add(pAvailable);

        takeOutButton = new JButton("Take Out");
        add(takeOutButton);

        AddPenny = new JButton("Add Penny");
        add(AddPenny);

        RemovePenny = new JButton("Remove Penny");
        add(RemovePenny);

        AddAmount = new JButton("Add coins to jar");
        add(AddAmount);

        NewEmptyJar = new JButton("New Empty Jar");
        NewJarFromInts = new JButton("New Jar with Ints");
        NewJarFromSaved = new JButton("New Jar from Saved Jar");

        add(NewEmptyJar);
        add(NewJarFromInts);
        add(NewJarFromSaved);

        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel(" "));
        DoubleField = new JTextField("0.0", 3);
        TakeOutAmount = new JButton("Remove amount");
        add(TakeOutAmount);
        add(DoubleField);


        credits = new JLabel();
        credits.setText(fmt.format(jar.getAmount()));

        Save = new JButton("Save Jar");
        add(new JLabel(" "));
        add(Save);
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel("Saved Jar total:"));
        SavedJar = new JLabel();
        SavedJar.setText(fmt.format(savedJar.getAmount()));
        add(SavedJar);
        Update = new JButton("Update Saved Jar");
        add(Update);

        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel(" "));
        add(new JLabel(" "));


        add(new JLabel("Total:"));
        add(credits);


        // register the listeners
      /*  for (int i=0; i<(buttons.length-1) ; i++)
        {
            buttons[i]= new JButton();
            buttons[i].addActionListener(new ButtonListener());
        }

*/
        takeOutButton.addActionListener(new ButtonListener());
        AddPenny.addActionListener(new ButtonListener());
        RemovePenny.addActionListener(new ButtonListener());
        AddAmount.addActionListener(new ButtonListener());
        TakeOutAmount.addActionListener(new ButtonListener());
        Save.addActionListener(new ButtonListener());
        Update.addActionListener(new ButtonListener());
        NewEmptyJar.addActionListener(new ButtonListener());
        NewJarFromSaved.addActionListener(new ButtonListener());
        NewJarFromInts.addActionListener(new ButtonListener());
    }


    /****************************************************************
     Inner class to respond to the user action
     ****************************************************************/
    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            int quarters, dimes, nickels, pennies;

            if (event.getSource() == takeOutButton) {
                try {
                    quarters = Integer.parseInt(qField.getText());
                    dimes = Integer.parseInt(dField.getText());
                    nickels = Integer.parseInt(nField.getText());
                    pennies = Integer.parseInt(pField.getText());
                    jar.takeOut(quarters, dimes, nickels, pennies);
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter a positive integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Not enough specified coins for this operation or negative number");
                }


            }
            if (event.getSource() == AddPenny) {
                jar.inc();
                pAvailable.setText(Integer.toString(jar.getPennies()));
            }
            if (event.getSource() == RemovePenny) {
                try {
                    jar.dec();
                    pAvailable.setText(Integer.toString(jar.getPennies()));
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Not enough specified coins for this operation");
                }

            }

            if (event.getSource() == AddAmount) {
                try {
                    quarters = Integer.parseInt(qField.getText());
                    dimes = Integer.parseInt(dField.getText());
                    nickels = Integer.parseInt(nField.getText());
                    pennies = Integer.parseInt(pField.getText());
                    jar.add(quarters, dimes, nickels, pennies);
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter a positive integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Not enough specified coins for this operation");
                }

            }
            if (event.getSource() == Update) {
                savedJar.load("SavedJar");

                SavedJar.setText(fmt.format(savedJar.getAmount()));
            }
            if (event.getSource() == TakeOutAmount) {
                try {
                    jar.takeOut(Double.parseDouble(DoubleField.getText()));
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter a positive integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Not enough specified coins for this operation or negative number");
                }

            }
            if (event.getSource() == Save) {
                try {
                    jar.save("SavedJar");
                    savedJar.load("SavedJar");


                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Couldn't save file");
                }

            }
            if (event.getSource() == NewEmptyJar) {
                try {
                    jar = new ChangeJar();
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error, unable to create empty jar");
                }

            }

            if (event.getSource() == NewJarFromInts) {
                try {
                    quarters = Integer.parseInt(qField.getText());
                    dimes = Integer.parseInt(dField.getText());
                    nickels = Integer.parseInt(nField.getText());
                    pennies = Integer.parseInt(pField.getText());

                    jar = new ChangeJar(quarters, dimes, nickels, pennies);
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));

                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter a positive integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error, unable to create jar or negative number");
                }

            }

            if (event.getSource() == NewJarFromSaved) {
                try {
                    /*savedJar.load("SavedJar");*/
                    jar = new ChangeJar(savedJar);
                    qAvailable.setText(Integer.toString(jar.getQuarters()));
                    dAvailable.setText(Integer.toString(jar.getDimes()));
                    nAvailable.setText(Integer.toString(jar.getNickels()));
                    pAvailable.setText(Integer.toString(jar.getPennies()));
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error, unable to create new jar from saved file");
                }

            }

            // updates the labels
            credits.setText(fmt.format(jar.getAmount()));
            SavedJar.setText(fmt.format(savedJar.getAmount()));
        }
    }
}