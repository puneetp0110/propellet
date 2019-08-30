package com.example.medicationapp.model;

public class Medications {
    private int eventId;
    private String medicationName;
    private String medicationType;
    private String timeStamp;
    /**
        * Getter for retrieving Id
     */
    public int getEventId() {
        return eventId;
    }
    /**
     * Getter for getting medicationName
     */
    public String getMedicationName() {
        return medicationName;
    }
    /**
     * Getter for medicationType
     */
    public String getMedicationType() {
        return medicationType;
    }
    /**
     * Getter for timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
        * Constructor
        * Function: initalizing Input arguments.
        * Input Arguments: eventId, medicationName, medicationType, timeStamp
     */
    public Medications(int eventId, String medicationName, String medicationType, String timeStamp) {
        this.eventId = eventId;
        this.medicationName = medicationName;
        this.medicationType = medicationType;
        this.timeStamp = timeStamp;
    }
}
