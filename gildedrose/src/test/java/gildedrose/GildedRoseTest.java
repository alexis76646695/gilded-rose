package gildedrose;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class GildedRoseTest {

    private Item normalItemElixir;
    private Item normalItemDextery;
    private Item agedBrie;
    private Item sulfuras;
    private Item backstagePasses;
    private Item conjured;

    private List<Item> originalItems = new ArrayList<>();

    @Before
    public void setUp() {
        normalItemElixir = new Item("Elixir of the Mongoose", 5, 7);
        normalItemDextery = new Item("+5 Dexterity Vest", 10, 20);
        agedBrie = new Item("Aged Brie", 2, 0);
        sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        conjured = new Item("Conjured Mana Cake", 3, 6);

        originalItems.add(agedBrie);
        originalItems.add(sulfuras);
        originalItems.add(backstagePasses);
        originalItems.add(conjured);
        originalItems.add(normalItemDextery);
        originalItems.add(normalItemElixir);

        //Fill Original Item values
        GildedRose.items = originalItems;
    }

    @Test
    public void testTheTruth() {
        assertTrue(true);
    }

    @Test
    public void testDownQualityLessThanZero() {
        normalItemElixir.setQuality(-5);
        assertEquals(0, normalItemElixir.getQuality());
    }

    @Test
    public void testSellInDaysDontBeNegative() {
        //Update 10 times
        for (int i = 0; i < 10; i++) {
            normalItemElixir.update();
            assertTrue("The sellIn days value cannot be negative", normalItemElixir.getSellIn() >= 0);
        }
    }

    @Test
    public void testUpdateSellInDays() {
        for (int sellInDays = 5; sellInDays > 0; sellInDays--) {
            assertEquals(normalItemElixir.getSellIn(), sellInDays);
            normalItemElixir.update();
        }
    }

    @Test
    public void testOriginalBehaviorNormalItemsUpdate() {
        int dexteryQuality = normalItemDextery.getQuality();
        int dexterySellIn = normalItemDextery.getSellIn();
        int elixirQuality = normalItemElixir.getQuality();
        int elixirSellIn = normalItemElixir.getSellIn();

        GildedRose.updateQuality();

        assertEquals(dexteryQuality - 1, normalItemDextery.getQuality());
        assertEquals(dexterySellIn - 1, normalItemDextery.getSellIn());

        assertEquals(elixirQuality - 1, normalItemElixir.getQuality());
        assertEquals(elixirSellIn - 1, normalItemElixir.getSellIn());
    }
}
