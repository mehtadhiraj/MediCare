package com.example.dhirajmehta.medicare;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
//import android.view.View;
//import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
//import android.widget.Toast;
//
//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.SendMessage {

    private TextView mTextMessage;
    //    CheckBox cold, cough, fever, headache, giddyness, stomachache;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new DashFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new NotifFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void sendSymptoms(String message, ArrayList<String> diseaseList) {
        DashFragment dashFragment = new DashFragment();
        Bundle args = new Bundle();
        args.putString("Symptoms", message);
        args.putStringArrayList("ListSymptoms",diseaseList);
        dashFragment.setArguments(args);
        loadFragment(dashFragment);
    }

//    void submitSymptoms(View view){
//        // Fetching from database code goes here.
//        ArrayList<String> diseasesList = new ArrayList<String>();
//        String symptoms = "";
//        cold        = findViewById(R.id.cold);
//        if(cold.isChecked()){
//            diseasesList.add("Cold");
//            symptoms = symptoms + "Cold, ";
//        }
//        cough       = findViewById(R.id.cough);
//        if(cough.isChecked()){
//            diseasesList.add("Cough");
//            symptoms = symptoms + "Cough, ";
//        }
//        fever       = findViewById(R.id.fever);
//        if(fever.isChecked()){
//            diseasesList.add("Fever");
//            symptoms = symptoms + "Fever, ";
//        }
//        headache    = findViewById(R.id.headache);
//        if(headache.isChecked()){
//            diseasesList.add("Headache");
//            symptoms = symptoms + "Headache, ";
//        }
//        giddyness   = findViewById(R.id.giddyness);
//        if(giddyness.isChecked()){
//            diseasesList.add("Giddyness");
//            symptoms = symptoms + "Giddyness, ";
//        }
//        stomachache = findViewById(R.id.stomachache);
//        if(stomachache.isChecked()){
//            diseasesList.add("Stomach Ache");
//            symptoms = symptoms + "Stomach Ache. ";
//        }
//        if(symptoms == ""){
//            symptoms = "No item selceted";
//        }
//        Toast.makeText(MainActivity.this, symptoms, Toast.LENGTH_SHORT).show();
//    }

}
