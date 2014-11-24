import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class HistoryItemTest {
	
	private PurchaseInfoTableModel purchaseModel;
	
	@Before
	public void setUp() {
		purchaseModel = new PurchaseInfoTableModel();
	}
	
	@Test
	public void testAddSoldItem() {
		SoldItem soldItem1 = new SoldItem (new StockItem ((long) 100, "Item 1", "Item description", 10.0, 5),1);
		purchaseModel.addItem(soldItem1);
		assertEquals(1, purchaseModel.getRowCount());
		assertEquals((long)100,purchaseModel.getValueAt(0,0));
		assertEquals("Item 1", purchaseModel.getValueAt(0, 1));
		assertEquals(10.0, purchaseModel.getValueAt(0, 2));                       
        assertEquals(1, purchaseModel.getValueAt(0, 3));      
        assertEquals(10.0 , purchaseModel.getValueAt(0, 4));
	}
    
    @Test
    public void testGetSumWithNoItems() {
		HistoryItem historyItem = new HistoryItem();
    	assertEquals(0.0, historyItem.getTotalPrice(), 0.0001);
    }

    @Test
    public void testGetSumWithOneItem() {
    	StockItem stockItem = new StockItem((long) 1,"Item","Item description",333.5, 40);
    	SoldItem soldItem = new SoldItem(stockItem,4);
    	List<SoldItem> order = Arrays.asList(soldItem);
		HistoryItem historyItem = new HistoryItem("2014.11.24 22:22:22", order);
    	assertEquals(historyItem.getTotalPrice(),stockItem.getPrice()*soldItem.getQuantity(), 0.0001);
    }
    
    @Test
    public void testGetSumWithMultipleItems() {
		StockItem stockItem1 = new StockItem((long) 1,"Item 1","Item description",10, 5);
    	StockItem stockItem2 = new StockItem((long) 2,"Item 2","Item description",20, 6);
    	StockItem stockItem3 = new StockItem((long) 3,"Item 3","Item description",30, 7);
    	StockItem stockItem4 = new StockItem((long) 4,"Item 4","Item description",30, 7);
    	
    	SoldItem soldItem1 = new SoldItem(stockItem1,4);
    	SoldItem soldItem2 = new SoldItem(stockItem2,3);
    	SoldItem soldItem3 = new SoldItem(stockItem3,2);  
    	SoldItem soldItem4 = new SoldItem(stockItem4,1); 
    	
    	List<SoldItem> order = Arrays.asList(soldItem1, soldItem2, soldItem3, soldItem4);
		HistoryItem historyItem = new HistoryItem("2014.11.24 22:22:22", order);
		double result = stockItem1.getPrice()*soldItem1.getQuantity()+stockItem2.getPrice()*soldItem2.getQuantity()+stockItem3.getPrice()*soldItem3.getQuantity()+stockItem4.getPrice()*soldItem4.getQuantity();
    	
		assertEquals(historyItem.getTotalPrice(),result, 0.0001);
    }
}