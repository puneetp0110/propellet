package com.example.medicationapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.example.medicationapp.R;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.fragments.MainFragment;
import com.example.medicationapp.fragments.MedicationDetailsFragment;

public class HomeActivity extends AppCompatActivity implements MedicationDetailsFragment.OnMedicationDetailsFragmentListener, MainFragment.OnMainFragmentInteractionListener {

    DataBaseHelper db;

    public DataBaseHelper getDb() {
        return db;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DataBaseHelper(getApplicationContext());
        FragmentManager fm = getSupportFragmentManager();

        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            fm.beginTransaction().add(R.id.container_main, mainFragment).commit();
        }
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onMedicationDetailsFragmentInteraction(Uri uri) {

    }
}
