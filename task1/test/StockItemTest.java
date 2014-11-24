
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	private StockItem stockItem;
	
	@Before
	public void setUp() throws Exception {
		stockItem = new StockItem((long) 100, "Stock Item", "Description", 12.99, 9000);
	}
	
	@Test
	public void testClone() {
		StockItem cloneItem = (StockItem) stockItem.clone();

		assertEquals("Stock Item",cloneItem.getName());
		assertEquals("Description",cloneItem.getDescription());
		assertEquals(9000,cloneItem.getQuantity());
		assertEquals(new Long(100),cloneItem.getId());
		assertEquals(12.99d,cloneItem.getPrice(),0.001d);
	}
	
	@Test
	public void testGetColumn() {
		assertEquals((long) 100, stockItem.getColumn(0));
        assertEquals("Stock Item",stockItem.getColumn(1));
        assertEquals( 12.99,stockItem.getColumn(2));
        assertEquals(9000,stockItem.getColumn(3));
	}
	
	@Test(expected = RuntimeException.class)
    public void testException() {
            stockItem.getColumn(5);
    }
	
}