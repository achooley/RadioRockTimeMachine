package com.example.Rock;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Alexander Chooley
 * E-mail: alexander.chooley@gmail.com
 * User: Alex
 * Date: 04.01.13
 * Time: 17:45
 */


public class DBhelper extends SQLiteOpenHelper {

    public final String DBname="AudioDB";

    public final String Table_Artist="Artist";
    public final String Artist_id="id";
    public final String Artist_Name="Name";

    public final String Table_Track="Track";
    public final String Track_id="id";
    public final String Track_Name="Name";
    public final String Track_Artist="Artist";





    public DBhelper(Context context) {
        // конструктор суперкласса
        super(context,"AudioDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("CreateDB", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table Artist ("
                + "id integer primary key autoincrement,"
                + "Name text,"
                + "email text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

