package com.example.Rock;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 18.12.12
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class VkLogin extends Activity {
    private WebView web;
    String token;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vklogin);
        web=(WebView)findViewById(R.id.WebLogin);
        CookieManager manager=CookieManager.getInstance();
        manager.removeAllCookie();

        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://oauth.vk.com/authorize?client_id=2827360&scope=audio&redirect_uri=http://oauth.vk.com/blank.html&display=wap&response_type=token");
        web.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished (WebView view, String url)
            {
                if(getParametersFromUrl(url).get("access_token")!=null)
                    Log.e("TOKEN",getParametersFromUrl(url).get("access_token")) ;

            }


        });

         //String token=getParametersFromUrl("https://oauth.vk.com/blank.html#access_token=534244990d5601c21759ed6e6fd5e18f5fed66ac0107e7332a6c9c22fae0dd8061d9b671d15579cff8d10&expires_in=86400&user_id=14364731").get("user_id)")



    }

    public static Map<String, String> getParametersFromUrl(String url)
    {

        Map<String, String> map = new HashMap<String, String>();




        String[] params = url.split("[#,&]");
        for (String param : params)
        {
            try {
                String name = param.split("=")[0];
                String value = param.split("=")[1];
                map.put(name, value);

            } catch (Exception e)

            {



            }

        }



        return map;

    }
}

