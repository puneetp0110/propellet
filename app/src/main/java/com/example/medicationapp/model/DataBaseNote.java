package com.example.medicationapp.model;

public class DataBaseNote {
    public static final String TYPE_DESCRIPTION ="typeDesciption";
    public static final String ID = "description_id";
    public static final String TABLE_NAME = "description";
    public static final String DESCRIPTION_TIMESTATMP = "timestamp";
    public static final String DESCRIPTION_NAME = "name";
    private String id;
    private String timestamp;
    private String name;
    private String typeDescription;


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + ID + " TEXT,"
                    + DESCRIPTION_NAME + " TEXT,"+ TYPE_DESCRIPTION + " TEXT," + DESCRIPTION_TIMESTATMP + " TEXT" + " )";



    public DataBaseNote(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public DataBaseNote(String id, String timestamp, String name, String typeDescription) {
        this.id = id;
        this.timestamp = timestamp;
        this.name = name;
        this.typeDescription = typeDescription;
    }
}

