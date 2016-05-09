package com.diygreen.androidhackslayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.diygreen.androidhackslayout.adapter.Hack3LVAdapter;
import com.diygreen.androidhackslayout.service.ViewServer;

public class Hack3Activity extends AppCompatActivity {

    private ListView mContentLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack3);
        ViewServer.get(this).addWindow(this);

        initView();
//        initData();
    }

    private void initView() {
        this.mContentLV = (ListView) findViewById(R.id.lv_content);
    }

    private void initData() {
        this.mContentLV.setAdapter(new Hack3LVAdapter(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

}
