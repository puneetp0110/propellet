package com.example.medicationapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicationapp.R;
import com.example.medicationapp.holders.MedicationsViewHolder;
import com.example.medicationapp.model.Medications;

import java.util.ArrayList;

public class MedicationsDetailsViewAdapter extends RecyclerView.Adapter<MedicationsViewHolder> {
    ArrayList<Medications> medicationsList;

    public MedicationsDetailsViewAdapter(ArrayList<Medications> medicationsList) {
        this.medicationsList = medicationsList;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationsViewHolder holder, int position) {
        Medications medication = medicationsList.get(position);
        holder.updateUI(medication);

    }

    @Override
    public int getItemCount() {
        return medicationsList.size();
    }

    @NonNull
    @Override
    public MedicationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View medicationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.medications_card, parent, false  );
        return new MedicationsViewHolder(medicationCard);
    }
}
