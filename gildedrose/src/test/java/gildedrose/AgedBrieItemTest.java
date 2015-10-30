package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class AgedBrieItemTest {

    private Item agedBrie;

    @Before
    public void setUp() {
        agedBrie = new AgedBrieItem("Aged Brie", 2, 0);
    }

    @Test
    public void testUpdatedQuality() {
        int quality = agedBrie.getQuality();
        agedBrie.update();
        assertEquals(quality + 1, agedBrie.getQuality());
    }

    @Test
    public void testUpdatedQualityMoreThan50() {
        agedBrie.setQuality(50);
        agedBrie.update();
        assertEquals(50, agedBrie.getQuality());
    }

}
