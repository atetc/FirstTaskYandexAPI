package com.example.yasina.firsttask.server;

import android.location.Location;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by yasina on 14.09.2015.
 */
public class ServerBuilder {

    public static final OkHttpClient client = new OkHttpClient();
    public static final MediaType mediaType_json = MediaType.parse("application/json; charset=utf-8");

    private static final String yandexURL = "https://geocode-maps.yandex.ru/1.x";

    public static void get(String url, Callback callback){
        Request request = new Request.Builder()
                .header("Host", "geocode-maps.yandex.ru")
                .addHeader("Cookie","yandexuid=2570136721424282212")
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static String getFullYandexURL(Location myLocation, int result){
        return yandexURL + "/?&geocode=" + myLocation + "&format=json" + "&results=" + result;
    }

}
