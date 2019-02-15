import static java.lang.Math.min;

public class Backstage extends Item {
    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int quality = getQuality();
        int sellIn = getSellIn();

        if(sellIn < 0) {
            quality = 0;
        } else if(sellIn <= 5) {
            quality += 3;
        } else if(sellIn <= 10) {
            quality += 2;
        } else {
            quality += 1;
        }

        setQuality(min(50, quality));
        setSellIn(sellIn - 1);
    }
}
