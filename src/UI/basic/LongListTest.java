package UI.basic;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LongListTest extends JFrame implements ListSelectionListener {
  JLabel label = new JLabel();

  public LongListTest() {
    setTitle("LongListTest");
    setSize(400, 300);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    List<Purchase> list = new ArrayList();
   Purchase p1=new Purchase(200.0, Calendar.getInstance().getTime(), "Silk");
   Purchase p2=new Purchase(90.0, Calendar.getInstance().getTime(), "Cotton");
    list.add(p1);
     list.add(p2);
     
    JList wordList = new JList(new PurchaseModel(list));
    wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//    wordList.setFixedCellWidth(50);
//    wordList.setFixedCellHeight(15);

    JScrollPane scrollPane = new JScrollPane(wordList);

    JPanel p = new JPanel();
    p.add(scrollPane);
    wordList.addListSelectionListener(this);

    getContentPane().add(p, "Center");
    getContentPane().add(label, "South");
  }

  public void valueChanged(ListSelectionEvent evt) {
    JList source = (JList) evt.getSource();
    String word = (String) source.getSelectedValue();
   // source.getModel().
    label.setText(word);
  }

  public static void main(String[] args) {
    JFrame frame = new LongListTest();
   // frame.pack();
    frame.setVisible(true);
  }
}



class PurchaseModel implements ListModel{

    List<Purchase> list;
    
    PurchaseModel (List<Purchase> list){
        this.list=list;
    }
    public int getSize() {
        return list.size();
    }

    public Object getElementAt(int index) {
        return list.get(index).toString();
    }

    public void addListDataListener(ListDataListener l) {
        
    }

    public void removeListDataListener(ListDataListener l) {
       
    }
    
}


class Purchase {

    double amount;
    Date date;
    String itemType;

    public Purchase(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

     public Purchase(double amount, Date date, String itemType) {
        this.amount = amount;
        this.date = date;
        this.itemType=itemType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String toString(){
        return "purchase [ amount = "+ amount + ", Date = "+ date + ", type = "+ itemType+ " ] ";
    }
}