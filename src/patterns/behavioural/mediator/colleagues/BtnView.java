package patterns.behavioural.mediator.colleagues;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import patterns.behavioural.mediator.Mediator;

//A concrete colleague
public class BtnView extends JButton implements Command {
 
    Mediator med;
 
    //colleagues donot know about each other 
    //each collegue only knows about the mediator
    public BtnView(ActionListener al, Mediator m) {
        super("View");
        addActionListener(al);
        med = m;
        med.registerView(this);
    }
 
    public void execute() {
        med.view();
    }
 
}
