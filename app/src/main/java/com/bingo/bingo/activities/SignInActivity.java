package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.bingo.bingo.R;

public class SignInActivity extends AppCompatActivity {
    // TextView tvCreateAccount;
     Button btnCreateAccount;
     EditText username;
     EditText password;
    CheckBox checkboxShowPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


       //get the username EditText
        username=(EditText)findViewById(R.id.etUsername);
        //get the password EditText
        password=(EditText)findViewById(R.id.etPassword);
        //get the checkbox show/hide password
        checkboxShowPassword = (CheckBox)findViewById(R.id.checkboxShowPassword);
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

