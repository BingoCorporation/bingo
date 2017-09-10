package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
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


        //Display the toobar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getActionBar();


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






    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //// Expand the search view and request focus
        //searchItem.expandActionView();
        //searchView.requestFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599


                fetchCategorieProduit(query);
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                // Set activity title to search query
                CategorieProduitActivity.this.setTitle(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }




    private void fetchCategorieProduit(String query) {
        lvCategorieProduit = (ListView) findViewById(R.id.lvCategorieProduit);
        listeCategorieProduit = new ArrayList<>();
        categorieProduitAdapter = new CustomCategorieProduitAdapter(this, listeCategorieProduit);

        lvCategorieProduit.setAdapter(categorieProduitAdapter);


        IDataStore<Map> recettesStorage = Backendless.Data.of("CategorieProduit");


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        // queryBuilder.setWhereClause( whereClause.toString());

        queryBuilder.setWhereClause("nomCategorieProduit like'%" + query + "%'");

        recettesStorage.find(queryBuilder, new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                //recette = (recettes.fromListMap(response));
                categorieProduitAdapter.addAll(CategorieProduit.fromListMap(response));
                categorieProduitAdapter.notifyDataSetChanged();
                Log.d("DEBUG", lvCategorieProduit.toString());
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getApplicationContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }



}






