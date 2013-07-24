package com.buscode.canku.ui.today;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.buscode.canku.storage.Shop;
import com.buscode.canku.storage.Storage;

import javax.inject.Inject;

public class TodayListAdapter extends BaseAdapter {

    @Inject
    Storage storage;

    @Inject
    Context context;

    @Override
    public int getCount() {
        if (storage.today == null) {
            return 0;
        }
        return storage.today.group.size();
    }

    @Override
    public Shop getItem(int i) {
        return storage.today.group.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = TodayItemView_.build(context);
        }
        TodayItemView itemView = (TodayItemView) view;
        Shop today = getItem(i);
        itemView.name.setText(today.shop.name);
        itemView.miniLuck.setText(today.minLuck.user_name + "喂人民服务");
        return itemView;
    }
}
