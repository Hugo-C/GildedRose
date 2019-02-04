public class ConjuredManaCake extends Item {
    public ConjuredManaCake(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        int quality = getQuality();
        if(getSellIn() > 0){
            quality -= 2;
        } else {
            quality -= 4;
        }

        if(quality < 0)
            quality = 0;
        setQuality(quality);
        setSellIn(getSellIn() - 1);
    }
}
