package com.bingo.bingo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.bingo.bingo.R;

public class ProfileFragment extends Fragment {
  BackendlessUser userInfo;
  private TextView Username,Adresse,Email,Telephone;

  //SharedPreferences sharedPreferences;
  //SharedPreferences.Editor editor;
  String SERVER_CLIENT_ID = "737268983278-icssnq1b369kecbb7f2eol64940cbhlk.apps.googleusercontent.com";
  //GoogleSignInOptions gSignInOptions;
  public static final String App_ID = "6489B38C-DCC1-9240-FF77-984DC15FAB00";
  public static final String Secret_Key = "D8D8428D-0D09-2B26-FFDB-0CB665428700";

  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_profile, parent, false);
    Backendless.initApp(getContext(),App_ID,Secret_Key);
    userInfo = Backendless.UserService.CurrentUser();
    Username = (TextView) v.findViewById(R.id.tvUsernameProf);
    Adresse =(TextView) v.findViewById(R.id.tvAdresseProf);
    Email = (TextView) v.findViewById(R.id.tvEmailProf);
    Telephone = (TextView) v.findViewById(R.id.tvTelephoneProf);

    //Toast.makeText(getActivity(), userInfo.getEmail().toString() + " " + userInfo.getProperty("telephone").toString(), Toast.LENGTH_LONG).show();
    //InitializeView();

    Username.setText("User:  " + userInfo.getProperty("name").toString());
    Adresse.setText("Addresse:  " + userInfo.getProperty("adresse").toString());
    Email.setText("Email:  " + userInfo.getEmail());
    Telephone.setText("Telephone:  " + userInfo.getProperty("telephone").toString());

    return v;
  }

  public void InitializeView() {

    try {

      Username.setText("User:  " + userInfo.getProperty("name").toString());
      Adresse.setText("Addresse:  " + userInfo.getProperty("adresse").toString());
      Email.setText("Email:  " + userInfo.getEmail());
      Telephone.setText("Telephone:  " + userInfo.getProperty("telephone").toString());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}



