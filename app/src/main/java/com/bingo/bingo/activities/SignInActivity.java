package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class SignInActivity extends AppCompatActivity {

       // CheckBox checkpass;
    String SERVER_CLIENT_ID ="737268983278-icssnq1b369kecbb7f2eol64940cbhlk.apps.googleusercontent.com";
    GoogleSignInOptions gSignInOptions;
    public static final String App_ID="6489B38C-DCC1-9240-FF77-984DC15FAB00";
    public static final String Secret_Key="D8D8428D-0D09-2B26-FFDB-0CB665428700";

    // TextView tvCreateAccount;
     Button btnCreateAccount;
     EditText username;
     EditText password;
    CheckBox checkboxShowPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Backendless.initApp(this,App_ID,Secret_Key);
       // checkpass=(CheckBox) findViewById(R.id.chkshowpass);


       //get the username EditText
        username=(EditText)findViewById(R.id.etUsername);
        //get the password EditText
        password=(EditText)findViewById(R.id.etPassword);
        //get the checkbox show/hide password
        checkboxShowPassword = (CheckBox)findViewById(R.id.checkboxShowPassword);

        btnCreateAccount=(Button) findViewById(R.id.btnCreateAccount);

        //get the button for creating account
        btnCreateAccount=(Button) findViewById(R.id.btnCreateAccount);


        //add onCheckedListener on Checkbox
        //When user clicks on this checkbox this is the handler
        checkboxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Checkbox status is changed from unchecked to checked
                if(!isChecked){
                    //show password
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                {
                   //hide password
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }


            }
        });


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Create a new Account", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
               startActivity(intent);
            }
        });

        checkboxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked)
                {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }

        public  void onSignIn(android.view.View view) {
            if (username.getText().equals("") & password.getText().equals("")) {
                Toast.makeText(SignInActivity.this, "Username or password missing", Toast.LENGTH_LONG).show();
            } else {
                String Username = username.getText().toString();
                String Password = password.getText().toString();

                Backendless.UserService.login(Username, Password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(SignInActivity.this, "Logged in", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(SignInActivity.this, "Error Logged in", Toast.LENGTH_LONG).show();
                        Log.d("LOGIN", fault.getMessage());
                        Log.d("LOGIN", fault.getDetail());
                    }
                });
            }
        }
    }

