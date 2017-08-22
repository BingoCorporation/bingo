package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bingo.bingo.R;

public class SignInActivity extends AppCompatActivity {
     TextView tvcreateAccount;
     EditText username;
     EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
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

    }



        public  void onSignIn(android.view.View view){



            if(username.getText().toString().equals("bingo") && password.getText().toString().equals("bingo")) {
                               Toast.makeText(SignInActivity.this, "Login", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(this, MainActivity.class);
                                startActivity(intent);
                                //Toast.makeText(LoginActivity.this,"Hello "+etUsername.getText().toString()+" .You logged in succesfully",Toast.LENGTH_LONG).show();
                                    }
            else {
                    Toast.makeText(SignInActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
            }

            //Toast.makeText(LoginActivity.this,"Hello "+etUsername.getText().toString()+" .You logged in succesfully",Toast.LENGTH_LONG).show();

        }
    }

