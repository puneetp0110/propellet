package com.example.medicationapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicationapp.R;
import com.example.medicationapp.model.Medications;


/**
    * Holder for holding space for displaying and updating UI based on
    * medicationId - Id of every item on database
    * medicationName - Name of the medication used by People
    * medicationType - Type of Medication
    * medicationTimestamp - Timestamp for medication
 */

public class MedicationsViewHolder extends RecyclerView.ViewHolder {

    private TextView medicationId;
    private TextView medicationName;
    private TextView medicationType;
    private TextView medicationTimestamp;

    /**
     * @param itemView
     * Constructor:
     *         * linking medicationId, medicationName, medicationType, medicationType, medicationTimestamp
     *         * with with textview
     */
    public MedicationsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.medicationId = (TextView)itemView.findViewById(R.id.medication_info);
        this.medicationName = (TextView)itemView.findViewById(R.id.medication_name);
        this.medicationType = (TextView)itemView.findViewById(R.id.medication_type);
        this.medicationTimestamp = (TextView)itemView.findViewById(R.id.medication_timestamp);
    }
    /**
     * @param medications
     * Updating UI based on Medications model
     */
    public void updateUI(Medications medications){

        medicationId.setText(""+medications.getEventId());
        medicationName.setText(medications.getMedicationName());
        medicationType.setText(medications.getMedicationType());
        medicationTimestamp.setText(medications.getTimeStamp());
    }
}
