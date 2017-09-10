package com.bingo.bingo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.bingo.bingo.R;
import com.bingo.bingo.activities.DetailActivity;
import com.bingo.bingo.adapters.CustomEntrepriseAdapter;
import com.bingo.bingo.models.Entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindStoreFragment extends Fragment {

    ListView lvEntreprise;
    ArrayList<Entreprise> listEntreprise;
    CustomEntrepriseAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_find_store, container, false);

        setHasOptionsMenu(true);


        lvEntreprise = (ListView) view.findViewById(R.id.lvEntreprise);
        listEntreprise = new ArrayList<>();
        adapter = new CustomEntrepriseAdapter(getContext(), listEntreprise);
        lvEntreprise.setAdapter(adapter);


        IDataStore<Map> entrepriseStorage = Backendless.Data.of("Entreprise");

        entrepriseStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapter.addAll(Entreprise.fromListMap(response));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d("DEBUG", fault.getCode());
                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



        lvEntreprise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Entreprise entreprise = listEntreprise.get(position);
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("Entreprise", entreprise);
                startActivity(intent);


            }
        });
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_find_store, container, false);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.

        inflater.inflate(R.menu.menu_search, menu);
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


                fetchEntreprise(query);
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                // Set activity title to search query
                 getActivity().setTitle(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return;


    }


    private void fetchEntreprise (String query) {


        lvEntreprise = (ListView) getView().findViewById(R.id.lvEntreprise);
        listEntreprise = new ArrayList<>();
        adapter = new CustomEntrepriseAdapter(getContext(), listEntreprise);

        lvEntreprise.setAdapter(adapter);


        IDataStore<Map> recettesStorage = Backendless.Data.of("Entreprise");


        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        // queryBuilder.setWhereClause( whereClause.toString());

        queryBuilder.setWhereClause("nomEntreprise like'%" + query + "%'");

        recettesStorage.find(queryBuilder, new AsyncCallback<List<Map>>()

        {


            @Override
            public void handleResponse(List<Map> response) {

                //recette = (recettes.fromListMap(response));
                adapter.addAll(Entreprise.fromListMap(response));
                adapter.notifyDataSetChanged();
                Log.d("DEBUG", lvEntreprise.toString());
                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(getContext(), fault.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }



}
