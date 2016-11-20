package patterns.behavioural.mediator.colleagues;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import patterns.behavioural.mediator.Mediator;

//A concrete colleague
public class BtnSearch extends JButton implements Command {
 
    Mediator med;
 
    //colleagues donot know about each other 
    //each collegue only knows about the mediator
    public BtnSearch(ActionListener al, Mediator m) {
        super("Search");
        addActionListener(al);
        med = m;
        med.registerSearch(this);
    }
 
    public void execute() {
        med.search();
    }
 
}
