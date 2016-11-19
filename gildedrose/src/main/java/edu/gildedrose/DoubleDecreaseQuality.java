package edu.gildedrose;

/**
 * Created by Luis Roberto Perez on 19/11/2016.
 */
public class DoubleDecreaseQuality implements Strategy {
    public void updateQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 2);
        }
    }
}
