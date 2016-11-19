package edu.gildedrose;

/**
 * Created by Luis Roberto Perez on 19/11/2016.
 */
public class MixerQuality implements Strategy {
    public void updateQuality(Item item) {
        if (item.getSellIn() == 0) {
            item.setQuality(0);
        } else {
            int delta = (item.getSellIn() <= 10 && item.getSellIn() > 5)
                    ? 2 : (item.getSellIn() <= 5 && item.getSellIn() > 0)
                    ? 3 : 0;

            item.setQuality(item.getQuality() + delta);
        }
    }
}
