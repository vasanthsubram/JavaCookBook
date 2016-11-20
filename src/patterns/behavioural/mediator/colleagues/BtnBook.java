package patterns.behavioural.mediator.colleagues;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import patterns.behavioural.mediator.Mediator;

//A concrete colleague
public class BtnBook extends JButton implements Command {
 
    Mediator med;
 
    //colleagues donot know about each other 
    //each collegue only knows about the mediator
    public BtnBook(ActionListener al, Mediator m) {
        super("Book");
        addActionListener(al);
        med = m;
        med.registerBook(this);
    }
 
    public void execute() {
        med.book();
    }
 
}
