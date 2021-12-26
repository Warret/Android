package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    private EditText editTextName;
    private TextView textViewInfo;


    private final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=9d531d64f398b41174e03c034ffb8be7&lang=ru&units=metric";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        textViewInfo = findViewById(R.id.textViewСity);
    }

    public void onClickWeather(View view) {
        String city = editTextName.getText().toString().trim();
        if (!city.isEmpty()) {
            findWeather task = new findWeather();
            String url = String.format(WEATHER_URL, city);
            task.execute(url);
        } else {
            Toast.makeText(getApplicationContext(), "Заполните поле", Toast.LENGTH_SHORT);
        }
    }

    private class findWeather extends AsyncTask<String, Void, String> {
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
            Log.i("MyName", s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String city = jsonObject.getString("name");
                String temp = jsonObject.getJSONObject("main").getString("temp");
                String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
                String weather = String.format("Город:%s\nТемпература: %s\nНа улице: %s", city, temp, description);
                textViewInfo.setText(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
