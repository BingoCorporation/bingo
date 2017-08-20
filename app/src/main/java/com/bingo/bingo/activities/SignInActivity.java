package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bingo.bingo.R;

public class SignInActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);}
       // Button button = (Button) findViewById(R.id.button);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindStoreFragment fragment = new FindStoreFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.flContent, fragment);
                transaction.commit();
            }
        });*/



        public  void onSignIn(android.view.View view){

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            //Toast.makeText(LoginActivity.this,"Hello "+etUsername.getText().toString()+" .You logged in succesfully",Toast.LENGTH_LONG).show();

        }
    }

