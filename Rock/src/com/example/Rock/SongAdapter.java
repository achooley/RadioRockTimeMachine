package com.example.Rock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 24.12.12
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class SongAdapter extends BaseAdapter {
    private Context ctx;
    LayoutInflater lInflater;
    private ArrayList<Audio> songList;

    public SongAdapter(Context ctx, ArrayList<Audio> songList) {
        this.ctx = ctx;
        this.songList = songList;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return songList.size();//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int i) {
        return songList.get(i); //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int i) {
        return i;  //To change body of implemented methods use File | Settings | File Templates.
    }
    public Audio getAudio(int index){

       return (Audio)getItem(index);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View ListView = view;
        if (ListView == null) {
            ListView = lInflater.inflate(R.layout.songlistitem, viewGroup, false);
        }

        Audio song=getAudio(i);
        ((TextView) ListView.findViewById(R.id.Artist)).setText(song.getArtist());
        ((TextView) ListView.findViewById(R.id.SongName)).setText(song.getSongName());
        return ListView;
    }
}
