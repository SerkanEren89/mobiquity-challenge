package com.mobiquityinc.packer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Item model
 *
 * @author serkaneren
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private int index;
    private int itemWeight;
    private int itemPrice;
}
