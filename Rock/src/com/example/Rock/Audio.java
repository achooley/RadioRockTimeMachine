package com.example.Rock;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 22.12.12
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class Audio {
    private String SongName;
    private String Artist;
    private String Url;

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    private int Duration;
    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }



    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }



    public Audio(String Artist,String SongName,String Url,int duration) {
        setArtist(Artist);
        setSongName(SongName);
        setUrl(Url);
        setDuration(duration);
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }



}
