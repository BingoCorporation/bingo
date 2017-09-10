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
import com.bingo.bingo.adapters.CustomProduitAdapter;
import com.bingo.bingo.models.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bingo.bingo.R.id.lvProduitsOlis;

public class OlisActivity extends AppCompatActivity {


    ArrayList<Produit> listeProduits;
    CustomProduitAdapter produitAdapter ;
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
        produitAdapter = new CustomProduitAdapter(this, listeProduits);
        lvProduits.setAdapter(produitAdapter);


        IDataStore<Map> produitsStorage = Backendless.Data.of("Produit");

        produitsStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                produitAdapter.addAll(Produit.fromListMap(response));

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(OlisActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}