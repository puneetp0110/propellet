package com.example.medicationapp.model;

public class DataBaseNote {
    /**
        * Parameters:
        * id: data for fields
        * timestamp: timestamp of the database
        * name: name of the medication in database
        * typeDescription: type of medication
        * Field Names of database- TYPE_DESCRIPTION, ID, TABLE_NAME, DESCRIPTION_TIMESTAMP, DESCRIPTION_NAME
     */
    public static final String TYPE_DESCRIPTION ="typeDesciption";
    public static final String ID = "description_id";
    public static final String TABLE_NAME = "description";
    public static final String DESCRIPTION_TIMESTATMP = "timestamp";
    public static final String DESCRIPTION_NAME = "name";
    private int id;
    private String timestamp;
    private String name;
    private String typeDescription;

    /**
        * Method for creating table by name TABLE_NAME
     */
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DESCRIPTION_NAME + " TEXT,"+ TYPE_DESCRIPTION + " TEXT," + DESCRIPTION_TIMESTATMP + " TEXT" + " )";

    public DataBaseNote(){

    }
    /**
        * Getter for ID
     */
    public int getId() {
        return id;
    }
    /**
        * Setter For ID
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
        * Getter for TimeStamp
     */
    public String getTimestamp() {
        return timestamp;
    }
    /**
        * Setter for timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * Getter for name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for typeDescription
     */
    public String getTypeDescription() {
        return typeDescription;
    }
    /**
     * Setter for typeDescription
     */
    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
    /**
        * constructor for intializing
        * id
        * timestamp
        * name
        * typeDescription
     */
    public DataBaseNote(int id, String timestamp, String name, String typeDescription) {
        this.id = id;
        this.timestamp = timestamp;
        this.name = name;
        this.typeDescription = typeDescription;
    }
}

