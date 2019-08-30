package com.example.medicationapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.medicationapp.model.DataBaseNote;
import java.util.ArrayList;
import java.util.List;

/**
    * DataBaseHelper class:
    * function - This class is used to get data from sqlite local database
 */

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "medication_dB";

    /**
     * @param db
     * create new table
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseNote.CREATE_TABLE);
    }

    /**
     * @param context
     * constructor for creating
     * new table by name DATABASE_NAME
     */
    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * @param db
     * @param oldVersion
     * @param newVersion
     * For updating database
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseNote.TABLE_NAME);

        onCreate(db);

    }

    /**
     * insertNode:
     * input Arguments: descriptionName, descriptionTimestamp, typeDescription
     * function - add descriptionName, descriptionTimestamp, typeDescription into database
     */
    public void insertNode(String descriptionName, String descriptionTimestamp, String typeDescription) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(DataBaseNote.ID, id);
        values.put(DataBaseNote.DESCRIPTION_NAME, descriptionName);
        values.put(DataBaseNote.DESCRIPTION_TIMESTATMP, descriptionTimestamp);
        values.put(DataBaseNote.TYPE_DESCRIPTION, typeDescription);

        db.close();
    }
    /**
     * @return List<DataBaseNote> - list of all the
     * elements in the databasenote
     * getAllDataBaseNote:
     */
    public List<DataBaseNote> getAllDataBaseNote() {
        List<DataBaseNote> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DataBaseNote.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataBaseNote dataBaseNote = new DataBaseNote();
                dataBaseNote.setId(cursor.getInt(cursor.getColumnIndex(DataBaseNote.ID)));
                dataBaseNote.setTypeDescription(cursor.getString(cursor.getColumnIndex(DataBaseNote.TYPE_DESCRIPTION)));
                dataBaseNote.setName(cursor.getString(cursor.getColumnIndex(DataBaseNote.DESCRIPTION_NAME)));
                dataBaseNote.setTimestamp(cursor.getString(cursor.getColumnIndex(DataBaseNote.DESCRIPTION_TIMESTATMP)));

                notes.add(dataBaseNote);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }
    /**
        * removeAll
        * function: Removes all the data from database
     */
    public void removeAll() {
        SQLiteDatabase db = this.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(DataBaseNote.TABLE_NAME, null, null);
    }
}
