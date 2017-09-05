package com.bingo.bingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.Produit;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ebillson GJ on 8/21/2017.
 */

public class CustomProduitAdapter extends ArrayAdapter<Produit> {


    // View lookup cache
    private static class ViewHolder {
        TextView nomProduit;
        TextView prixProduit;
        ImageView ivProduit;
    }

    public CustomProduitAdapter(Context context, ArrayList<Produit> produit) {
        super(context, 0, produit);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        Produit produit = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_produits, parent, false);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_produits, parent, false);

            viewHolder.nomProduit = (TextView) convertView.findViewById(R.id.tvProduitsOlis);
            viewHolder.prixProduit = (TextView)convertView.findViewById(R.id.tvPrixProd);
            viewHolder.ivProduit = (ImageView) convertView.findViewById(R.id.ivProduitOlis);
            //viewHolder.etatProduit = (TextView)convertView.findViewById(R.id.tvEtatProduit);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }



        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.nomProduit.setText(produit.nomProduit);
        viewHolder.prixProduit.setText(produit.prixProduit+ " gdes.");
        Picasso.with(getContext()).load(produit.getImageProduit()).into(viewHolder.ivProduit);

       // viewHolder.etatProduit.setText(Produit.etat_produit);
        // Return the completed view to render on screen
        return convertView;



    }

}
