package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;
import com.bingo.bingo.adapters.CustomCategorieProduitAdapter;
import com.bingo.bingo.models.CategorieProduit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategorieProduitActivity extends AppCompatActivity {



    ArrayList<CategorieProduit> listeCategorieProduit;
    CustomCategorieProduitAdapter categorieProduitAdapter ;
    ListView lvCategorieProduit ;
    TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie_produit);


        lvCategorieProduit = (ListView) findViewById(R.id.lvCategorieProduit);
        listeCategorieProduit = new ArrayList<>();
        categorieProduitAdapter = new CustomCategorieProduitAdapter(this, listeCategorieProduit);
        lvCategorieProduit.setAdapter(categorieProduitAdapter);


        IDataStore<Map> categorieProduitStorage = Backendless.Data.of("CategorieProduit");

        categorieProduitStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                categorieProduitAdapter.addAll(CategorieProduit.fromListMap(response));

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(CategorieProduitActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
