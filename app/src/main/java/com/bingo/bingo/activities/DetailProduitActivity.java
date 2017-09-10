package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.bingo.bingo.R;
import com.bingo.bingo.adapters.CustomProduitAdapter;
import com.bingo.bingo.models.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bingo.bingo.R.id.lvProduitsOlis;

public class DetailProduitActivity extends AppCompatActivity {


    ArrayList<Produit> listeProduits;
    CustomProduitAdapter produitAdapter ;
    ListView lvProduits ;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_detail);

        toolbar = (Toolbar) findViewById(R.id.toolbarSearch);

        setSupportActionBar(toolbar);



        toolbar.setNavigationIcon(R.drawable.ic_returnback);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lvProduits = (ListView) findViewById(lvProduitsOlis);
        listeProduits = new ArrayList<>();
        produitAdapter = new CustomProduitAdapter(this, listeProduits);
        lvProduits.setAdapter(produitAdapter);



        IDataStore<Map> produitsStorage = Backendless.Data.of("Produit");

        produitsStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                produitAdapter.addAll(Produit.fromListMap(response));
                produitAdapter.notifyDataSetChanged();

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(DetailProduitActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }




    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                fetchProduit(query);
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                // Set activity title to search query
                DetailProduitActivity.this.setTitle(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }




    private void fetchProduit(String query) {
        lvProduits = (ListView) findViewById(lvProduitsOlis);
        listeProduits = new ArrayList<>();
        produitAdapter = new CustomProduitAdapter(this, listeProduits);

        lvProduits.setAdapter(produitAdapter);


        IDataStore<Map> produitStorage = Backendless.Data.of("Produit");


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();

        queryBuilder.setWhereClause("nomProduit like'%" + query + "%'");

        produitStorage.find(queryBuilder, new AsyncCallback<List<Map>>()

        {

            @Override
            public void handleResponse(List<Map> response) {

                produitAdapter.addAll(Produit.fromListMap(response));
                produitAdapter.notifyDataSetChanged();
                Log.d("DEBUG", lvProduits.toString());
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }






}