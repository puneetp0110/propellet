package com.example.medicationapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicationapp.R;
import com.example.medicationapp.model.Medications;

public class MedicationsViewHolder extends RecyclerView.ViewHolder {

    private TextView medicationId;
    private TextView medicationName;
    private TextView medicationType;
    private TextView medicationTimestamp;

    public MedicationsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.medicationId = (TextView)itemView.findViewById(R.id.medication_info);
        this.medicationName = (TextView)itemView.findViewById(R.id.medication_name);
        this.medicationType = (TextView)itemView.findViewById(R.id.medication_type);
        this.medicationTimestamp = (TextView)itemView.findViewById(R.id.medication_timestamp);
    }
    public void updateUI(Medications medications){

        medicationId.setText(medications.getEventId());
        medicationName.setText(medications.getMedicationName());
        medicationType.setText(medications.getMedicationType());
        medicationTimestamp.setText(medications.getTimeStamp());
    }
}
