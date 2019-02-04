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
        if(quality > 50){
            quality = 50;
        }
        setQuality(quality);
        setSellIn(getSellIn() - 1);
    }
}
