package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class BackstageItemTest {

    private Item backstageItem;

    @Before
    public void setUp() {
        backstageItem = new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    @Test
    public void testUpdateQualityMoreThan10Days() {
        int quality = backstageItem.getQuality();
        backstageItem.update();
        assertEquals(quality + 1, backstageItem.getQuality());
    }

    @Test
    public void testUpdateQualityBetween6And10Days() {
        backstageItem.setSellIn(10);
        while (backstageItem.getSellIn() > 5) {
            int quality = backstageItem.getQuality();
            backstageItem.update();
            assertEquals(quality + 2, backstageItem.getQuality());
        }
    }

    @Test
    public void testUpdateQualityBetween0And5Days() {
        backstageItem.setSellIn(5);
        while (backstageItem.getSellIn() >= 0) {
            int quality = backstageItem.getQuality();
            backstageItem.update();
            assertEquals(quality + 3, backstageItem.getQuality());
        }
    }

    @Test
    public void testUpdateQualityAfterConcert() {
        backstageItem.setSellIn(-1);
        backstageItem.update();
        assertEquals(0, backstageItem.getQuality());
    }

}
