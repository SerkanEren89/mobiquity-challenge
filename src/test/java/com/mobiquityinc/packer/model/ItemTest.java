package com.mobiquityinc.packer.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Item model test
 *
 * @author serkaneren
 */
public class ItemTest {

    private Item item;


    @Before
    public void setup() {
        item = new Item();
    }

    @Test
    public void testGetSetIndex() {
        item.setIndex(1);

        assertEquals(1, item.getIndex());
    }

    @Test
    public void testGetSetItemWeight() {
        item.setItemWeight(1000);

        assertEquals(1000, item.getItemWeight(), 0);
    }

    @Test
    public void testGetSetItemPrice() {
        item.setItemPrice(10);

        assertEquals(10, item.getItemPrice());
    }
}
