package com.bingo.bingo.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bingo.bingo.R;
import com.bingo.bingo.activities.OlisActivity;
import com.bingo.bingo.adapters.CustomEntrepriseAdapter;
import com.bingo.bingo.models.Entreprise;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindStoreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_find_store, container, false);

        ListView listView = (ListView) view.findViewById(R.id.lvEntreprise);
        ArrayList<Entreprise> arrayOfEntreprise = Entreprise.getEntreprise();
        CustomEntrepriseAdapter adapter = new CustomEntrepriseAdapter(getActivity(), arrayOfEntreprise);
        listView.setAdapter(adapter);



        /*String[] businessList = {"Oli's", "Dominoes","Epi d'or","Marriott","Delimart","La Pleiade",
                                 "Tag Market","Olympic Market","Best Western","Hotel Oasis", "Caribbean Market"};
        ListView listView = (ListView) view.findViewById(R.id.lvBusiness);
        ArrayAdapter<String> listViewAdapter =  new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, businessList);
        listView.setAdapter(listViewAdapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){

                    Intent intent = new Intent(getActivity(), OlisActivity.class);
                    startActivity(intent);

                    Toast.makeText(getActivity(), "Oli's", Toast.LENGTH_SHORT).show();


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
