package com.example.Rock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class AudioManager {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    Token token;
    ArrayList<Audio> AudioList;

    public AudioManager(Token k){

        this.token=k;
        AudioList=new ArrayList<Audio>();

    }

    private JSONObject getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is), 8);

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {

            jObj = new JSONObject(json);




        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }
    public void RefreshAudioList(){
        JSONObject JsonaAdioList=getJSONFromUrl("https://api.vk.com/method/audio.get.json?access_token="+token.getToken());
        Audio track;
        try {
            JSONArray list=JsonaAdioList.getJSONArray("response");

            for(int i=0;i<list.length();i++)
            {

                JSONObject Track=list.getJSONObject(i);
                String Artist=Track.getString("artist");
                String Name=Track.getString("title");
                String Url=Track.getString("url");
                int duration= Integer.parseInt(Track.getString("duration"));

                track=new Audio(Artist, Name, Url,duration);
                Log.e("Track name ", Name);
                AudioList.add(track);
            }




        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public List<Audio> SearchAudio(String q)
    {
        List<Audio> response=new ArrayList<Audio>();
        JSONObject JsonaAdioList=getJSONFromUrl("https://api.vk.com/method/audio.search.json?access_token="+token.getToken()+"&q="+q+"&count=5");
        //JSONObject JsonaAdioList=getJSONFromUrl("https://api.vk.com/method/audio.search.json?access_token=e1bb1816000ee7bf95733a26efc178189fba4d9de173d06b057390fb4a31d09dec0afe005308ded767ba0&q=%D0%9C%D1%8B%20%D0%B5%D0%B4%D0%B5%D0%BC%20%D0%BA%20%D0%B6%D0%B5%D0%BD%D1%89%D0%B8%D0%BD%D0%B0%D0%BC%20%D0%9A%D1%83%D0%B7%D0%B8%D0%BD%20%D0%A1%D0%B5%D1%80%D0%B3%D0%B5%D0%B9%20%D0%B8%20%D0%91%D0%BE%D0%BB%D1%8C%D1%88%D0%BE%D0%B9%20%D0%90%D0%BB%D0%B5%D0%BA%D1%81%D0%B5%D0%B9&count=5");
        Audio track;
        try {
            JSONArray list=JsonaAdioList.getJSONArray("response");

            for(int i=1;i<list.length();i++)
            {

                JSONObject Track=list.getJSONObject(i);
                String Artist=Track.getString("artist");
                String Name=Track.getString("title");
                String Url=Track.getString("url");
                int duration= Integer.parseInt(Track.getString("duration"));

                track=new Audio(Artist, Name, Url,duration);
               // Log.e("Track name ", Name);
                response.add(track);
            }




        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;
    }
}