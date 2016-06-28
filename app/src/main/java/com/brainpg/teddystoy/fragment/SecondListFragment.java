package com.brainpg.teddystoy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainpg.teddystoy.R;
import com.brainpg.teddystoy.adapter.RecyclerViewDemoAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondListFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static SecondListFragment newInstance(String param1, String param2) {
        SecondListFragment fragment = new SecondListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SecondListFragment() {
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerViewDemoAdapter adapter = new RecyclerViewDemoAdapter(getActivity(), getListData());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<String> getListData() {
        List<String> list = new ArrayList<>();
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");
        list.add("빨");
        list.add("주");
        list.add("노");
        list.add("초");
        list.add("파");
        list.add("남");
        list.add("보");

        return list;
    }

}
