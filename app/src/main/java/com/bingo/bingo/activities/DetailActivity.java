package com.bingo.bingo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bingo.bingo.R;
import com.bingo.bingo.models.Entreprise;
import com.squareup.picasso.Picasso;

import static com.bingo.bingo.R.id.ivEntrepriseDetail;

public class DetailActivity extends AppCompatActivity {



    ImageView ivEntreprise;
    TextView tvEntrepriseName;
    TextView tvEntrepriseAdresse;
    TextView tvEntreprisePhone;
    TextView tvEntrepriseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbardetail);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.drawable.ic_returnback);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Enable up icon
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        Entreprise entreprise = (Entreprise) getIntent().getSerializableExtra("Entreprise");


        tvEntrepriseName = (TextView)findViewById(R.id.tvEntrepriseName);
        tvEntrepriseName.setText(entreprise.getNomEntreprise());

        tvEntrepriseDescription = (TextView) findViewById(R.id.tvEntrepriseDescription);
        tvEntrepriseDescription.setText(entreprise.getDescriptionEntreprise());

        tvEntrepriseAdresse = (TextView) findViewById(R.id.tvEntrepriseAdresse);
        tvEntrepriseAdresse.setText(entreprise.getAdresseEntreprise());

        tvEntreprisePhone = (TextView) findViewById(R.id.tvEntreprisePhone);
        tvEntreprisePhone.setText(entreprise.getPhoneEntreprise());


        ivEntreprise = (ImageView) findViewById(ivEntrepriseDetail);
        Picasso.with(this).load(entreprise.getImageEntreprise())
                .into(ivEntreprise);




    }


    //private ShareActionProvider mShareActionProvider;
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // This is the up button
            case R.id.miShare:
                sharingIntent();
                // overridePendingTransition(R.animator.anim_left, R.animator.anim_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void sharingIntent(){

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, tvEntrepriseName.getText().toString() + " / " +
                tvEntrepriseAdresse.getText().toString() +
                " / " + tvEntreprisePhone.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }





}
