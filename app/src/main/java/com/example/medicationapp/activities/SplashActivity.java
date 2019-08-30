package com.example.medicationapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.example.medicationapp.R;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.fragments.MainFragment;
import com.example.medicationapp.fragments.MedicationDetailsFragment;
import com.example.medicationapp.network.API;

public class SplashActivity extends AppCompatActivity implements MedicationDetailsFragment.OnMedicationDetailsFragmentListener, MainFragment.OnMainFragmentInteractionListener {

    DataBaseHelper db;
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DataBaseHelper(getApplicationContext());
        db.removeAll(); // Make sure to remove this at the end
        setContentView(R.layout.activity_splash);
        API api = new API(this,db);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    public void onMedicationDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }
}

