package com.bingo.bingo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.Entreprise;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ebillson GJ on 9/5/2017.
 */

public class EntrepriseAdapter extends RecyclerView.Adapter<EntrepriseAdapter.ViewHolder> {




    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView tvEntrepriseNom;
        public ImageView ivEntreprise;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvEntrepriseNom = (TextView) itemView.findViewById(R.id.tvEntrepriseName);
            ivEntreprise = (ImageView) itemView.findViewById(R.id.ivEntreprise);
        }
    }




    // Store a member variable for the contacts
    private List<Entreprise> mEntreprise;
    // Store the context for easy access
    private Context mContext;


    // Pass in the contact array into the constructor
    public EntrepriseAdapter(Context context, List<Entreprise> entreprise) {
        mEntreprise = entreprise;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }



    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EntrepriseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View entrepriseView = inflater.inflate(R.layout.item_entreprise, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(entrepriseView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EntrepriseAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Entreprise entreprise = mEntreprise.get(position);

        // Set item views based on your views and data model
        TextView tvEntrepriseNom = viewHolder.tvEntrepriseNom;
        tvEntrepriseNom.setText(entreprise.nomEntreprise);
        Picasso.with(getContext()).load(entreprise.getImageEntreprise()).into(viewHolder.ivEntreprise);

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mEntreprise.size();
    }

}
