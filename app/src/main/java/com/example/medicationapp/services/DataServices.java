package com.example.medicationapp.services;

import com.example.medicationapp.model.Medications;

import java.util.ArrayList;
/**
    * Class for adding importing data from cloud.
    * currently this class is not being used because data is loaded directly
    * in MedicationDetailsFragment
 */
public class DataServices {
    private static final DataServices ourInstance = new DataServices();

    public static DataServices getInstance() {
        return ourInstance;
    }

    private DataServices() {
    }

    /**
     * @param eventId
     * @param medicationName
     * @param medicationType
     * @param timeStamp
     * @return
     */
    public ArrayList<Medications> getMedicationsDetails(int eventId, String medicationName, String medicationType, String timeStamp){

        ArrayList<Medications> medicationsList = new ArrayList<>();

        medicationsList.add(new Medications(eventId, medicationName, medicationType, timeStamp));

        return medicationsList;
    }
}
