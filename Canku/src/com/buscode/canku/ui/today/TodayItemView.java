package com.buscode.canku.ui.today;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.buscode.canku.R;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.ck_today_item)
public class TodayItemView extends LinearLayout{

    @ViewById
    public TextView name, miniLuck;

    public TodayItemView(Context context) {
        super(context);
    }

    public TodayItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
