package networking.urls;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ImageFromURL extends javax.swing.JFrame {

    public ImageFromURL() {
        JLabel a = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        URL url=null;
        try {
            url = new URL("http://www.abclegal.com/images/abclegal/abc-section-default.jpg");
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }

        java.awt.Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(url);
        a.setIcon(new javax.swing.ImageIcon(image));
        add(a);
        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageFromURL().setVisible(true);
            }
        });
    }
}
