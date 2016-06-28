package com.brainpg.teddystoy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.brainpg.teddystoy.R;
import com.brainpg.teddystoy.adapter.TabLayoutFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutWithTabActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_with_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_common_base_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeButtonEnabled(true);
            setToolbarTitle("CoordinatorLayoutActivity");
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // 콘텐츠가 변화해도 RecyclerView의 레이아웃 크기가 변경되지 않을 경우
        // 성능 향상을 위해 이 설정을 사용
//        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

        // specify an adapter (see also next example)
//        RecyclerViewDemoAdapter adapter = new RecyclerViewDemoAdapter(getListData());
//        recyclerView.setAdapter(adapter);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new TabLayoutFragmentPagerAdapter(getSupportFragmentManager(), this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setToolbarTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.action_bar_title);
        textView.setText(title);
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();
        list.add("도");
        list.add("레");
        list.add("미");
        list.add("파");
        list.add("솔");
        list.add("라");
        list.add("시");

        return list;
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coordinator_layout, menu);

        return true;
    }


}
