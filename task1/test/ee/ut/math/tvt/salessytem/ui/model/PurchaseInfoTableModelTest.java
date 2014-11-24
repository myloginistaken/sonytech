import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseInfoTableModelTest extends PurchaseInfoTableModel{
	
	private StockItem stockItem;
	private SoldItem soldItem;

	@Before
	public void setUp() {
		StockItem stockItem = new StockItem((long) 1, "Item", "Item desctiption", 12.34, 22);
		SoldItem soldItem = new SoldItem(stockItem, 3);
	}
	
	@Test
	public void testAddItem() {
		PurchaseInfoTableModel purchaseInfoTableModel = new PurchaseInfoTableModel();
		purchaseInfoTableModel.addItem(soldItem);
		purchaseInfoTableModel.addItem(soldItem);
		SoldItem soldItem1 = purchaseInfoTableModel.getItemById(stockItem.getId());
		assertEquals(soldItem,soldItem1);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetColumnValueWithIllegalArgument() {			
    	getColumnValue(soldItem, 7000);	
	}
}