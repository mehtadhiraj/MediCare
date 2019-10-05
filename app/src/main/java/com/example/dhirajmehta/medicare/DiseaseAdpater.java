package com.example.dhirajmehta.medicare;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DiseaseAdpater extends RecyclerView.Adapter<DiseaseAdpater.ViewHolder> {
    Context context;
    List<String> diseases;

    public DiseaseAdpater(Context context, List<String> diseases) {
        this.context = context;
        this.diseases = diseases;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return(new ViewHolder(LayoutInflater.from(context).inflate(R.layout.dashcard, viewGroup, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String disease = diseases.get(i);
        viewHolder.diseaseName.setText(disease);
    }

    @Override
    public int getItemCount() {
        return diseases.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView diseaseName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            diseaseName = itemView.findViewById(R.id.diseasesname);

        }
    }
}

