package com.bingo.bingo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;
import com.bingo.bingo.activities.CategorieProduitActivity;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_find_store, container, false);

        lvEntreprise = (ListView) view.findViewById(R.id.lvEntreprise);
        listEntreprise = new ArrayList<>();
        adapter = new CustomEntrepriseAdapter(getContext(), listEntreprise);
        lvEntreprise.setAdapter(adapter);


        IDataStore<Map> entrepriseStorage = Backendless.Data.of("Entreprise");

        entrepriseStorage.find(new AsyncCallback<List<Map>>() {
            @Override
            public void handleResponse(List<Map> response) {
                adapter.addAll(Entreprise.fromListMap(response));

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
                if (position == 0){

                    Intent intent = new Intent(getActivity(), CategorieProduitActivity.class);
                    startActivity(intent);

                    Toast.makeText(getActivity(), "La Reserve", Toast.LENGTH_SHORT).show();


                }

                else if  (position == 1){

                    Toast.makeText(getActivity(), "Dominoes", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 2){

                    Toast.makeText(getActivity(), "Epi d'or", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 3){

                    Toast.makeText(getActivity(), "Marriott", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 4){

                    Toast.makeText(getActivity(), "Delimart", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 5){

                    Toast.makeText(getActivity(), "La Pleiade", Toast.LENGTH_SHORT).show();
                }   else if  (position == 6){

                    Toast.makeText(getActivity(), "Tag Market", Toast.LENGTH_SHORT).show();
                }   else if  (position == 7){

                    Toast.makeText(getActivity(), "Olympic Market", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 8){

                    Toast.makeText(getActivity(), "Best Western", Toast.LENGTH_SHORT).show();
                }
                else if  (position == 9){

                    Toast.makeText(getActivity(), "Caribbean Market", Toast.LENGTH_SHORT).show();
                }


            }
        });
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_find_store, container, false);

        return view;
    }
}
