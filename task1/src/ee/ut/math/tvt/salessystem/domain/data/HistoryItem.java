package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sander
 */

@Entity
@Table(name = "HISTORYITEM")
public class HistoryItem implements Cloneable, DisplayableItem{
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "total_price")
    private double sum;
	
	@Column(name = "datetime")
    private String datetime;
	
	@OneToMany(mappedBy = "sale")
    private List<SoldItem> details;
    
    public HistoryItem(String date, List<SoldItem> goods) {
        this.sum = getTotalSum();
        this.datetime = date;
        this.details = goods;
    }
    
    public HistoryItem(String date) {
        this.sum = 0.0;
        this.datetime = date;
        this.details = new ArrayList<SoldItem>();
    }
    
    public HistoryItem() {
    }

    public String toString() {
        return sum + " " + datetime + " " + details.toString();
    }
    
    public double getSum() {
        //this.sum = sum;
        return sum;
    }
    
    public List<SoldItem> getDetails() {
        return details;
    }

    public String getDateTime() {
        return datetime;
    }

    public void setDateTime(String date) {
        this.datetime = date;
    }

    public Long getId() {
		return id;
	}
    
	public String getName() {
		return getDateTime();
	}
    
	public void addOrderDetail(SoldItem soldItem) {
		soldItem.setSale(this);
		details.add(soldItem);
		sum = getTotalSum();
	}
	
	private double getTotalSum() {
		
		if (getDetails() == null) {
			return 0;
		}
		
		double totalSum = 0;
		
		Iterator<SoldItem> it = getDetails().iterator();
		
		while (it.hasNext()) {
			totalSum += it.next().getSum();
		}
		
		return totalSum;
	}
	
	public static String timeDate() {

		Date now = new Date();
		SimpleDateFormat upDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
		String dateTime = upDate.format(now);
		return dateTime;
	}
}
