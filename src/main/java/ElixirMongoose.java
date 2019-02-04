public class ElixirMongoose extends Item {
    public ElixirMongoose(int sellIn, int quality) {
        super("Elixir of the Mongoose", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
    }
}
