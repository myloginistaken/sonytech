import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.List;

import ee.ut.math.tvt.salessystem.ui.model.HistoryInfoTableModel;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;

public class HistoryInfoTableModelTest {

	private HistoryInfoTableModel historyInfoTableModel;
	private static StockItem stockItem1;
	private static StockItem stockItem2;
	private static StockItem stockItem3;
	private static HistoryItem historyItem;
	private static HistoryItem historyItem2;
	private static List<SoldItem> soldItems = new ArrayList<SoldItem>();
	private static List<SoldItem> soldItems2 = new ArrayList<SoldItem>();
	
	
	@Before
	public void setUp() {
		historyInfoTableModel = new HistoryInfoTableModel();
		stockItem1 = new StockItem((long)100,"Item 1","Item description",10.0,100);
		stockItem2 = new StockItem((long)101,"Item 2","Item description",5.0,50);
		stockItem3 = new StockItem((long)102,"Item 3","Item description",15.0,30);
		soldItems.add(new SoldItem(stockItem1,10));
		soldItems.add(new SoldItem(stockItem2,30));
		soldItems2.add(new SoldItem(stockItem3,10));
		soldItems2.add(new SoldItem(stockItem1,15));
	}
	
	@Test
	public void testAddPurchaseToHistory() {
		historyInfoTableModel = new HistoryInfoTableModel();
		HistoryItem historyItem = new HistoryItem("2014.11.24 22:22:22", soldItems);
		historyInfoTableModel.addItem(historyItem);
		assertEquals(1,historyInfoTableModel.getRowCount());
	}
	
	@Test
	public void testAddPurchasesToHistory() {
		historyInfoTableModel = new HistoryInfoTableModel();
		historyItem = new HistoryItem("2014.11.24 22:23:22", soldItems);
		historyItem2 = new HistoryItem("2014.11.24 22:24:22", soldItems2);
		historyInfoTableModel.addItem(historyItem);
		historyInfoTableModel.addItem(historyItem2);
		assertEquals(2,historyInfoTableModel.getRowCount());
	}
	
}