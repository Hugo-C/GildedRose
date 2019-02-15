import QualityUpdateStrategy.QualityUpdateStrategy;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    protected QualityUpdateStrategy strategy;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    public void updateQuality() {
        int newQuality = strategy.updateQuality(getSellIn(), getQuality());
        setSellIn(getSellIn() - 1);
        setQuality(newQuality);
    }

    /* Generated getter and setter code */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
