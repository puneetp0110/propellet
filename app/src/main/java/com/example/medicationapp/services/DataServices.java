package com.example.medicationapp.services;

import com.example.medicationapp.model.Medications;

import java.util.ArrayList;

public class DataServices {
    private static final DataServices ourInstance = new DataServices();

    public static DataServices getInstance() {
        return ourInstance;
    }

    private DataServices() {
    }

    public ArrayList<Medications> getMedicationsDetails(String eventId, String medicationName, String medicationType, String timeStamp){

        ArrayList<Medications> medicationsList = new ArrayList<>();

        medicationsList.add(new Medications(eventId, medicationName, medicationType, timeStamp));

        return medicationsList;
    }
}
