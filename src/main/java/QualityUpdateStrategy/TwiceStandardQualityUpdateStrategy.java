package QualityUpdateStrategy;

public class TwiceStandardQualityUpdateStrategy extends StandardQualityUpdateStrategy {
    @Override
    public int updateQuality(int sellIn, int quality) {
        quality = super.updateQuality(sellIn, quality);
        return super.updateQuality(sellIn, quality);
    }
}
