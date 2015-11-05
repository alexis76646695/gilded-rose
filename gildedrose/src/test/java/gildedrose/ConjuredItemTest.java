package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class ConjuredItemTest {

    private Item conjured;

    @Before
    public void setUp() {
        conjured = new ConjuredItem("Conjured Mana Cake", 3, 6);
    }

    @Test
    public void testUpdateQualityInValidDays() {
        int quality = conjured.getQuality();
        conjured.update();
        assertEquals(quality - 2, conjured.getQuality());
    }

    @Test
    public void testUpdateQualityInExpiredDays() {
        int quality = conjured.getQuality();
        conjured.setSellIn(-1);
        conjured.update();
        assertEquals(quality - 4, conjured.getQuality());
    }

    @Test
    public void testQualityNonNegative() {
        conjured.setQuality(0);
        conjured.update();
        assertEquals(0, conjured.getQuality());
    }

}
