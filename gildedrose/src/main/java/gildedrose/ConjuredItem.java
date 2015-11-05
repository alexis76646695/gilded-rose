package gildedrose;

/**
 *
 * @author roberto
 */
public class ConjuredItem extends Item {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void fixQuality() {
        quality = (sellIn < 0) ? quality - 4 : quality - 2;
    }

}
