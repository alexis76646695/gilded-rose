package gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<>();
        items.add(new NormalItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrieItem("Aged Brie", 2, 0));
        items.add(new NormalItem("Elixir of the Mongoose", 5, 7));
        items.add(new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }

}
