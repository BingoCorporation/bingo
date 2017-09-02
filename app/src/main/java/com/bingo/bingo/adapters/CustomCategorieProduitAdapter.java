package com.bingo.bingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.CategorieProduit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ebillson GJ on 9/2/2017.
 */

public class CustomCategorieProduitAdapter extends ArrayAdapter<CategorieProduit> {

    // View lookup cache
    private static class ViewHolder {
        TextView tvCategorieProduitName;
        ImageView ivCategorieProduit;
    }


    public CustomCategorieProduitAdapter(Context context, ArrayList<CategorieProduit> categorieProduit) {
        super(context, 0, categorieProduit);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        CategorieProduit categorieProduit = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_categorie_produit, parent, false);
            // convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_entreprise, parent, false);

            viewHolder.ivCategorieProduit= (ImageView) convertView.findViewById(R.id.ivCategorieProduit);
            viewHolder.tvCategorieProduitName = (TextView) convertView.findViewById(R.id.tvCategorieProduitName);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);

        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.tvCategorieProduitName.setText(categorieProduit.nomCategorieProduit);
        Picasso.with(getContext()).load(categorieProduit.getImageCategorieProduit()).into(viewHolder.ivCategorieProduit);


        // Return the completed view to render on screen
        return convertView;


    }





}
