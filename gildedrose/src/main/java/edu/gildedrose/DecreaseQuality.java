package edu.gildedrose;

/**
 * Created by Luis Roberto Perez on 19/11/2016.
 */
public class DecreaseQuality implements Strategy {
    public void updateQuality(Item item) {
        int delta = item.getSellIn() > 0 ? 1 : 2;
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - delta);
        }
    }
}
