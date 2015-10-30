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
        if (sellIn > 10) {
            quality++;
        } else if (sellIn > 5) {
            quality += 2;
        } else if (sellIn >= 0){
            quality += 3;
        } else {
            quality = 0;
        }
    }

}
