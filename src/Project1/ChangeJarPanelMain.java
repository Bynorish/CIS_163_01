package Project1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChangeJarPanelMain extends JPanel {

    private JMenuItem quitItem;
    private JMenuItem suspendItem;
    private JButton Master;
    JLabel MasterStatus;
    boolean mutateToggle = true;

    public ChangeJarPanelMain(JMenuItem quitItem, JMenuItem suspendItem) {
        JPanel panel = new JPanel();

        panel.add(new ChangeJarPanel());
        panel.add(new ChangeJarPanel());
        panel.add(new ChangeJarPanel());

        add(panel);

        Master = new JButton("Lock Jars");
        MasterStatus = new JLabel();
        add(Master);
        add(MasterStatus);

       /* MasterStatus.setText("******Jars are open******");*/

        this.quitItem = quitItem;
        this.suspendItem = suspendItem;



        quitItem.addActionListener(new Mylistener());
        suspendItem.addActionListener(new Mylistener());
        Master.addActionListener(new Mylistener());
    }

    private class Mylistener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == quitItem) {
                System.exit(1);
            }
            if (e.getSource() == suspendItem) {
                ChangeJar.mutate(suspendItem.isSelected());
            }

            if (e.getSource() == Master) {

                mutateToggle = !mutateToggle;
                ChangeJar.mutate(mutateToggle);
                if (mutateToggle)
                    MasterStatus.setText("******Jars are open******");
                else
                    MasterStatus.setText("******Jars are closed******");
            }
        }

    }
}