package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class NormalItemTest {

    private Item normalItem;

    @Before
    public void setUp() {
        normalItem = new NormalItem("Normal Item", 5, 20);
    }

    @Test
    public void testUpdateQualityInValidDays() {
        int quality = normalItem.getQuality();
        normalItem.update();
        assertEquals(quality - 1, normalItem.getQuality());
    }

    @Test
    public void testUpdateQualityInExpiredDays() {
        int quality = normalItem.getQuality();
        normalItem.setSellIn(-1);
        normalItem.update();
        assertEquals(quality - 2, normalItem.getQuality());
    }

    @Test
    public void testQualityNonNegative() {
        normalItem.setQuality(0);
        normalItem.update();
        assertEquals(0, normalItem.getQuality());
    }
}
