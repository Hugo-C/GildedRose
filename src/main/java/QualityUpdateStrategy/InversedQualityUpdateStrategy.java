package QualityUpdateStrategy;

import static java.lang.Math.min;

public class InversedQualityUpdateStrategy implements QualityUpdateStrategy {
    @Override
    public int updateQuality(int sellIn, int quality) {
        if (sellIn < 0) {
            quality += 2;
        } else {
            quality += 1;
        }

        return min(50, quality);
    }
}
