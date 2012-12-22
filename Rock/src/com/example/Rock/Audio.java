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

    public Audio(String Artist,String SongName,String Url) {
        setArtist(Artist);
        setSongName(SongName);
        setUrl(Url);
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

}
