package com.mobiquityinc.packer.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Package model test
 *
 * @author serkaneren
 */
public class PackageTest {

    @Test
    public void testFindPackageSuccess() {
        Package pack = createMockPackage();
        assertEquals("4", pack.findPackage());
    }

    @Test
    public void testFindPackage() {
        Package pack = createMockEmptyPackage();
        assertEquals("-", pack.findPackage());
    }

    private Package createMockPackage() {
        Package pack;
        List<Item> itemList = new ArrayList<>();
        Item itemFirst = new Item(1, 5338, 45);
        Item itemSecond = new Item(2, 8862, 98);
        Item itemThird = new Item(3, 7848, 3);
        Item itemFourth = new Item(4, 7230, 76);
        Item itemFifth = new Item(5, 3018, 9);
        Item itemSixth = new Item(6, 4634, 48);
        itemList.add(itemFirst);
        itemList.add(itemSecond);
        itemList.add(itemThird);
        itemList.add(itemFourth);
        itemList.add(itemFifth);
        itemList.add(itemSixth);
        pack = new Package(8100, itemList);
        return pack;
    }

    private Package createMockEmptyPackage() {
        Package pack;
        List<Item> itemList = new ArrayList<>();
        Item itemFirst = new Item(1, 1530, 34);
        itemList.add(itemFirst);
        pack = new Package(800, itemList);
        return pack;
    }
}
