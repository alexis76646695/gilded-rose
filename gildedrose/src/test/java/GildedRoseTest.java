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

	// items.add(new Item("+5 Dexterity Vest", 10, 20));

	@Test
	public void testNormalItem(){
		GildedRose.items = new ArrayList<Item>(0);
		Item normal = new Item("+5 Dexterity Vest", 10, 20);

		GildedRose.items.add(normal);
		GildedRose.updateQuality();

		assertEquals(19, normal.quality);
	}

	@Test
	public void testNormalItemSoldIn(){
		GildedRose.items = new ArrayList<Item>(0);
		Item normal = new Item("+5 Dexterity Vest", 0, 20);

		GildedRose.items.add(normal);
		GildedRose.updateQuality();

		assertEquals(18, normal.quality);
	}

	@Test
	public void testQualityIsNeverNegative(){
		GildedRose.items = new ArrayList<Item>(0);
		Item normal = new Item("+5 Dexterity Vest", 0, 0);
		GildedRose.items.add(normal);
		GildedRose.updateQuality();
		assertEquals(0, normal.quality);
	}

	@Test
	public void testAgedBrieIncreaseQuality(){
		GildedRose.items = new ArrayList<Item>(0);
		Item agedBrie = new Item("Aged Brie", 2, 0);
		GildedRose.items.add(agedBrie);
		GildedRose.updateQuality();
		assertEquals(1, agedBrie.quality);
	}

	@Test
	public void testQualityIsNeverMoreThan50(){
		GildedRose.items = new ArrayList<Item>(0);
		Item agedBrie = new Item("Aged Brie", 2, 50);
		GildedRose.items.add(agedBrie);
		GildedRose.updateQuality();
		assertEquals(50, agedBrie.quality);
	}

	@Test
	public void testSulfurasNeverChanges(){
		GildedRose.items = new ArrayList<Item>(0);
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 2, 50);
		GildedRose.items.add(sulfuras);
		GildedRose.updateQuality();
		assertEquals(50, sulfuras.quality);
	}

	@Test
	public void testBackstagePassesIncreaseQuality(){
		GildedRose.items = new ArrayList<Item>(0);
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		GildedRose.items.add(backstagePasses);
		GildedRose.updateQuality();
		assertEquals(21, backstagePasses.quality);
	}

	@Test
	public void testBackstagePassesIncreaseQualityForTen(){
		GildedRose.items = new ArrayList<Item>(0);
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		GildedRose.items.add(backstagePasses);
		GildedRose.updateQuality();
		assertEquals(22, backstagePasses.quality);
	}

	@Test
	public void testBackstagePassesIncreaseQualityForFive(){
		GildedRose.items = new ArrayList<Item>(0);
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20);
		GildedRose.items.add(backstagePasses);
		GildedRose.updateQuality();
		assertEquals(23, backstagePasses.quality);
	}

	@Test
	public void testBackstagePassesIncreaseQualityForSoldIn(){
		GildedRose.items = new ArrayList<Item>(0);
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		GildedRose.items.add(backstagePasses);
		GildedRose.updateQuality();
		assertEquals(0, backstagePasses.quality);
	}

	@Test
	public void testConjuredItemNonNegative() {
		GildedRose.items = new ArrayList<Item>(0);
		Item conjured = new Item("Conjured Mana Cake", 3, 0);
		GildedRose.items.add(conjured);
		GildedRose.updateQuality();

		assertEquals(0, conjured.quality);
	}

	@Test
	public void testConjuredItemNonNegativeFor1() {
		GildedRose.items = new ArrayList<Item>(0);
		Item conjured = new Item("Conjured Mana Cake", 3, 1);
		GildedRose.items.add(conjured);
		GildedRose.updateQuality();

		assertEquals(0, conjured.quality);
	}

	@Test
	public void testConjuredItemSoldIn() {
		GildedRose.items = new ArrayList<Item>(0);
		Item conjured = new Item("Conjured Mana Cake", 0, 10);
		GildedRose.items.add(conjured);
		GildedRose.updateQuality();

		assertEquals(6, conjured.quality);
	}
}
