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
        int elixirQuality = normalItemElixir.getQuality();

        GildedRose.updateQuality();

        assertEquals(dexteryQuality - 1, normalItemDextery.getQuality());

        assertEquals(elixirQuality - 1, normalItemElixir.getQuality());

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

        GildedRose.updateQuality();

        assertEquals(quality + 1, agedBrie.getQuality());

        quality = agedBrie.getQuality();
        GildedRose.updateQuality();
        assertEquals(quality + 1, agedBrie.getQuality());

        quality = agedBrie.getQuality();
        agedBrie.setSellIn(-1);
        GildedRose.updateQuality();
        assertEquals(quality + 1, agedBrie.getQuality());
    }

    @Test
    public void testOriginalBehaviorBackstagePassesItemUpdate() {
        int quality = backstagePasses.getQuality();

        GildedRose.updateQuality();

        assertEquals(quality + 1, backstagePasses.getQuality());

        backstagePasses.setSellIn(10);
        quality = backstagePasses.getQuality();
        GildedRose.updateQuality();
        assertEquals(quality + 2, backstagePasses.getQuality());

        backstagePasses.setSellIn(5);
        quality = backstagePasses.getQuality();
        GildedRose.updateQuality();
        assertEquals(quality + 3, backstagePasses.getQuality());

        backstagePasses.setSellIn(0);
        quality = backstagePasses.getQuality();
        GildedRose.updateQuality();
        assertEquals(quality + 3, backstagePasses.getQuality());

        backstagePasses.setSellIn(-1);
        GildedRose.updateQuality();
        assertEquals(0, backstagePasses.getQuality());
    }

    @Test
    public void testOriginalBehaviorConjuredUpdate() {
        int quality = conjured.getQuality();

        GildedRose.updateQuality();

        assertEquals(quality - 2, conjured.getQuality());

        quality = conjured.getQuality();
        conjured.setSellIn(-1);

        GildedRose.updateQuality();

        assertEquals(quality - 4, conjured.getQuality());

        conjured.setQuality(0);
        GildedRose.updateQuality();
        assertEquals(0, conjured.getQuality());
    }

    @Test
    public void testOriginalBehaviorSulfurasUpdate() {
        int quality = sulfuras.getQuality();

        GildedRose.updateQuality();
        GildedRose.updateQuality();

        assertEquals(quality, sulfuras.getQuality());
        assertEquals(0, sulfuras.getSellIn());
    }

}
