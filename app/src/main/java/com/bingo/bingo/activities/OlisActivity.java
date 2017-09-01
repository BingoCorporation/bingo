package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;
import com.bingo.bingo.adapters.CustomProduitsAdapter;
import com.bingo.bingo.models.Produits;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bingo.bingo.R.id.lvProduitsOlis;

public class OlisActivity extends AppCompatActivity {


    ArrayList<Produits> listeProduits;
    CustomProduitsAdapter adapter ;
    ListView lvProduits ;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olis);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        lvProduits = (ListView) findViewById(lvProduitsOlis);
        listeProduits = new ArrayList<>();
        adapter = new CustomProduitsAdapter(this, listeProduits);
        lvProduits.setAdapter(adapter);


        IDataStore<Map> produitsStorage = Backendless.Data.of("Produits");

        produitsStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapter.addAll(Produits.fromListMap(response));

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(OlisActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }



   /* private void populateProduitsList(){
        // Construct the data source
        ArrayList<Produits> produitsArrayList= Produits.getProduits();
        // Create the adapter to convert the array to views
        CustomProduitsAdapter adapter = new CustomProduitsAdapter(this, produitsArrayList);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvProduitsOlis);
        listView.setAdapter(adapter);
    }*/
}