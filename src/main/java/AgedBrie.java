import static java.lang.Math.min;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int quality = getQuality();
        if(getSellIn() < 0) {
            quality += 2;
        } else {
            quality += 1;
        }

        setQuality(min(50, quality));
        setSellIn(getSellIn() - 1);
    }
}
