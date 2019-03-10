package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import com.mobiquityinc.packer.model.Item;
import com.mobiquityinc.packer.model.Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PackerApplication {

    private static final int INTEGER_MULTIPLIER = 100;
    private static final int MAX_PRICE = 100;
    private static final int MAX_ITEM_NUMBER = 15;
    private static final int MAX_ITEM_WEIGHT = 10000;
    private static final int MAX_PACKAGE_WEIGHT = 10000;

    public static void main(String[] args) throws APIException {

        String absolutePath = "/Users/serkaneren/testData/data";
        System.out.println(pack(absolutePath));
    }

    static String pack(String path) throws APIException{
        BufferedReader reader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                Package pack;
                String[] splitted = line.split(":");
                int maxWeight = Integer.valueOf(splitted[0].trim()) * INTEGER_MULTIPLIER;
                List<Item> itemList = new ArrayList<>();

                String replace = splitted[1].trim()
                        .replace("(", "")
                        .replace(")", "")
                        .replace("€", "");
                String[] itemArr = replace.split(" ");

                for (String itemStr : itemArr) {
                    String[] values = itemStr.split(",");
                    Integer index = Integer.valueOf(values[0]);
                    int itemWeight = (int)(Double.valueOf(values[1]) * INTEGER_MULTIPLIER);
                    int price = Integer.valueOf(values[2]);

                    if (price > MAX_PRICE) {
                        throw new APIException("Item price can not be more than 100: " + price);
                    }

                    if (itemWeight > MAX_ITEM_WEIGHT) {
                        throw new APIException("Item weight can not be more than 100: " + itemWeight);
                    }

                    Item item = new Item(index, itemWeight, price);
                    itemList.add(item);
                }
                if (itemList.size() > MAX_ITEM_NUMBER) {
                    throw new APIException("Number of item can not be more than 15: " + itemList.size());
                }

                if (maxWeight > MAX_PACKAGE_WEIGHT){
                    throw new APIException("Package can not be more than 100: " + maxWeight);
                }

                pack = new Package(maxWeight, itemList);
                String result = pack.findPackage();
                stringBuilder.append(result).append("\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new APIException("Exception during parsing");
        }
        return stringBuilder.toString();
    }
}
