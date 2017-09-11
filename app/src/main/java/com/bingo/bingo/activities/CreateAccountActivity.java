package com.bingo.bingo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bingo.bingo.R;

public class CreateAccountActivity extends AppCompatActivity {

    EditText edtname;
    EditText edtemail;
    EditText edttelephone;
    EditText edtpassword;
    EditText edtconfirmpass;
    EditText edtadresse;
    Button btnRegister;

    public static final String App_ID="6489B38C-DCC1-9240-FF77-984DC15FAB00";
    public static final String Secret_Key="D8D8428D-0D09-2B26-FFDB-0CB665428700";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Backendless.initApp(this,App_ID,Secret_Key);

        edtname=(EditText)findViewById(R.id.etname);
        edtemail=(EditText)findViewById(R.id.etemail);
        edttelephone=(EditText)findViewById(R.id.ettelephone);
        edtpassword=(EditText)findViewById(R.id.etPassword);
        edtconfirmpass=(EditText)findViewById(R.id.etconfirmpassword);
        edtadresse=(EditText)findViewById(R.id.etadresse);
        btnRegister=(Button)findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= edtname.getText().toString();
                String Email=edtemail.getText().toString();
                String Telephone=edttelephone.getText().toString();
                String Password =edtpassword.getText().toString();
                String ConfirmPass=edtconfirmpass.getText().toString();
                String adresse=edtadresse.getText().toString();
                BackendlessUser User=new BackendlessUser();
                User.setProperty("name",Name);
                User.setProperty("email",Email);
                User.setProperty("telephone",Telephone);
                User.setProperty("adresse",adresse);
                User.setPassword(Password);
            if (Password.equals(ConfirmPass)) {
                Backendless.UserService.register(User, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(CreateAccountActivity.this, "Register Successfully", Toast.LENGTH_LONG).show();
                        clearEdittext();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(CreateAccountActivity.this, "Register Failed" + fault.getCode(), Toast.LENGTH_LONG).show();
                        Log.d("LOGIN", fault.getMessage());
                        Log.d("LOGIN", fault.getDetail());
                    }
                });
            }
            else {Toast.makeText(CreateAccountActivity.this, "Password should be same", Toast.LENGTH_LONG).show();}
            }
        });

    }

    public void clearEdittext()
    {
        edtname.setText("");
        edtadresse.setText("");
        edtconfirmpass.setText("");
        edtemail.setText("");
        edtpassword.setText("");
        edttelephone.setText("");
    }

}
