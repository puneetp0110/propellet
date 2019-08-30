package com.example.medicationapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.medicationapp.model.DataBaseNote;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "medication_dB";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseNote.CREATE_TABLE);
    }

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseNote.TABLE_NAME);

        onCreate(db);

    }

    public long insertNode(String id,String descriptionName, String descriptionTimestamp, String typeDescription){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseNote.ID, id);
        values.put(DataBaseNote.DESCRIPTION_NAME, descriptionName);
        values.put(DataBaseNote.DESCRIPTION_TIMESTATMP, descriptionTimestamp);
        values.put(DataBaseNote.TYPE_DESCRIPTION, typeDescription);

        long note = db.insert(DataBaseNote.TABLE_NAME,null,values);

        db.close();

        return note;
    }


    public DataBaseNote getDataBaseNote(long id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataBaseNote.TABLE_NAME,new String[]{DataBaseNote.ID, DataBaseNote.DESCRIPTION_NAME,
                        DataBaseNote.TYPE_DESCRIPTION,DataBaseNote.DESCRIPTION_TIMESTATMP},
                DataBaseNote.ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor!=null){
            cursor.moveToFirst();
        }

        DataBaseNote dataBaseNote = new DataBaseNote(
                cursor.getString(cursor.getColumnIndex(DataBaseNote.ID)),
                cursor.getString(cursor.getColumnIndex(DataBaseNote.TYPE_DESCRIPTION)),
                cursor.getString(cursor.getColumnIndex(DataBaseNote.DESCRIPTION_NAME)),
                cursor.getString(cursor.getColumnIndex(DataBaseNote.DESCRIPTION_TIMESTATMP)));

        cursor.close();

        return dataBaseNote;
    }

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
                dataBaseNote.setId(cursor.getString(cursor.getColumnIndex(DataBaseNote.ID)));
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
    public int getDatabaseNoteCount() {
        String countQuery = "SELECT  * FROM " + DataBaseNote.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }
    public int updateDataBaseNote(DataBaseNote dataBaseNote) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBaseNote.DESCRIPTION_NAME, dataBaseNote.getName());
        values.put(DataBaseNote.DESCRIPTION_TIMESTATMP, dataBaseNote.getTimestamp());
        values.put(DataBaseNote.TYPE_DESCRIPTION, dataBaseNote.getTypeDescription());
        values.put(DataBaseNote.ID, dataBaseNote.getId());

        // updating row
        return db.update(dataBaseNote.TABLE_NAME, values, dataBaseNote.ID + " = ?",
                new String[]{String.valueOf(dataBaseNote.getId())});
    }

    public void deleteDataBaseNote(DataBaseNote dataBaseNote) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DataBaseNote.TABLE_NAME, DataBaseNote.ID + " =?",
                new String[]{String.valueOf(dataBaseNote.getId())});
        db.close();
    }
    public void removeAll()
    {
        SQLiteDatabase db = this.getWritableDatabase(); // helper is object extends SQLiteOpenHelper
        db.delete(DataBaseNote.TABLE_NAME, null, null);
    }
}
