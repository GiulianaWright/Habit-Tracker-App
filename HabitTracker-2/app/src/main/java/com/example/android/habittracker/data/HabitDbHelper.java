package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.data.HabitContract.HabitEntry;


/**
 * Database helper for Habit Tracker app. Manages database creation and version management.
 */
public class HabitDbHelper extends SQLiteOpenHelper {


    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();


    /** Name of the database file */
    private static final String DATABASE_NAME = "habittracker.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link HabitDbHelper}.
     *
     * @param context of the app
     */
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i(LOG_TAG, "in HabitDbHelper: ");
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "in onCreate SQLiteDatabase first line: ");
        // Create a String that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE =  "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_DURATION + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_FREQUENCY + " INTEGER NOT NULL); ";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
        Log.i(LOG_TAG, "in onCreate SQLiteDatabase last line: ");
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }/**
     * This is called when the database needs to be upgraded.
     */


}