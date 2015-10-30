/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author roberto
 */
public class ItemTest {

    private Item normalItem;

    @Before
    public void setUp() {
        normalItem = new Item("Normal Item", 5, 20);
    }

    /*
    @Test
    public void testDownQualityLessThanZero() {
        normalItem.setQuality(-5);
        assertEquals(0, normalItem.getQuality());
    }

    @Test
    public void testSellInDaysDontBeNegative() {
        //Update 10 times
        for (int i = 0; i < 10; i++) {
            normalItem.update();
            assertTrue("The sellIn days value cannot be negative", normalItem.getSellIn() >= 0);
        }
    }

    @Test
    public void testUpdateSellInDays() {
        for (int sellInDays = 5; sellInDays > 0; sellInDays--) {
            assertEquals(normalItem.getSellIn(), sellInDays);
            normalItem.update();
        }
    }
    */
}
