package com.app.handcraft.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Discount percentage on purchase price formula discountPercentageOnPurchasePrice = ((MRP-purchasePrice)/MRP)*100
 * Discount percentage on sell price formula discountPercentageOnSellPrice = ((sellPrice - purchasePrice)/sellPrice)*100
 * profit = (MRP - purchasePrice) > (MRP - sellPrice) or purchasePrice < sellPrice
 * Ex MRP = 12000, purchasePrice = 10000, sellPrice = 11000
 */

@Data
@Component
@Slf4j
public class ProfitMarginCalculation {
    private Float MRP;
    private Float purchasePrice;
    private Float sellPrice;
    private Float profit;
    private Float loss;
    private Float discountPercentageOnSellPrice;
    private Float discountPercentageOnPurchasePrice;
    private List<String> errors = new ArrayList<String>();

    public ProfitMarginCalculation() {

    }

    public ProfitMarginCalculation(Float MRP, Float purchasePrice, Float discountPercentageOnSellPrice) {
        this.MRP = MRP;
        this.purchasePrice = purchasePrice;
        this.discountPercentageOnSellPrice = discountPercentageOnSellPrice;
    }

    public void setProfitOrLoss(Float sellPrice, Float purchasePrice) {
        Float result = sellPrice - purchasePrice;
        if (result < 0) {
            this.loss = result;
        } else {
            this.profit = result;
        }
    }

    public Float profitOrLossPercentageOnPurchasePrice(Float MRP, Float purchasePrice) {
        Float profitOrLossPercentageOnPurchasePrice = ((MRP - purchasePrice) / MRP) * 100;
        return profitOrLossPercentageOnPurchasePrice;
    }

    public Float profitOrLossPercentageOnSellPrice(Float sellPrice, Float purchasePrice) {
        Float profitOrLossPercentageOnSellPrice = ((sellPrice - purchasePrice) / sellPrice) * 100;
        return profitOrLossPercentageOnSellPrice;
    }

    public Float displayPercentageOnSellPrice(Float MRP, Float sellPrice) {
        Float displayPercentageOnSellPrice = ((MRP - sellPrice) / MRP) * 100;
        return displayPercentageOnSellPrice;
    }

    public Float purchasePriceAfterHavingDiscountFromMRP(Float MRP, Float discountPercentageOnPurchasePrice) {
        Float purchasePriceAfterHavingDiscountFromMRP = MRP - ((discountPercentageOnPurchasePrice * MRP) / 100);
        this.purchasePrice = purchasePriceAfterHavingDiscountFromMRP;
        return purchasePriceAfterHavingDiscountFromMRP;
    }

    public Float sellPriceAfterAddingDiscountToPurchasePrice(Float purchasePrice, Float discountPercentageOnSellPrice) {
        Float sellPriceAfterAddingDiscountToPurchasePrice = purchasePrice + ((discountPercentageOnSellPrice * purchasePrice) / 100);
        this.sellPrice = sellPriceAfterAddingDiscountToPurchasePrice;
        if (this.sellPrice <= purchasePrice) {
            this.errors.add(" Sell price is less or equal to purchase price ");
        }
        return sellPriceAfterAddingDiscountToPurchasePrice;
    }

    public Boolean validateSellPrice(Float MRP, Float purchasePrice, Float sellPrice) {
        if (purchasePrice < MRP && sellPrice < MRP && sellPrice > purchasePrice) {
            return true;
        }
        return false;
    }

    public Boolean validateSellPercentage(Float MRP, Float discountPercentageOnPurchasePrice, Float discountPercentageOnSellPrice) {
        Float purchasePrice = MRP - purchasePriceAfterHavingDiscountFromMRP(MRP, discountPercentageOnPurchasePrice);
        Float sellPrice = purchasePrice + sellPriceAfterAddingDiscountToPurchasePrice(purchasePrice,
                discountPercentageOnSellPrice);
        return validateSellPrice(MRP, purchasePrice, sellPrice);
    }

    public Float calculateSellPrice(Float MRP, Float purchasePrice, Float discountPercentageOnSellPrice) {
        //calculate purchase price is less or greater than MRP
        if (purchasePrice > MRP) {
            log.error("Purchase Price is greater than MRP by Rs. {}", MRP - purchasePrice);
            this.errors.add(" Purchase Price is greater than MRP ");
        }
        //calculate discount percentage on purchase price
        this.discountPercentageOnPurchasePrice = profitOrLossPercentageOnPurchasePrice(MRP, purchasePrice);
        //validate discount percentage on sell price
        Float priceDifference = MRP - purchasePrice;
        sellPriceAfterAddingDiscountToPurchasePrice(purchasePrice, discountPercentageOnSellPrice);
        if (!validateSellPrice(MRP, purchasePrice, this.sellPrice)) {
            log.error("discount percentage on sell price is not applicable. {}", discountPercentageOnSellPrice);
            this.errors.add("discount percentage on sell price is not applicable.");
        }
        return this.sellPrice;
    }

    public Map<String, Float> finalPriceList(Float MRP, Float purchasePrice, Float discountPercentageOnSellPrice) {
        this.MRP = MRP;
        this.purchasePrice = purchasePrice;
        this.discountPercentageOnSellPrice = discountPercentageOnSellPrice;
        calculateSellPrice(MRP, purchasePrice, discountPercentageOnSellPrice);
        Map<String, Float> finalPriceList = new HashMap<String, Float>();
        finalPriceList.put("MRP", getMRP());
        finalPriceList.put("purchasePrice", getPurchasePrice());
        finalPriceList.put("sellPrice", getSellPrice());
        finalPriceList.put("discountPercentageOnSellPrice", getDiscountPercentageOnSellPrice());
        if (!CollectionUtils.isEmpty(this.errors)) {
            StringBuffer sb = new StringBuffer(" ");
            this.errors.stream().forEach(str -> sb.append(" error: ").append(str));
            finalPriceList.put(sb.toString(), Float.valueOf(String.valueOf(this.errors.size())));
        }
        finalPriceList.put("errors", Float.valueOf(String.valueOf(this.errors.size())));
        return finalPriceList;
    }

}
