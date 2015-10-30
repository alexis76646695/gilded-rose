package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class SulfurasItemTest {

    private Item sulfuras;

    @Before
    public void setUp() {
        sulfuras = new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80);
    }

    @Test
    public void testUpdate() {
        sulfuras.update();
        sulfuras.update();

        assertEquals(50, sulfuras.getQuality());
        assertEquals(0, sulfuras.getSellIn());
    }

}
