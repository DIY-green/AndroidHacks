package com.diygreen.androidhackslayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class Hack4Activity extends AppCompatActivity {

    private static final String TAG = "Hack4Activity";
    private ViewStub mTestVS;
    private ViewStub mTest2VS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack4);

        initView();
    }

    private void initView() {
        this.mTestVS = (ViewStub) findViewById(R.id.vs_test);
        this.mTest2VS = (ViewStub) findViewById(R.id.vs_test2);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_inflate:
                inflate();
                break;
            case R.id.btn_show:
                show();
                break;
            case R.id.btn_hide:
                hide();
                break;
            case R.id.btn_inflate_merge:
                inflateMerge();
                break;
        }
    }

    private void inflate() {
        TextView fooder = (TextView) mTestVS.inflate();
        fooder.setText("我是ViewStub Inflate的页脚");
        Log.e(TAG, fooder.toString());
    }

    private void show() {
        mTestVS.setVisibility(View.VISIBLE);
    }

    private void hide() {
        mTestVS.setVisibility(View.GONE);
    }

    private void inflateMerge() {
        View header = mTest2VS.inflate();
        Log.e(TAG, header.toString());
    }

}
