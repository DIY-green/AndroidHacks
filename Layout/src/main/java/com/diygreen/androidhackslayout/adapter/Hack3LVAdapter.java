/*
 * Copyright (C) 2016 jiashuangkuaizi, Inc.
 */
package com.diygreen.androidhackslayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.diygreen.androidhackslayout.R;

/**
 * Description:
 * <br/>Program Name:
 * <br/>Date: 2016年3月7日
 *
 * @author 李旺成
 * @version 1.0
 */

public class Hack3LVAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    public Hack3LVAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.item_hack3lv, parent, true);
//            convertView = mInflater.inflate(R.layout.item_hack3lv, parent, false);
            convertView = mInflater.inflate(R.layout.item_hack3lv, null);
        }
        return convertView;
    }
}
