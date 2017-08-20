package com.bingo.bingo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.bingo.bingo.R.layout.fragment_add_a_business;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddABusiness extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(fragment_add_a_business, container, false);
    }



}
