package com.example.comp3074_lab07.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "library.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "books";
    private static final String COL_ID = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_AUTHOR = "author";
    private static final String COL_GENRE = "genre";
    private static final String COL_YEAR = "year";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = String.format("CREATE TABLE %s " +
                "(%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "%s TEXT, " +
                "%s TEXT, " +
                "%s TEXT, " +
                "%s INTEGER)",
                TABLE_NAME,
                COL_ID,
                COL_TITLE,
                COL_AUTHOR,
                COL_GENRE,
                COL_YEAR);

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTS %s", TABLE_NAME));
    }

    public long addBook(String title, String author, String genre, int year) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_AUTHOR, author);
        cv.put(COL_GENRE, genre);
        cv.put(COL_YEAR, year);
        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }
}
