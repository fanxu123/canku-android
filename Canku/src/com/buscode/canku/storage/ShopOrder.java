package com.buscode.canku.storage;

import com.buscode.canku.gson.GsonBean;

import java.util.ArrayList;

@GsonBean
public class ShopOrder {
    public String _id;
    public boolean canceled;
    public int luck;
    public ArrayList<Order> order;
    public String payStatus;
    public String shop_id;
    public String shop_name;
    public String time;
    public int total;
    public String user_id;
    public String user_name;
}
