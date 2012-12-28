package com.example.Rock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ArrayList<Audio> Songs;
    TextView token;
    ListView lvMain;
    Token ac_token;
    private WebView web;
    SongAdapter adapter;
    AudioManager manager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
                "Костя", "Игорь", "Анна", "Денис", "Андрей" };



        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lvMain= (ListView) findViewById(R.id.lvMain);
        token=(TextView)findViewById(R.id.token);
         Songs=new ArrayList<Audio>();

         Object temp = getLastNonConfigurationInstance();
        if (temp!= null) {
            Songs= (ArrayList<Audio>) temp;
            adapter=new SongAdapter(this,Songs);
            lvMain.setAdapter(adapter);
            Log.i("MAIN","set audio to adapter");
            temp=null;
        }
        else {

            Intent intent = new Intent(this, VkLogin.class);
            startActivityForResult(intent, 1);//
        }





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

//        Thread Get=new Thread(){
//
//            @Override
//            public void run() {
//                AudioManager manager=new AudioManager(ac_token);
//                manager.RefreshAudioList();
//                for(Audio f:manager.AudioList)
//                {
//                    Log.e("AUDIO url",f.getUrl());
//                }
//            }
//        };
//        Get.start();
                     manager=new AudioManager(ac_token);
                               manager.RefreshAudioList();

                 Songs.addAll(manager.AudioList);
                 adapter=new SongAdapter(this,Songs);
                   lvMain.setAdapter(adapter);

    }

    @Override
    public Object onRetainNonConfigurationInstance() {
         Log.i("MAIN","SAVE AUDIO List");
           return Songs;
    }
}
