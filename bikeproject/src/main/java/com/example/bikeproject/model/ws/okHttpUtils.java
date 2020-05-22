package com.example.bikeproject.model.ws;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class okHttpUtils {
    public static <okHttpClient> Request sendGetOkHttpRequest(String url) {
        Log.w("TAG_URL", url);
        okHttpClient client = (okHttpClient) new OkHttpClient();

        //TO DO
        Request request = new Request.Builder().url(url).build();

        // Execution de la requete
        return request;
    }
}
