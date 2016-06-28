package com.brainpg.teddystoy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.brainpg.teddystoy.R;

public abstract class CommonBaseActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_common_base_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override public void setContentView(int layoutResID) {
//        frameLayout = (FrameLayout) fullLayout.findViewById(R.id.drawer_frame);
//
//        getLayoutInflater().inflate(layoutResID, frameLayout, true);
//
//        super.setContentView(fullLayout);
    }

//    public void setToolbarTitle(String title) {
//        getSupportActionBar().setToolbarTitle(title);
//    }
//    public void setToolbarTitle(int )

}
