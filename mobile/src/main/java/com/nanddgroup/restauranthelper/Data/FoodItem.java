package com.nanddgroup.restauranthelper.Data;

import com.nanddgroup.restauranthelper.R;

import java.util.ArrayList;
import java.util.List;

public class FoodItem {
    private int foodTypeRes;
    private String orderName;
    private int price;
    private static int totalPrice = 0;

    public FoodItem(int foodTypeRes, String orderName, int price) {
        this.foodTypeRes = foodTypeRes;
        this.orderName = orderName;
        this.price = price;
    }

    public static List<FoodItem> getData() {
        List<FoodItem> data = new ArrayList<FoodItem>();
        for (int i = 0; i < 20; i++) {
            int tempPrice = (int) (Math.random() * 100);
            totalPrice += tempPrice;
            data.add(new FoodItem(R.drawable.chicken, "Fried chicken", tempPrice));
        }
        return data;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public int getFoodTypeRes() {
        return foodTypeRes;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getPrice() {
        return price;
    }

}
