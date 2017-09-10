package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserTokenStorageFactory;
import com.bingo.bingo.R;

public class SplashScreenActivity extends AppCompatActivity {
    private static int splash_time=2500;
    private String userToken;
    private Intent start;
    public static final String App_ID="6489B38C-DCC1-9240-FF77-984DC15FAB00";
    public static final String Secret_Key="D8D8428D-0D09-2B26-FFDB-0CB665428700";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
         Backendless.initApp(this,App_ID,Secret_Key);
        //Check if user already logged
        userToken = UserTokenStorageFactory.instance().getStorage().get();
       // start= new Intent(SplashScreenActivity.this,MainActivity.class);
        //Launch Splash Screen

if (userToken!=null && !userToken.equals(""))
{
    String currentUserid=Backendless.UserService.loggedInUser();
    if (!currentUserid.equals(""))
    {
        Backendless.UserService.findById(currentUserid, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Log.d("DEBUG", response.toString());
                Backendless.UserService.setCurrentUser(response);
                start=new Intent(SplashScreenActivity.this,MainActivity.class);
            start.putExtra("User Info", response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }
}else {
    new Handler().postDelayed(new Runnable(){
        public void run(){
            start = new Intent(SplashScreenActivity.this, SignInActivity.class);
            startActivity(start);
            finish();
        }
    },splash_time);
}


    }
}
