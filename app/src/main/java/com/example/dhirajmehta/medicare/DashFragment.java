package com.example.dhirajmehta.medicare;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DashFragment extends Fragment {

    public  List<String> diseases ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View dashboard = inflater.inflate(R.layout.dashboard, container, false);
        RecyclerView diseasesRecycler = dashboard.findViewById(R.id.diseasesView);
        String value = getArguments().getString("symptoms");
        Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();

        diseases = new ArrayList<>();


        diseases.add("Malaria");
        diseases.add("Pnemonia");
        diseases.add("Cancer");


        DiseaseAdpater adapter = new DiseaseAdpater(getActivity(),diseases);
        diseasesRecycler.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        diseasesRecycler.setLayoutManager(manager);
        return dashboard;
    }
}
