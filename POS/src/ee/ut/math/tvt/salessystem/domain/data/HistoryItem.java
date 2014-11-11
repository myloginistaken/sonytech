/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author Sander
 */

@Entity
@Table(name = "HISTORYITEM")
public class HistoryItem implements Cloneable, DisplayableItem{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "total_price")
    private double sum;
    //private String time;
    @Column(name = "datetime")
    private String dateTime;
    
    @OneToMany(mappedBy = "sale")
    private List<SoldItem> details;
    
    //public SimpleDateFormat simpleTimeFormat;  
    @Column(name = "datetime")
    public SimpleDateFormat simpleDateFormat;
    
    public HistoryItem(double sum, Date date, List<SoldItem> goods) {
        this.simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        //this.simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
        this.sum = sum;
        //this.time = simpleTimeFormat.format(date);
        this.dateTime = simpleDateFormat.format(date);
        this.details = goods;
    }
    
    public HistoryItem(double sum, Date date) {
        this.simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        //this.simpleTimeFormat = new SimpleDateFormat("hh:mm:ss");
        this.sum = sum;
        //this.time = simpleTimeFormat.format(date);
        this.dateTime = simpleDateFormat.format(date);
        //this.item = goods;
    }

    public String toString() {
        return sum + " " + String.format("hh:mm:ss", dateTime) + " " + String.format("yyyy.MM.dd", dateTime) + " " + details.toString();
    }
    
    public double getSum() {
        return sum;
    }
    
    public void setSum(Double sum){
        this.sum = sum;
    }
    
    //public String getTime() {
      //  return time;
    //}
    
    public List getDetails() {
        return details;
    }
    
    //public void setTime(String time) {
      //  this.time = time;
    //}

    public String getDate() {
        return dateTime;
    }

    public void setDate(String date) {
        this.dateTime = date;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
