import QualityUpdateStrategy.StandardQualityUpdateStrategy;

public class DexterityVest extends Item {

    public DexterityVest(int sellIn, int quality) {
        super("+5 Dexterity Vest", sellIn, quality);
        strategy = new StandardQualityUpdateStrategy();
    }
}