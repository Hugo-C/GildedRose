import QualityUpdateStrategy.BackstageLikeQualityUpdateStrategy;

public class Backstage extends Item {
    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        strategy = new BackstageLikeQualityUpdateStrategy();
    }

}
