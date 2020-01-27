package Project1;
import javax.swing.*;
import java.awt.*;

public class ChangeJarGUI {
    public static void main(String[] arg){

        JMenu fileMenu;
        JMenuItem quitItem;
        JCheckBoxMenuItem suspendItem;
        JMenuBar menus;

        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        suspendItem = new JCheckBoxMenuItem ("Suspend");
        fileMenu.add(suspendItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();

        menus.add(fileMenu);

        JFrame gui = new JFrame("Change Jar");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChangeJarPanelMain panel = new ChangeJarPanelMain(quitItem, suspendItem);
        gui.getContentPane().add(panel);

        gui.setMinimumSize(new Dimension(600,450));
        gui.setMaximumSize(new Dimension(800,500));
        gui.revalidate();
        gui.setJMenuBar(menus);
        gui.pack();
        gui.setVisible(true);
    }
}