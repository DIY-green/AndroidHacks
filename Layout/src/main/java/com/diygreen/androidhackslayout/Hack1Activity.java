package com.diygreen.androidhackslayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Hack1Activity extends AppCompatActivity {

    private boolean mChangeFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack1_1);
    }

    public void onClick(View v) {
        if (mChangeFlag) {
            setContentView(R.layout.activity_hack1_1);
        } else {
            setContentView(R.layout.activity_hack1_2);
        }
        mChangeFlag = !mChangeFlag;
    }

}
