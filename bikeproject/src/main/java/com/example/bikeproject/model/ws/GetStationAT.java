package com.example.bikeproject.model.ws;

import android.os.AsyncTask;

import com.example.bikeproject.model.beans.Station;

import java.util.ArrayList;

public class GetStationAT extends AsyncTask {
    private ArrayList<Station> stations;
    private Exception exception;
    private GetStationATResult getStationATResult;

    public GetStationAT(GetStationATResult getStationATResult) {
        this.getStationATResult = getStationATResult;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try {
            stations = WSUtils.getStation();
        }
        catch (Exception e) {
            exception = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (getStationATResult != null) {
            if (exception != null) {
                getStationATResult.getStationATResultErreur(exception);
            }
            else {
                getStationATResult.stationChargees(stations);
            }
        }
    }

    public interface GetStationATResult {
        void stationChargees(ArrayList<Station> stations);

        void getStationATResultErreur(Exception exception);
    }
}
