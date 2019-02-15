import QualityUpdateStrategy.TwiceStandardQualityUpdateStrategy;

public class ConjuredManaCake extends Item {
    public ConjuredManaCake(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
        strategy = new TwiceStandardQualityUpdateStrategy();
    }
}
