package patterns.behavioural.mediator;

import patterns.behavioural.mediator.colleagues.BtnBook;
import patterns.behavioural.mediator.colleagues.BtnSearch;
import patterns.behavioural.mediator.colleagues.BtnView;
import patterns.behavioural.mediator.colleagues.LblDisplay;


public class Mediator {
    //Mediator know all the collegues
	BtnView btnView;
    BtnSearch btnSearch;
    BtnBook btnBook;
    LblDisplay show;
 
    
    public void registerView(BtnView v) {
        btnView = v;
    }
 
    public void registerSearch(BtnSearch s) {
        btnSearch = s;
    }
 
    public void registerBook(BtnBook b) {
        btnBook = b;
    }
 
    public void registerDisplay(LblDisplay d) {
        show = d;
    }
 
    /*
     * mediator encapsulates the communication between colleagues
     * 
     */
    public void book() {
        btnBook.setEnabled(false);
        btnView.setEnabled(true);
        btnSearch.setEnabled(true);
        show.setText("booking...");
    }
 
    public void view() {
        btnView.setEnabled(false);
        btnSearch.setEnabled(true);
        btnBook.setEnabled(true);
        show.setText("viewing...");
    }
 
    public void search() {
        btnSearch.setEnabled(false);
        btnView.setEnabled(true);
        btnBook.setEnabled(true);
        show.setText("searching...");
    }
 
}
