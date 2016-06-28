package com.brainpg.teddystoy.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brainpg.teddystoy.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CoordinatorLayoutWithTabActivityFragment extends Fragment {

    public CoordinatorLayoutWithTabActivityFragment() {
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_coordinator_layout_with_tab, container, false);
        setHasOptionsMenu(false);
        return view;
    }


}
