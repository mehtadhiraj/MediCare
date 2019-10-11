package com.example.dhirajmehta.medicare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DashFragment extends Fragment {

    TextView sample;
    DatabaseReference databaseReference;
    Button mapbut;

    public  List<String> diseases ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dashboard = inflater.inflate(R.layout.dashboard, container, false);
//        RecyclerView diseasesRecycler = dashboard.findViewById(R.id.diseasesView);
//        String value = getArguments().getString("symptoms");
//        Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
//        diseases = new ArrayList<>();
//        diseases.add("Malaria");
//        diseases.add("Pnemonia");
//        diseases.add("Cancer");
//        DiseaseAdpater adapter = new DiseaseAdpater(getActivity(),diseases);
//        diseasesRecycler.setAdapter(adapter);
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        diseasesRecycler.setLayoutManager(manager);
        return dashboard;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sample = (TextView)view.findViewById(R.id.sample_text);
        mapbut = (Button)view.findViewById(R.id.map_button);



        mapbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MapActivity.class);
                startActivity(intent);
            }
        });

        if(getArguments().getString("Symptoms") != null){
            final String symptoms = getArguments().getString("Symptoms");
//            sample.setText(getArguments().getString("Symptoms"));
            databaseReference = FirebaseDatabase.getInstance().getReference();
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    LayoutInflater inflater = null;
                    ViewGroup container = null;
//                    View dashboard = inflater.inflate(R.layout.dashboard, container, false);
                    RecyclerView diseasesRecycler = view.findViewById(R.id.diseasesView);
                    diseases = new ArrayList<>();
                    String value = dataSnapshot.child(symptoms).getValue().toString();
                    diseases.add(value);
//                    sample.setText(value);
                    DiseaseAdpater adapter = new DiseaseAdpater(getActivity(),diseases);
                    diseasesRecycler.setAdapter(adapter);
                    LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                    diseasesRecycler.setLayoutManager(manager);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            ArrayList<String> diseasesList = getArguments().getStringArrayList("ListSymptoms");

        }

    }
}
