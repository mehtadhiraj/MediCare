package com.example.dhirajmehta.medicare;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment  extends Fragment {

    SendMessage SM;

    Button submit;
    View rootview;
    CheckBox cold, cough, fever, headache, giddyness, stomachache;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.home,container,false);
        submit = rootview.findViewById(R.id.submitSymptoms);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitSymptoms(v);
            }
        });

        return rootview;
    }
    void submitSymptoms(View view){
        // Fetching from database code goes here.
        ArrayList<String> diseasesList = new ArrayList<String>();
        String symptoms = "";
        cold        = rootview.findViewById(R.id.cold);
        if(cold.isChecked()){
            diseasesList.add("Cold");
            symptoms = symptoms + "Cold, ";
        }
        cough       = rootview.findViewById(R.id.cough);
        if(cough.isChecked()){
            diseasesList.add("Cough");
            symptoms = symptoms + "Cough, ";
        }
        fever       = rootview.findViewById(R.id.fever);
        if(fever.isChecked()){
            diseasesList.add("Fever");
            symptoms = symptoms + "Fever, ";
        }
        headache    = rootview.findViewById(R.id.headache);
        if(headache.isChecked()){
            diseasesList.add("Headache");
            symptoms = symptoms + "Headache, ";
        }
        giddyness   = rootview.findViewById(R.id.giddyness);
        if(giddyness.isChecked()){
            diseasesList.add("Giddyness");
            symptoms = symptoms + "Giddyness, ";
        }
        stomachache = rootview.findViewById(R.id.stomachache);
        if(stomachache.isChecked()){
            diseasesList.add("Stomach Ache");
            symptoms = symptoms + "Stomach Ache. ";
        }
        if(symptoms == ""){
            symptoms = "No item selceted";
        }else{
            Log.d("HOME Fragment",symptoms);
//            DashFragment fragment = new DashFragment();
//            Bundle symptomsBundle = new Bundle();
//            symptomsBundle.putString("symptoms", symptoms);
//            fragment.setArguments(symptomsBundle);

            SM.sendSymptoms(symptoms,diseasesList);
            //Inflate the fragment
//            getFragmentManager().beginTransaction().add(R.id.diseasesView, fragment).commit();
        }
        Toast.makeText(getContext(), symptoms, Toast.LENGTH_SHORT).show();


    }
    interface SendMessage {
        void sendSymptoms(String message, ArrayList<String> diseasesList);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

}