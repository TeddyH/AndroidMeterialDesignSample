package com.brainpg.teddystoy.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brainpg.teddystoy.R;
import com.brainpg.teddystoy.adapter.RecyclerViewDemoAdapter;
import com.brainpg.teddystoy.common.utils.TypefaceUtil;
import com.brainpg.teddystoy.common.utils.ViewUtils;
import com.brainpg.teddystoy.listener.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private LinearLayout mToolbarContainer;
    private int mToolbarHeight;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceUtil.overrideFont(getApplicationContext(), getString(R.string.main_font), getString(R.string.custom_font));
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_common_base_toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            setToolbarTitle("여기는 툴바 타이틀 영역");
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mToolbarContainer = (LinearLayout) findViewById(R.id.toolbarContainer);
        mToolbarHeight = ViewUtils.getToolbarHeight(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewDemoAdapter arrayAdapter = new RecyclerViewDemoAdapter(this, getListData());
        recyclerView.setAdapter(arrayAdapter);
//        recyclerView.setOnItemClickListener(this);

        recyclerView.addOnScrollListener(new HidingScrollListener(this) {
            @Override
            public void onMoved(int distance) {
                mToolbarContainer.setTranslationY(-distance);
            }

            @Override
            public void onShow() {
                mToolbarContainer.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onHide() {
                mToolbarContainer.animate().translationY(-mToolbarHeight).setInterpolator(new AccelerateInterpolator(2)).start();
            }
        });
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
        list.add("TabLayoutActivity");
        list.add("CoordinatorLayoutActivity");
        list.add("CoordinatorLayoutActivity with Tab");
//        }
        return list;
    }

    public void setToolbarTitle(String title) {
        TextView textView = (TextView) findViewById(R.id.action_bar_title);
        textView.setText(title);
    }

    /*  A menu is a temporary sheet of paper that always overlaps the App Bar, rather than behaving as an extension of the App Bar.
        http://www.google.com/design/spec/layout/structure.html#structure-app-bar
     */

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
