package UI.basic;

import java.awt.Font;

import javax.swing.JLabel;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class FWK_SingleFrameApplication extends SingleFrameApplication {
    JLabel label;

    @Override
    protected void startup() {
        getMainFrame().setTitle("BasicSingleFrameApp");
        label = new JLabel("Hello, world!");
        label.setFont(new Font("SansSerif", Font.PLAIN, 22));
        show(label);
    }

    public static void main(String[] args) {
        Application.launch(FWK_SingleFrameApplication.class, args);
    }

}
