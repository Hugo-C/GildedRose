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
    public void testSellIn() {
        int sellIn = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = sellIn;
        item.quality = 20;

        gildedRose.updateQuality();

        assertEquals(item.sellIn, sellIn - 1);
    }

    @Test
    public void testQualityWithSellInPositive() {
        int quality = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = 10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality - 1);
    }

    @Test
    public void testQualityWithSellInNegative() {
        int quality = 10;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = -10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality - 2);
    }

    @Test
    public void testQualityIsPositive() {
        int quality = 0;
        Item item = gildedRose.getItem(ItemEnum.DexterityVest);
        item.sellIn = -10;
        item.quality = quality;

        gildedRose.updateQuality();

        assertEquals(item.quality, quality);
    }

    @Test
    public void testQualityAgedBrieWithSellInPositive() {
        int quality = 5;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = 2;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, quality + 1);
    }

    @Test
    public void testQualityAgedBrieWithSellInNegative() {
        int quality = 5;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = -2;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, quality + 2);
    }

    @Test
    public void testQualityIsUnder51WithSellInPositive() {
        int quality = 50;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = 10;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testQualityIsUnder51WithSellInNegative() {
        int quality = 49;
        Item agedBrie = gildedRose.getItem(ItemEnum.AgedBrie);
        agedBrie.sellIn = -5;
        agedBrie.quality = quality;

        gildedRose.updateQuality();

        assertEquals(agedBrie.quality, 50);
    }

    @Test
    public void testSellinAndQualitySulfuras() {
        int quality = 80;
        Item sulfuras = gildedRose.getItem(ItemEnum.Sulfuras);
        sulfuras.sellIn = 0;
        sulfuras.quality = quality;

        gildedRose.updateQuality();

        assertEquals(sulfuras.sellIn, 0);
        assertEquals(sulfuras.quality, quality);
    }

    @Test
    public void testQualityBackstageWithSellInOver10() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 15;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 1);
    }

    @Test
    public void testQualityBackstageWithSellInBetween10and5Excluded() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 6;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 2);
    }

    @Test
    public void testQualityBackstageWithSellInBetween5and0Excluded() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = 2;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, quality + 3);
    }

    @Test
    public void testQualityBackstageWithSellInNegativeOrZero() {
        int quality = 10;
        Item backstage = gildedRose.getItem(ItemEnum.Backstage);
        backstage.sellIn = -10;
        backstage.quality = quality;

        gildedRose.updateQuality();

        assertEquals(backstage.quality, 0);
    }

    @Test
    public void testQualityConjured() {
        int quality = 10;
        Item conjured = gildedRose.getItem(ItemEnum.ConjuredManaCake);
        conjured.sellIn = 3;
        conjured.quality = quality;

        gildedRose.updateQuality();

        assertEquals(conjured.quality, quality - 2);
    }
    @Test
    public void testQualityIsPositiveConjured() {
        int quality = 0;
        Item conjured = gildedRose.getItem(ItemEnum.ConjuredManaCake);
        conjured.sellIn = 3;
        conjured.quality = quality;

        gildedRose.updateQuality();

        assertEquals(conjured.quality, 0);
    }
}
