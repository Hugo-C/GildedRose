import QualityUpdateStrategy.InversedQualityUpdateStrategy;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
        strategy = new InversedQualityUpdateStrategy();
    }
}
