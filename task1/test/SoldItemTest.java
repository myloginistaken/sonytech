import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class SoldItemTest {
	private StockItem stockItem;
	private SoldItem soldItem;

	@Before
	public void setUp() throws Exception {
		stockItem = new StockItem((long) 100, "Item", "Item sDescription", 10.0,10);
		soldItem = new SoldItem(stockItem, 10);
	}
	
	@Test
	public void testGetSum() {
		assertEquals(100.0,soldItem.getTotal(),0.0001);
	}

	@Test
	public void testGetSumWithZeroQuantity() {
		soldItem = new SoldItem(stockItem, 0);
		assertEquals(0.0,soldItem.getTotal(),0.0001);
	}
}