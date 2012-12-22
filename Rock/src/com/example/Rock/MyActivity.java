package com.example.Rock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    TextView token;

    Token ac_token;
    private WebView web;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       token=(TextView)findViewById(R.id.token);
       Intent intent = new Intent(this, VkLogin.class);
     startActivityForResult(intent, 1);//
//        ac_token =new Token();
//        AudioManager manager=new AudioManager(ac_token);
//        manager.RefreshAudioList();
//        for(Audio f:manager.AudioList)
//        {
//            Log.e("AUDIO url",f.getUrl());
//        }
//        Thread d=new Thread(){
//
//            @Override
//            public void run() {
//                Document doc = null;
//                try {
//                    doc = Jsoup.connect("http://www.radioroks.com.ua/playlist?d=22-12-2012").get();
//                    Elements content = doc.getElementsByClass("songTitle");
//                    for(Element l:content){
//
//                         Elements o=l.select("span");
//                         String Artist=o.text();
//                         String SongName=l.text().substring(l.text().indexOf("-")+1);
//                        Log.e("Song ",Artist +"    "+ SongName);
//                        //Log.e("SONG NAME",SongName);
//
//                        //Log.e("SPAN",l.attr("span").toString());
//                        //System.out.print(l.select("a").attr("href"));
//                        // System.out.println(l.children().toString());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                }
//            }
//        };
//            d.start();



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
             Log.e("URL",data.getStringExtra("TOKEN"));

        ac_token=new Token();
        ac_token.setToken(data.getStringExtra("TOKEN"));

        Thread Get=new Thread(){

            @Override
            public void run() {
                AudioManager manager=new AudioManager(ac_token);
                manager.RefreshAudioList();
                for(Audio f:manager.AudioList)
                {
                    Log.e("AUDIO url",f.getUrl());
                }
            }
        };
        Get.start();



    }
}
