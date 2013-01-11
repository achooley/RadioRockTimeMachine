package com.example.Rock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.LoginFilter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 10.01.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class AudioDBManager {

    private static AudioDBManager ourInstance;
    private static DBhelper DBTrackHelper;
    private static Context context;
    private static SQLiteDatabase db;
    private ContentValues Values;

    public static synchronized AudioDBManager getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AudioDBManager(context);
        }
        return ourInstance;
    }
    private AudioDBManager(Context context) {
        DBTrackHelper=new DBhelper(context);

    }

    public long AddNewTrack(List<Audio> list){
        db= DBTrackHelper.getWritableDatabase();
        Values=new ContentValues();
        StringBuilder query=null;

        long result=0;

        if(list==null)
            return 0;

        for(Audio l:list){

            try {
                Cursor c=db.rawQuery("SELECT * FROM "+DBTrackHelper.Table_Name+ " WHERE "
                                     +DBTrackHelper.Track_Name+ "= ?",new String[]{l.getSongName()});


                if(c.getCount()==0){
                    Values.put(DBTrackHelper.Track_Artist, l.getArtist());
                    Values.put(DBTrackHelper.Track_Name,l.getSongName());
                    Values.put(DBTrackHelper.Track_time,l.getDuration());

                    result=db.insert(DBTrackHelper.Table_Name,null,Values);
                }
            } catch (SQLException e) {
               Log.e(this.getClass().getName(),e.toString());
            }
        }
        db.close();


        return result;
    }
    public List<Audio> getDBAudio()
    {
          List<Audio>result=new ArrayList<Audio>();
        return null;
    }
    public int getAudioCount()
    {
        db= DBTrackHelper.getWritableDatabase();
        try {
            //Cursor c=db.rawQuery("SELECT COUNT (id) FROM " + DBTrackHelper.Table_Name, null);
             Cursor c=db.query(DBTrackHelper.Table_Name,null,null,null,null,null,null);
            return  c.getCount();
        } catch (SQLException e) {
            Log.e(this.getClass().getName(),e.toString());
        }
        return -1;
    }
}
