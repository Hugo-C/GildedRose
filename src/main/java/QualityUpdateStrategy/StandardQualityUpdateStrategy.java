package QualityUpdateStrategy;

import static java.lang.Math.max;

public class StandardQualityUpdateStrategy implements QualityUpdateStrategy {
    @Override
    public int updateQuality(int sellIn, int quality) {
        if (sellIn > 0) {
            quality -= 1;
        } else {
            quality -= 2;
        }

        return max(quality, 0);
    }
}
