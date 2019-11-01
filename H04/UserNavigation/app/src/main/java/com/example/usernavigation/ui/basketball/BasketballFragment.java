package com.example.usernavigation.ui.basketball;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.usernavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasketballFragment extends Fragment {


    public BasketballFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basketball, container, false);
    }

}
