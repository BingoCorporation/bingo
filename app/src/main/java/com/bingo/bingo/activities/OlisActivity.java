package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.bingo.bingo.R;
import com.bingo.bingo.adapters.CustomProduitsAdapter;
import com.bingo.bingo.models.Produits;

import java.util.ArrayList;

public class OlisActivity extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olis);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        populateProduitsList();

    }



    private void populateProduitsList(){
        // Construct the data source
        ArrayList<Produits> produitsArrayList= Produits.getProduits();
        // Create the adapter to convert the array to views
        CustomProduitsAdapter adapter = new CustomProduitsAdapter(this, produitsArrayList);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvProduitsOlis);
        listView.setAdapter(adapter);
    }
}