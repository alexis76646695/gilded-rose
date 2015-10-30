package gildedrose;

/**
 *
 * @author roberto
 */
public class SulfurasItem extends Item {

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void fixQuality() {
    }

    @Override
    public int getSellIn() {
        return 0;
    }

}
