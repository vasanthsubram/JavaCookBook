package patterns.behavioural.mediator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import patterns.behavioural.mediator.colleagues.BtnBook;
import patterns.behavioural.mediator.colleagues.BtnSearch;
import patterns.behavioural.mediator.colleagues.BtnView;
import patterns.behavioural.mediator.colleagues.Command;
import patterns.behavioural.mediator.colleagues.LblDisplay;

 
public class MediatorDemo extends JFrame implements ActionListener {
 
    Mediator med = new Mediator();
 
    MediatorDemo() {
        JPanel p = new JPanel();
        p.add(new BtnView(this, med));
        p.add(new BtnBook(this, med));
        p.add(new BtnSearch(this, med));
        getContentPane().add(new LblDisplay(med), "North");
        getContentPane().add(p, "South");
        setSize(400, 200);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae) {
        Command comd = (Command) ae.getSource();
        comd.execute();
    }
 
    public static void main(String[] args) {
        new MediatorDemo();
    }
}
