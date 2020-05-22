package com.example.bikeproject.model.ws;

import com.example.bikeproject.model.beans.Station;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import okhttp3.Request;
import okhttp3.Response;

public class WSUtils {
    private static final String KEY = "2f70b355156ec1c0550352c1f44b8ac6ce78393e";
    private static final String CONTRAT = "Lyon";
    private static final String URL = "https://api.jcdecaux.com/vls/v1/stations?contract=" + CONTRAT + "&apiKey=" + KEY;
    private static final Gson gson = new Gson();

    public static ArrayList<Station> getStation() throws Exception {

        Request response = okHttpUtils.sendGetOkHttpRequest(URL);

        if (response.hashCode() != HttpURLConnection.HTTP_OK) {
            throw new Exception("Réponse du serveur incorrecte " + response.hashCode());
        } else {
            // On lit le flux avec InputStreamReader
            assert response.body() != null;
            InputStreamReader isr = new InputStreamReader(response.body().byteStream());
            // On converti les fichiers gson du serveur en ArrayList java
            ArrayList<Station> stations = gson.fromJson(isr, new TypeToken<ArrayList<Station>>() {
            }.getType());
            // On ferme le flux
            isr.close();
            return stations;
        }
    }
}
