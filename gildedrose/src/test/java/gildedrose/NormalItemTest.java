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
public class NormalItemTest {

    private Item normalItem;

    @Before
    public void setUp() {
        normalItem = new Item("Normal Item", 5, 20);
    }

}
