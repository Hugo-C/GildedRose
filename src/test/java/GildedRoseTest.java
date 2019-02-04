import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GildedRoseTest {

	private GildedRose gildedRose;

	@Before
	public void init(){
		gildedRose = new GildedRose();

	}

	@Test
	public void testSellIn() {
		int sellIn = 10;
		Item item = new Item("+5 Dexterity Vest", sellIn, 20);
		gildedRose.items.add(item);

		gildedRose.updateQuality();

		assertEquals(item.sellIn, sellIn - 1);
	}

	@Test
	public void testQualityWithSellInPositive() {
		int quality = 10;
		Item item = new Item("+5 Dexterity Vest", 10, quality);
		gildedRose.items.add(item);

		gildedRose.updateQuality();

		assertEquals(item.quality, quality - 1);
	}

	@Test
	public void testQualityWithSellInNegative() {
		int quality = 10;
		Item item = new Item("+5 Dexterity Vest", -10, quality);
		gildedRose.items.add(item);

		gildedRose.updateQuality();

		assertEquals(item.quality, quality - 2);
	}

	@Test
	public void testQualityIsPositive() {
		int quality = 0;
		Item item = new Item("+5 Dexterity Vest", -10, quality);
		gildedRose.items.add(item);

		gildedRose.updateQuality();

		assertEquals(item.quality, quality);
	}

	@Test
	public void testQualityAgedBrieWithSellInPositive() {
		int quality = 5;
		Item agedBrie = new Item("Aged Brie", 2, quality);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, quality + 1);
	}

	@Test
	public void testQualityAgedBrieWithSellInNegative() {
		int quality = 5;
		Item agedBrie = new Item("Aged Brie", -2, quality);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, quality + 2);
	}

	@Test
	public void testQualityIsUnder51WithSellInPositive() {
		int quality = 50;
		Item agedBrie = new Item("Aged Brie", 10, quality);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, 50);
	}

	@Test
	public void testQualityIsUnder51WithSellInNegative() {
		int quality = 49;
		Item agedBrie = new Item("Aged Brie", -5, quality);
		gildedRose.items.add(agedBrie);

		gildedRose.updateQuality();

		assertEquals(agedBrie.quality, 50);
	}

	@Test
	public void testSellinAndQualitySulfuras() {
		int quality = 80;
		Item sulfuras =	new Item("Sulfuras, Hand of Ragnaros", 0, quality);
		gildedRose.items.add(sulfuras);

		gildedRose.updateQuality();

		assertEquals(sulfuras.sellIn, 0);
		assertEquals(sulfuras.quality, quality);
	}

	@Test
	public void testQualityBackstageWithSellInOver10() {
		int quality = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 15, quality);
		gildedRose.items.add(backstage);

		gildedRose.updateQuality();

		assertEquals(backstage.quality, quality + 1);
	}

	@Test
	public void testQualityBackstageWithSellInBetween10and5Excluded() {
		int quality = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 6, quality);
		gildedRose.items.add(backstage);

		gildedRose.updateQuality();

		assertEquals(backstage.quality, quality + 2);
	}

	@Test
	public void testQualityBackstageWithSellInBetween5and0Excluded() {
		int quality = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 2, quality);
		gildedRose.items.add(backstage);

		gildedRose.updateQuality();

		assertEquals(backstage.quality, quality + 3);
	}

	@Test
	public void testQualityBackstageWithSellInNegativeOrZero() {
		int quality = 10;
		Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", -10, quality);
		gildedRose.items.add(backstage);

		gildedRose.updateQuality();

		assertEquals(backstage.quality, 0);
	}

	@Test
	public void testQualityConjured() {  // TODO check conjured doesn't drop under 0 quality
		int quality = 10;
		Item backstage = new Item("Conjured Mana Cake", 3, quality);
		gildedRose.items.add(backstage);

		gildedRose.updateQuality();

		assertEquals(backstage.quality, quality - 2);
	}
}
