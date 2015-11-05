package gildedrose;

/**
 *
 * @author roberto
 */
public class NormalItem extends Item {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void fixQuality() {
        quality = (sellIn < 0) ? quality - 2 : quality - 1;
    }

}
