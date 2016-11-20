package UI.basic;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jdesktop.application.Application;

public class FWK_Application extends Application {
    protected JFrame mainFrame;
    private JLabel label;


    @Override
    protected void startup() {
        mainFrame = new JFrame("BasicFrameworkApp");
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mainFrame.setVisible(false);
                exit();
            }
        });
        label = new JLabel("Hello, world!");
        mainFrame.add(label);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Application.launch(FWK_Application.class, args);
    }
}
