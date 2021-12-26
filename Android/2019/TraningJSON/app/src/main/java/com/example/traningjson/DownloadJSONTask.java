package com.example.traningjson;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadJSONTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        HttpURLConnection urlConnection = null;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                result.append(line);
                line = reader.readLine();
            }
            return result.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);


        try {

            JSONObject jsonObject = new JSONObject(s);
//            String date = jsonObject.getString("Date");
//            Log.i("myres", date);

//              JSONObject valute =  jsonObject.getJSONObject("Valute").getJSONObject("AUD");
//              String charCode = valute.getString("CharCode");
//              String Name = valute.getString("Name");
//              int value = valute.getInt("Value");
//            Log.i("myres", charCode +  " " + Name + " " +  value);

            
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}

