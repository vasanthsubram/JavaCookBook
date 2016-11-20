package UI.basic;

import java.awt.Color;

import javax.swing.JLabel;

import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceManager;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;

public class FWK_SingleFrame_Resource_Manual extends SingleFrameApplication {
	JLabel label;
    ResourceMap resource;

    @Override
    protected void initialize(String[] args) {
        ApplicationContext ctxt = getContext();
        ResourceManager mgr = ctxt.getResourceManager();
        resource = mgr.getResourceMap(FWK_SingleFrame_Resource_Manual.class);
    }

    @Override
    protected void startup() {
        label = new JLabel();
        String helloText = (String) resource.getObject("helloLabel", String.class);
        // Or you can use the convenience methods that cast resources
        // to the type indicated by the method names:
        // resource.getString("helloLabel.text");
        // resource.getColor("backgroundcolor");
        // and so on.
        Color backgroundColor = resource.getColor("color");
        String title = resource.getString("title");
        label.setBackground(backgroundColor);
        label.setOpaque(true);
        getMainFrame().setTitle(title);
        label.setText(helloText);
        show(label);
    }
    
    public static void main(String[] args) {
        Application.launch(FWK_SingleFrame_Resource_Manual.class, args);
    }


}
