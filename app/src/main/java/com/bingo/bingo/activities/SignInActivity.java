package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;

public class SignInActivity extends AppCompatActivity {
     TextView tvcreateAccount;
     EditText username;
     EditText password;
        CheckBox checkpass;
    public static final String App_ID="6489B38C-DCC1-9240-FF77-984DC15FAB00";
    public static final String Secret_Key="D8D8428D-0D09-2B26-FFDB-0CB665428700";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Backendless.initApp(this,App_ID,Secret_Key);
        checkpass=(CheckBox) findViewById(R.id.chkshowpass);
        tvcreateAccount=(TextView) findViewById(R.id.tvcreateaccount);
        username=(EditText)findViewById(R.id.etUsername);
        password=(EditText)findViewById(R.id.etPassword);
        tvcreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Create a new Aacount", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
               startActivity(intent);
            }
        });

        checkpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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



        public  void onSignIn(android.view.View view){
            String Username= username.getText().toString();
            String Password=password.getText().toString();
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

          /*  if(username.getText().toString().equals("bingo") && password.getText().toString().equals("bingo")) {
                               Toast.makeText(SignInActivity.this, "Login", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(this, MainActivity.class);
                                startActivity(intent);
                                //Toast.makeText(LoginActivity.this,"Hello "+etUsername.getText().toString()+" .You logged in succesfully",Toast.LENGTH_LONG).show();
                                    }
            else {
                    Toast.makeText(SignInActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
            }*/

            //Toast.makeText(LoginActivity.this,"Hello "+etUsername.getText().toString()+" .You logged in succesfully",Toast.LENGTH_LONG).show();

        }
    }

