package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sander
 */

public class HistoryItem implements Cloneable, DisplayableItem{
    
    private double sum;
    private String time;
    private String date;
    private List<SoldItem> details;
    
    public SimpleDateFormat simpleTimeFormat;
    public SimpleDateFormat simpleDateFormat;
    
    public HistoryItem(double sum, Date date, List<SoldItem> goods) {
        this.simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        this.simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
        this.sum = sum;
        this.time = simpleTimeFormat.format(date);
        this.date = simpleDateFormat.format(date);
        this.details = goods;
    }
    
    public HistoryItem(double sum, Date date) {
        this.simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        this.simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
        this.sum = sum;
        this.time = simpleTimeFormat.format(date);
        this.date = simpleDateFormat.format(date);
        //this.item = goods;
    }

    public String toString() {
        return sum + " " + time + " " + date + " " + details.toString();
    }
    
    public double getSum() {
        //this.sum = sum;
        return sum;
    }
    
    public String getTime() {
        return time;
    }
    
    public List<SoldItem> getDetails() {
        return details;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
