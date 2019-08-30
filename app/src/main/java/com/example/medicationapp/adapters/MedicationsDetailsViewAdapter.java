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

/**
    * Adaptor for implementing recycler view so we could dynamically
    * display data.
 */

public class MedicationsDetailsViewAdapter extends RecyclerView.Adapter<MedicationsViewHolder> {
    ArrayList<Medications> medicationsList;

    /**
     * @param medicationsList
     * constructor for intialzing medicationList
     */
    public MedicationsDetailsViewAdapter(ArrayList<Medications> medicationsList) {
        this.medicationsList = medicationsList;
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MedicationsViewHolder holder, int position) {
        Medications medication = medicationsList.get(position);
        holder.updateUI(medication);

    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return medicationsList.size();
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MedicationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View medicationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.medications_card, parent, false);
        return new MedicationsViewHolder(medicationCard);
    }
}
