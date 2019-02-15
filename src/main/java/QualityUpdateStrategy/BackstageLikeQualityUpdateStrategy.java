package QualityUpdateStrategy;

import static java.lang.Math.min;

public class BackstageLikeQualityUpdateStrategy implements QualityUpdateStrategy {
    @Override
    public int updateQuality(int sellIn, int quality) {
        if (sellIn < 0) {
            quality = 0;
        } else if (sellIn <= 5) {
            quality += 3;
        } else if (sellIn <= 10) {
            quality += 2;
        } else {
            quality += 1;
        }

        return min(50, quality);
    }
}
