package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(
            this::test_item,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 5, 0, 1,13},
            new Integer[]{0, 20, 49, 10, 75}
        );
    }

    private String test_item(String name, int sellIn, int quality){
        Item[] items = new Item[] { new Item(name, sellIn, quality) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        return app.items[0].toString();
    }

}
