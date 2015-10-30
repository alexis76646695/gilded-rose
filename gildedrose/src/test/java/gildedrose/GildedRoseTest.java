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
        agedBrie = new AgedBrieItem("Aged Brie", 2, 0);
        backstagePasses = new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        conjured = new ConjuredItem("Conjured Mana Cake", 3, 6);
        normalItemElixir = new NormalItem("Elixir of the Mongoose", 5, 7);
        normalItemDextery = new NormalItem("+5 Dexterity Vest", 10, 20);
        sulfuras = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80);

        originalItems.add(agedBrie);
        originalItems.add(backstagePasses);
        originalItems.add(conjured);
        originalItems.add(normalItemDextery);
        originalItems.add(normalItemElixir);
        originalItems.add(sulfuras);

        //Fill Original Item values
        GildedRose.items = originalItems;
    }

    @Test
    public void testTheTruth() {
        assertTrue(true);
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

        dexteryQuality = normalItemDextery.getQuality();
        elixirQuality = normalItemElixir.getQuality();

        normalItemDextery.setSellIn(-1);
        normalItemElixir.setSellIn(-1);

        GildedRose.updateQuality();

        assertEquals(dexteryQuality - 2, normalItemDextery.getQuality());
        assertEquals(elixirQuality - 2, normalItemElixir.getQuality());

        normalItemDextery.setQuality(0);
        normalItemElixir.setQuality(0);

        GildedRose.updateQuality();

        assertEquals(0, normalItemDextery.getQuality());
        assertEquals(0, normalItemElixir.getQuality());
    }

    @Test
    public void testOriginalBehaviorAgedBrieItemUpdate() {
        int quality = agedBrie.getQuality();
        int sellIn = agedBrie.getSellIn();

        GildedRose.updateQuality();

        assertEquals(quality + 1, agedBrie.getQuality());
        assertEquals(sellIn - 1, agedBrie.getSellIn());

        quality = agedBrie.getQuality();
        GildedRose.updateQuality();
        assertEquals(quality + 1, agedBrie.getQuality());

        quality = agedBrie.getQuality();
        agedBrie.setSellIn(-1);
        GildedRose.updateQuality();
        assertEquals(quality + 2, agedBrie.getQuality());
    }

    @Test
    public void testOriginalBehaviorBackstagePassesItemUpdate() {
        int quality = backstagePasses.getQuality();
        int sellIn = backstagePasses.getSellIn();

        GildedRose.updateQuality();

        assertEquals(quality + 1, backstagePasses.getQuality());
        assertEquals(sellIn - 1, backstagePasses.getSellIn());

        backstagePasses.setSellIn(10);
        quality = backstagePasses.getQuality();
        sellIn = backstagePasses.getSellIn();
        GildedRose.updateQuality();
        assertEquals(quality + 2, backstagePasses.getQuality());
        assertEquals(sellIn - 1, backstagePasses.getSellIn());

        backstagePasses.setSellIn(5);
        quality = backstagePasses.getQuality();
        sellIn = backstagePasses.getSellIn();
        GildedRose.updateQuality();
        assertEquals(quality + 3, backstagePasses.getQuality());
        assertEquals(sellIn - 1, backstagePasses.getSellIn());

        backstagePasses.setSellIn(0);
        GildedRose.updateQuality();
        assertEquals(0, backstagePasses.getQuality());

        backstagePasses.setSellIn(-1);
        GildedRose.updateQuality();
        assertEquals(0, backstagePasses.getQuality());

    }

    @Test
    public void testOriginalBehaviorConjuredUpdate() {
        int quality = conjured.getQuality();
        int sellIn = conjured.getSellIn();

        GildedRose.updateQuality();

        assertEquals(quality - 1, conjured.getQuality());
        assertEquals(sellIn - 1, conjured.getSellIn());

        quality = conjured.getQuality();
        conjured.setSellIn(-1);

        GildedRose.updateQuality();

        assertEquals(quality - 2, conjured.getQuality());

        conjured.setQuality(0);
        GildedRose.updateQuality();
        assertEquals(0, conjured.getQuality());
    }

    @Test
    public void testOriginalBehaviorSulfurasUpdate() {
        int quality = sulfuras.getQuality();
        int sellIn = sulfuras.getSellIn();

        GildedRose.updateQuality();

        assertEquals(quality, sulfuras.getQuality());
        assertEquals(0, sulfuras.getSellIn());
    }

}
