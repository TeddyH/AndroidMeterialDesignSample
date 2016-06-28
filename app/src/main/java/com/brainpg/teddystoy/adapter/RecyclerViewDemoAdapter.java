package com.brainpg.teddystoy.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brainpg.teddystoy.activity.CoordinatorLayoutActivity;
import com.brainpg.teddystoy.activity.CoordinatorLayoutWithTabActivity;
import com.brainpg.teddystoy.activity.TabLayoutActivity;

import java.util.List;

public class RecyclerViewDemoAdapter extends RecyclerView.Adapter<RecyclerViewDemoAdapter.RecyclerViewDemoViewHolder> {

    private Activity activity;
    private List<String> dataList;

    public static class RecyclerViewDemoViewHolder extends RecyclerView.ViewHolder {
        public RecyclerViewDemoViewHolder(View view) {
            super(view);
            textView = (TextView) view;
        }

        public TextView textView;
    }

    public RecyclerViewDemoAdapter(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        this.dataList = list;
    }

    public RecyclerViewDemoAdapter(Activity activitiy, List<String> list) {
        this.activity = activitiy;
        if (list == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        this.dataList = list;
    }

    @Override public int getItemViewType(int position) {
        int viewType = 0;
        // add here your booleans or switch() to set viewType at your needed
        // I.E if (position == 0) viewType = 1; etc. etc.
        return viewType;
    }

    @Override public RecyclerViewDemoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        RecyclerViewDemoViewHolder holder = new RecyclerViewDemoViewHolder(view);

        // do something....

        Log.i("RecyclerViewDemoAdapter", "viewType : " + viewType);

        return holder;
    }

    @Override public void onBindViewHolder(final RecyclerViewDemoViewHolder viewHolder, final int position) {
        viewHolder.textView.setText(dataList.get(position));
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position % 3) {
                    case 0:
                        intent = new Intent(activity, TabLayoutActivity.class);

                        ActivityOptionsCompat options =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v,
                                        "transitionName"
                                );
                        ActivityCompat.startActivity(activity, intent, options.toBundle());
//                        activity.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(activity, CoordinatorLayoutActivity.class);
                        activity.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(activity, CoordinatorLayoutWithTabActivity.class);
                        activity.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override public int getItemCount() {
        return dataList.size();
    }

}
