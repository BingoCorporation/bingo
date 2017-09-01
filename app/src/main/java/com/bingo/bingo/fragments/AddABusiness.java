package com.bingo.bingo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddABusiness extends Fragment {
    public static final String App_ID="6489B38C-DCC1-9240-FF77-984DC15FAB00";
    public static final String Secret_Key="D8D8428D-0D09-2B26-FFDB-0CB665428700";
    EditText Businessname;
    EditText Businessphone;
    EditText Businessadresse;
    EditText Businessemail;
    Button btnadd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_a_business, container, false);
        Businessname=(EditText)view.findViewById(R.id.etBusinessName);
        Businessphone=(EditText)view.findViewById(R.id.etBusinessPhone);
        Businessadresse=(EditText)view.findViewById(R.id.etBusinessAdress);
        Businessemail=(EditText)view.findViewById(R.id.etBusinessEmail);
        btnadd=(Button)view.findViewById(R.id.btnAddBusiness);
        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String Bname=Businessname.getText().toString();
                String Bphone=Businessphone.getText().toString();
                String Bemail=Businessemail.getText().toString();
                String Badresse=Businessemail.getText().toString();
                HashMap entreprise = new HashMap();
                entreprise.put( "nomEntreprise", Bname );
                entreprise.put( "emailEntreprise", Bemail );
                entreprise.put( "phoneEntreprise", Bphone );
                entreprise.put( "adresseEntreprise", Badresse );

                // save object synchronously
                // Map savedEntreprise = Backendless.Persistence.of( "Entreprise" ).save( entreprise );

                // save object asynchronously
                Backendless.Persistence.of( "Entreprise" ).save( entreprise, new AsyncCallback<Map>() {
                    public void handleResponse( Map response )
                    {
                        // new Contact instance has been saved
                        clearEdittext();
                        Toast.makeText(getContext(), "Business saved", Toast.LENGTH_LONG).show();
                    }

                    public void handleFault( BackendlessFault fault )
                    {
                        // an error has occurred, the error code can be retrieved with fault.getCode()
                        Toast.makeText(getContext(), "Failed" + fault.getCode(), Toast.LENGTH_LONG).show();
                        Log.d("Business", fault.getMessage());
                        Log.d("Business", fault.getDetail());
                    }
                });
            }
        });


        return  view;
    }
    public void clearEdittext()
    {
        Businessname.setText("");
        Businessphone.setText("");
        Businessadresse.setText("");
        Businessemail.setText("");
    }

}
