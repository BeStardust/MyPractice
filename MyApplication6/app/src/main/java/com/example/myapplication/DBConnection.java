package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection extends SQLiteOpenHelper {
    static final String DB_name = "UserID.db";
    SQLiteDatabase db;
    static final int Database_Version = 1;

    DBConnection(Context ctx) {
        super(ctx, DB_name, null, Database_Version);
    }

    public void onCreate(SQLiteDatabase database) {

        String TABLE_NAME = "Users";
        String ID = "ID";
        String USER_NAME = "USER_NAME";
        String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME +
                "(" + ID + " INTEGER primary key," +
                USER_NAME + " text not null" +
                ");";
        //       db = openOrCreateDatabase(DB_name, Context.MODE_PRIVATE, null);
        database.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}