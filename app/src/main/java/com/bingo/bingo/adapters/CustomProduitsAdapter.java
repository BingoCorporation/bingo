package com.bingo.bingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.produits;

import java.util.ArrayList;

/**
 * Created by Ebillson GJ on 8/21/2017.
 */

public class CustomProduitsAdapter extends ArrayAdapter<produits> {

    public CustomProduitsAdapter(Context context, ArrayList<produits> produits) {
        super(context, 0, produits);
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produits, parent, false);
        }

        // Get the data item for this position
        produits produits = getItem(position);

        // Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvProduitsOlis);

        // Populate the data into the template view using the data object
        tvTitle.setText(produits.nom_produit);

        // Return the completed view to render on screen
        return convertView;
    }






}
