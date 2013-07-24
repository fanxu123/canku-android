package com.buscode.canku.storage;

import com.buscode.canku.gson.GsonBean;

import java.util.ArrayList;

@GsonBean
public class Shop {
    public ShopInfo shop;
    public float totalPrice;
    public int totalNum;
    public ShopOrder minLuck;
    public ArrayList<ShopOrder> orders;
}
