package com.example.weather_try_again;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView textViewWeather;

    private final String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=Самара&appid=7e02e97f0115c74ddcc1fbd37f69a39f&lang=ru&units=metric";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewWeather = findViewById(R.id.textViewDescWeather);

        DownloadWeatherTask downloadTask = new DownloadWeatherTask();
        downloadTask.execute(weatherURL);
    }

    public void Send_weather(View view) {

    }

    private class DownloadWeatherTask extends AsyncTask <String, Void, String> {


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
                while (line != null){
                    result.append(line);
                    line = reader.readLine();
                }
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (urlConnection != null){
                    urlConnection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("MyName", s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String city = jsonObject.getString("name");
                String temp = jsonObject.getJSONObject("main").getString("temp");
                String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
                String weather = String.format("%s \nТемпература: %s \nНа улице: %s", city,temp,description);
                textViewWeather.setText(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }



}