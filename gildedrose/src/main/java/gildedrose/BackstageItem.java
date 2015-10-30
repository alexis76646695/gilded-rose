package gildedrose;

/**
 *
 * @author roberto
 */
public class BackstageItem extends Item {

    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void fixQuality() {
    }

}
