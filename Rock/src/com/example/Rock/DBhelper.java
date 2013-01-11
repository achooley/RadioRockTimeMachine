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

    public final String DBname="VKAudioDB";

    public final String Table_Name="Track";
    public final String Track_id="id";
    public final String Table_Audio="Artist";
    public final String Track_Name="Name";
    public final String Track_Artist="Artist";
    public final String Track_time="Time";
    public final String Track_SDPath="SDPath";

   public DBhelper(Context context) {
        // конструктор суперкласса
        super(context,"VKAudioDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("CreateDB", "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table "+Table_Name+" ("
                + "id integer primary key autoincrement,"
                + Track_Name    +" text,"
                + Track_Artist  +" text,"
                + Track_time    +" text,"
                + Track_SDPath  +" text"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

