import static org.junit.Assert.*;

import edu.gildedrose.GildedRose;
import edu.gildedrose.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Luis Roberto Perez on 19/11/2016.
 */
public class GildedRoseTest {

	private GildedRose gildedRose;

	@Before
	public void setUp() {
		this.gildedRose.items = new ArrayList<Item>();
	}

	@Test
	public void testDecreaseQualityNormalItem() {
		Item normal = new Item("Normal", 5, 10);
		gildedRose.items.add(normal);

		gildedRose.updateQuality();
		Assert.assertEquals(9, normal.getQuality());
	}

	@Test
	public void testDecreaseDoubleQualityNormalItem() {
		Item normal = new Item("Normal", 0, 10);
		gildedRose.items.add(normal);

		gildedRose.updateQuality();
		Assert.assertEquals(8, normal.getQuality());
	}

	@Test
	public void testQualityItemIsNeverNegative() {
		Item normal = new Item("Normal", 5, 0);
		gildedRose.items.add(normal);

		gildedRose.updateQuality();
		gildedRose.updateQuality();
		gildedRose.updateQuality();

		Assert.assertEquals(0, normal.getQuality());
	}

	@Test
	public void testIncreaseQualityAgedBrieItem() {
		Item agedBrie = new Item("Aged Brie", 2, 0);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();
		Assert.assertEquals(1, agedBrie.getQuality());
	}

	@Test
	public void testQualityNeverMoreThanFifty() {
		Item agedBrie = new Item("Aged Brie", 5, 50);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();
		Assert.assertEquals(50, agedBrie.getQuality());
	}

	@Test
	public void testQualityNeverChangeForLegendaryItems(){
		Item sulfuras = new Item("Sulfuras, Hand of Ragnaros",0 , 80);
		gildedRose.items.add(sulfuras);

		gildedRose.updateQuality();
		Assert.assertEquals(80, sulfuras.getQuality());
	}
	@Test
	public void testBackstagePassesUpdateBehaviorWhenTenDaysOrLess(){
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		gildedRose.items.add(backstagePasses);

		gildedRose.updateQuality();
		Assert.assertEquals(22, backstagePasses.getQuality());
	}

	@Test
	public void testBackstagePassesUpdateBehaviorWhenFiveDaysOrLess(){
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		gildedRose.items.add(backstagePasses);

		gildedRose.updateQuality();
		Assert.assertEquals(23, backstagePasses.getQuality());
	}


	@Test
	public void testBackstagePassesUpdateBehaviorWhenZeroDays(){
		Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		gildedRose.items.add(backstagePasses);

		gildedRose.updateQuality();
		Assert.assertEquals(0, backstagePasses.getQuality());
	}

	@Test
	public void testConjuredUpdateBehavior(){
		Item conjured = new Item("Conjured Mana Cake", 3, 6);
		gildedRose.items.add(conjured);

		gildedRose.updateQuality();
		Assert.assertEquals(4, conjured.getQuality());
	}
}