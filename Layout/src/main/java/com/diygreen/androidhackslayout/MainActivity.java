package com.diygreen.androidhackslayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hack1:
                overlay(Hack1Activity.class);
                break;
            case R.id.btn_hack2:
                overlay(Hack2Activity.class);
                break;
            case R.id.btn_hack3:
                overlay(Hack3Activity.class);
                break;
            case R.id.btn_hack4:
                overlay(Hack4Activity.class);
                break;
            case R.id.btn_hack5:
                overlay(Hack5Activity.class);
                break;
        }
    }

    private void overlay(Class<? extends Activity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
