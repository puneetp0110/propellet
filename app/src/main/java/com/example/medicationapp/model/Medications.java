package com.example.medicationapp.model;

public class Medications {
    private String eventId;

    public String getEventId() {
        return eventId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getMedicationType() {
        return medicationType;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    private String medicationName;
    private String medicationType;
    private String timeStamp;


    public Medications(String eventId, String medicationName, String medicationType, String timeStamp) {
        this.eventId = eventId;
        this.medicationName = medicationName;
        this.medicationType = medicationType;
        this.timeStamp = timeStamp;
    }
}
