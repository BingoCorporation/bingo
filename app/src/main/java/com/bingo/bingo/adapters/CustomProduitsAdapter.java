package com.bingo.bingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.Produits;

import java.util.ArrayList;

/**
 * Created by Ebillson GJ on 8/21/2017.
 */

public class CustomProduitsAdapter extends ArrayAdapter<Produits> {


    // View lookup cache
    private static class ViewHolder {
        TextView nomProduit;
        TextView prixProduit;
       // TextView etatProduit;

    }

    public CustomProduitsAdapter(Context context, ArrayList<Produits> Produits) {
        super(context, 0, Produits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Get the data item for this position
        Produits Produits = getItem(position);

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
            //viewHolder.etatProduit = (TextView)convertView.findViewById(R.id.tvEtatProduit);

            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }



        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.nomProduit.setText(Produits.nom_produit);
        viewHolder.prixProduit.setText(Produits.prix_prod+ " ");
       // viewHolder.etatProduit.setText(Produits.etat_produit);
        // Return the completed view to render on screen
        return convertView;


        // Lookup view for data population
       /* TextView nomProduit = (TextView) convertView.findViewById(R.id.tvProduitsOlis);

        // Populate the data into the template view using the data object
        nomProduit.setText(Produits.nom_produit);

        // Return the completed view to render on screen
        return convertView;*/
    }

}
