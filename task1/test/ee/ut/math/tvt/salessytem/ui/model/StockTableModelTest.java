import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import java.util.NoSuchElementException;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {

	private StockTableModel stockTableModel;
	private static StockItem stockItem1;
	private static StockItem stockItem2;
	private static StockItem stockItem3;
	
	@Before
	public void setUp() throws Exception {
		stockTableModel = new StockTableModel();
		stockItem1 = new StockItem((long) 100, "Item 1", "Item Description", 10.0, 5);
		stockItem2 = new StockItem((long) 101, "Item 2", "Item Description", 20.0, 10);
		stockItem3 = new StockItem((long) 102, "Item 3", "Item Description", 25.0, 15);
	}
	
	@Test
	public void testValidateNameUniqueness() {
		long items = (long) stockTableModel.getRowCount();
		
		stockTableModel.addItem(stockItem1);
		assertEquals((long) 5, stockTableModel.getItemById(100).getQuantity());
		
		stockTableModel.addItem(stockItem1);
		assertEquals((long) 10, stockTableModel.getItemById(100).getQuantity());
		
		assertEquals(items+1, (long)stockTableModel.getRowCount());
	}
	
	@Test
	public void testHasEnoughInStock() {
		stockTableModel.addItem(stockItem1);
		assertTrue(stockTableModel.getItemById(100).getQuantity()>=stockItem1.getQuantity());
	}
	
	@Test
	public void testGetItemByIdWhenItemExists() {
		stockTableModel.addItem(stockItem2);
		assertEquals(stockItem2,stockTableModel.getItemById(101));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() {
		stockTableModel.addItem(stockItem3);
		stockTableModel.getItemById(5);
	}
	
}