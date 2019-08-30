package com.example.medicationapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.medicationapp.R;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.fragments.AddMedicationFragment;
import com.example.medicationapp.fragments.MainFragment;
import com.example.medicationapp.fragments.MedicationDetailsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements MedicationDetailsFragment.OnMedicationDetailsFragmentListener, MainFragment.OnMainFragmentInteractionListener, BottomNavigationView.OnNavigationItemSelectedListener {

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
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        //loadFragment(new MainFragment());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_add_medication)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    private boolean loadFragment(Fragment fragment){

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main,fragment).commit();

            return true;
        }

        return false;
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onMedicationDetailsFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment =null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new MainFragment();
                break;
            case R.id.navigation_add_medication:
                fragment = new AddMedicationFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
