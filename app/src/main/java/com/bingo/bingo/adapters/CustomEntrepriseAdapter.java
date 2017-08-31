package com.bingo.bingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.Entreprise;

import java.util.ArrayList;

/**
 * Created by Ebillson GJ on 8/29/2017.
 */

public class CustomEntrepriseAdapter extends ArrayAdapter<Entreprise> {



    // View lookup cache
    private static class ViewHolder {
        TextView tvEntrepriseName;
        TextView tvEntrepriseAdresse;
    }



    public CustomEntrepriseAdapter(Context context, ArrayList<Entreprise> entreprise) {
        super(context, 0, entreprise);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Entreprise entreprise = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.item_entreprise, parent, false);
            // convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_entreprise, parent, false);

            viewHolder.tvEntrepriseName = (TextView) convertView.findViewById(R.id.tvEntrepriseName);
            viewHolder.tvEntrepriseAdresse = (TextView) convertView.findViewById(R.id.tvEntrepriseAdresse);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);

        }else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.tvEntrepriseName.setText(entreprise.nomEntreprise);
        viewHolder.tvEntrepriseAdresse.setText(entreprise.adresseEntreprise);
        // Return the completed view to render on screen
        return convertView;




        // Lookup view for data population
     /*   TextView tvEntrepriseName = (TextView) convertView.findViewById(R.id.tvEntrepriseName);
        TextView tvEntrepriseAdresse = (TextView) convertView.findViewById(R.id.tvEntrepriseAdresse);
        //ImageView ivEntreprise = (ImageView)convertView.findViewById(R.id.ivEntreprise);
        // Populate the data into the template view using the data object
        tvEntrepriseName.setText(entreprise.nomEntreprise);
        tvEntrepriseAdresse.setText(entreprise.adresseEntreprise);
        //ivEntreprise.setImageURI(Uri.parse(entreprise.imageEntreprise));

        // Return the completed view to render on screen
        return convertView;*/
    }



}
