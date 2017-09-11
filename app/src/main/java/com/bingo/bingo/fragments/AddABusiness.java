package com.bingo.bingo.fragments;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    private  static  final int PICK_IMAGE=100;
    Uri imageUri;
    EditText Businessname;
    EditText Businessphone;
    EditText Businessadresse;
    EditText Businessemail;
    EditText BusinessDescription;
    ImageView BusinessImage;
    Button btnchoosepic;
    Button btnadd;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK && requestCode==PICK_IMAGE)
        {
            imageUri=data.getData();
            BusinessImage.setImageURI(imageUri);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_a_business, container, false);
        Businessname=(EditText)view.findViewById(R.id.etBusinessName);
        Businessphone=(EditText)view.findViewById(R.id.etBusinessPhone);
        Businessadresse=(EditText)view.findViewById(R.id.etBusinessAdress);
        Businessemail=(EditText)view.findViewById(R.id.etBusinessEmail);
        BusinessDescription = (EditText)view.findViewById(R.id.etBusinessDescription) ;
        BusinessImage=(ImageView)view.findViewById(R.id.imgbusiness);
        btnchoosepic=(Button)view.findViewById(R.id.btnchoosepic);
        btnchoosepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery,PICK_IMAGE);
            }
        });



        btnadd=(Button)view.findViewById(R.id.btnAddBusiness);
        btnadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String Bname=Businessname.getText().toString();
                String Bphone=Businessphone.getText().toString();
                String Bemail=Businessemail.getText().toString();
                String Badresse=Businessemail.getText().toString();
                String Bdescription=BusinessDescription.getText().toString();
                HashMap entreprise = new HashMap();
                entreprise.put( "nomEntreprise", Bname );
                entreprise.put( "emailEntreprise", Bemail );
                entreprise.put( "phoneEntreprise", Bphone );
                entreprise.put( "adresseEntreprise", Badresse );
                entreprise.put("descriptionEntreprise",Bdescription);
                entreprise.put("imageEntreprise",BusinessImage.getResources());

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
                // uploads a file to a remote directory in Backendless Hosting
               //  Backendless.Files.upload( imageUri, AsyncCallback<BackendlessFile> responder );
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
        BusinessDescription.setText("");
        BusinessImage.setImageResource(R.drawable.addlogo);
    }

}
