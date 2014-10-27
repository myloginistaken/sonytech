/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sander
 */
public class HistoryItem implements Cloneable, DisplayableItem{
    
    private double sum;
    private String time;
    private String date;
    
    public SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm");  
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
    
    public HistoryItem(double sum, Date date) {
        this.sum = sum;
        this.time = simpleTimeFormat.format(date);
        this.date = simpleDateFormat.format(date);
    }

    public double getSum() {
        return sum;
    }
    
    public void setSum(Double sum){
        this.sum = sum;
    }
    
    public String getTime() {
        return time;
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
