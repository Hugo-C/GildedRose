import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GildedRoseTest {

    private GildedRose gildedRose;

    @Before
    public void init() {
        gildedRose = new GildedRose();

    }

    @Test
    public void item_should_have_a_sellIn_decreasing() {
        int sellIn = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = sellIn;
        item.quality = 20;

        gildedRose.updateQuality();

        assertEquals(item.sellIn, sellIn - 1);
    }

    @Test
    public void item_should_have_a_quality_decreasing_when_sellin_is_positive() {
        int quality = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = 10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality - 1);
    }

    @Test
    public void item_should_have_a_quality_decreasing_faster_when_sellin_is_negative() {
        int quality = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = -10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality - 2);
    }

    @Test
    public void item_should_have_a_quality_always_positive() {
        int quality = 0;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = -10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality);
    }

    @Test
    public void agedBrie_should_have_a_quality_increasing_by_1_with_sellin_positive() {
        int quality = 5;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = 2;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, quality + 1);
    }

    @Test
    public void agedBrie_should_have_a_quality_increasing_by_2_with_sellin_negative() {
        int quality = 5;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = -2;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, quality + 2);
    }

    @Test
    public void agedBrie_should_have_a_quality_max_of_50_with_sellIn_positive() {
        int quality = 50;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = 10;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void agedBrie_should_have_a_quality_max_of_50_with_sellIn_negative() {
        int quality = 49;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = -5;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void sulfuras_should_have_a_quality_and_sellin_fixed() {
        int quality = 80;
        Item sulfuras = gildedRose.getItem(ItemEnum.Sulfuras);
        sulfuras.sellIn = 0;
        sulfuras.quality = quality;

        gildedRose.updateQuality();

        assertEquals(sulfuras.sellIn, 0);
        assertEquals(sulfuras.quality, quality);
    }

    @Test
    public void backstage_should_have_a_quality_increasing_by_1_with_sellin_over_10() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 15;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 1);
    }

    @Test
    public void backstage_should_have_a_quality_increasing_by_2_with_sellin_between_10_and_5_excluded() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 6;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 2);
    }

    @Test
    public void backstage_should_have_a_quality_increasing_by_2_with_sellin_between_5_and_0_excluded() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 2;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 3);
    }

    @Test
    public void backstage_should_have_a_quality_of_0_with_sellin_0_or_negative() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = -10;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, 0);
    }

    @Test
    public void conjured_should_have_a_quality_decreasing_by_2_with_selling_positive() {
        int quality = 10;
        Item conjured = gildedRose.getItem(ItemEnum.ConjuredManaCake);
        conjured.sellIn = 3;
        conjured.quality = quality;

        gildedRose.updateQuality();

        assertEquals(conjured.quality, quality - 2);
    }

    @Test
    public void conjured_should_have_a_quality_positive() {
        int quality = 0;
        Item conjured = gildedRose.getItem(ItemEnum.ConjuredManaCake);
        conjured.sellIn = 3;
        conjured.quality = quality;

        gildedRose.updateQuality();

        assertEquals(conjured.quality, 0);
    }
}
