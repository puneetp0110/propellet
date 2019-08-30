package com.example.medicationapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.medicationapp.R;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.fragments.AddMedicationFragment;
import com.example.medicationapp.fragments.MainFragment;
import com.example.medicationapp.fragments.MedicationDetailsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
/**
    *
    * db - DataBaseHelper class is imported
    * interface is imported so that activity methods can be used in fragments
    * BottomNavigator is implemented so user can move between adding medications fragments
    * and displaying.
 */

public class HomeActivity extends AppCompatActivity implements MedicationDetailsFragment.OnMedicationDetailsFragmentListener, MainFragment.OnMainFragmentInteractionListener, BottomNavigationView.OnNavigationItemSelectedListener, AddMedicationFragment.OnAddMedicationFragmentInteractionListener {

    DataBaseHelper db;

    public DataBaseHelper getDb() {
        return db;
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DataBaseHelper(getApplicationContext());
        FragmentManager fm = getSupportFragmentManager();

        MainFragment mainFragment = (MainFragment) fm.findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            fm.beginTransaction().add(R.id.container_main, mainFragment).commit();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

    }
    /**
     *
     * @param fragment
     * @return
     * loadFragment is used to load fragments based on fragments
     */
    public boolean loadFragment(Fragment fragment) {

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_main, fragment).commit();

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
    /**
        * onNavigationItemSelected: Based on event user would be able to
        * migrate between fragments.
     */
    /**
     *
     * @param menuItem
     * @return
     * onNavigationItemSelected: Based on event user would be able to
     * migrate between fragments.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

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

    @Override
    public void onAddMedicationFragmentInteraction(Uri uri) {

    }
}
