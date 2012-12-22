package com.example.Rock;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton
 * Date: 22.12.12
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class VkApi {

    private static VkApi ourInstance = new VkApi();

    public static VkApi getInstance() {
        return ourInstance;
    }

    private VkApi() {
    }

//    public List<Audio> getMyAudioList()
//    {
//
//
//    }
}
