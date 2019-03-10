package com.mobiquityinc.packer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package model
 *
 * @author serkaneren
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    private int maxWeight;
    private List<Item> list;

    public String findPackage() {
        int n = list.size() + 1;
        int w = maxWeight + 1;
        double[][] matrix = new double[n][w];


        for (int i = 1; i < n; i++) {
            Item item = list.get(i - 1);

            for (int j = 1; j < w; j++) {
                if (item.getItemWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - item.getItemWeight()] + item.getItemPrice());
                }
            }
        }

        List<Integer> indexes = new ArrayList<>();
        int j = maxWeight;
        double totalCost = matrix[n - 1][w - 1];
        for (; j > 0 && matrix[n - 1][j - 1] == totalCost; j--);

        for (int i = n - 1; i > 0; i--) {
            if (matrix[i][j] != matrix[i - 1][j]) {
                indexes.add(list.get(i - 1).getIndex());
                j -= list.get(i - 1).getItemWeight();
            }
        }

        String result =
                indexes.stream()
                        .mapToInt(i -> i)
                        .sorted()
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(","));
        return result.isEmpty() ? "-" : result;
    }
}
