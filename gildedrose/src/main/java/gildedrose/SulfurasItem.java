package gildedrose;

/**
 *
 * @author roberto
 */
public class SulfurasItem extends Item {

    private final int QUALITY;
    private final int SELLIN;

    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        QUALITY = quality;
        SELLIN = sellIn;
    }

    @Override
    public void fixQuality() {
    }

    @Override
    public int getSellIn() {
        return SELLIN;
    }

    @Override
    public int getQuality() {
        return QUALITY;
    }

}
