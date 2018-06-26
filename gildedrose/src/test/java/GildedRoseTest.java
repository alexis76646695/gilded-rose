import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}

	@Test
	public void testConjuredItem() {
		GildedRose.items = new ArrayList<Item>(0);
		Item conjured = new Item("Conjured Mana Cake", 3, 6);
		GildedRose.items.add(conjured);
		GildedRose.updateQuality();

		assertEquals(4, conjured.quality);
	}
}
