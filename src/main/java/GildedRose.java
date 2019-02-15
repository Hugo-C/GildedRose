import java.util.HashMap;
import java.util.Map;


public class GildedRose {

    private Map<ItemEnum, Item> items = new HashMap<>();

    public GildedRose() {
        items.put(ItemEnum.DexterityVest, new DexterityVest(10, 20));
        items.put(ItemEnum.AgedBrie, new AgedBrie(2, 0));
        items.put(ItemEnum.ElixirMongoose, new ElixirMongoose(5, 7));
        items.put(ItemEnum.Sulfuras, new Sulfuras(0, 80));
        items.put(ItemEnum.Backstage, new Backstage(15, 20));
        items.put(ItemEnum.ConjuredManaCake, new ConjuredManaCake(3, 6));
    }

    public Item getItem(ItemEnum itemEnum) {
        return items.get(itemEnum);
    }


    public void updateQuality() {
        for (Map.Entry<ItemEnum, Item> entry : items.entrySet()) {
            Item item = entry.getValue();
            item.updateQuality();
        }
    }

    public static void main(String[] args) {
        var gildedRose = new GildedRose();
        gildedRose.updateQuality();
    }
}