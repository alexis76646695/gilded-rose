package edu.gildedrose;

/**
 * Created by Luis Roberto Perez on 19/11/2016.
 */
public class IncreaseQuality implements Strategy {
    public void updateQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
}
