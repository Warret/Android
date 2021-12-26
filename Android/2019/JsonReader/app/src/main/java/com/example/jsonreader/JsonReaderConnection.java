package com.example.jsonreader;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class JsonReaderConnection extends AsyncTask<String, Void, ArrayAdapter<String>> {

    private final List<String> data;
    private ArrayAdapter<String> adapter = null;

    public JsonReaderConnection(List<String> data, ArrayAdapter<String> adapter) {
        this.data = data;
        this.adapter = adapter;
    }

    @Override
    protected ArrayAdapter<String> doInBackground(String... strings) {
        try {
            InputStream inputStream = downloadString(strings[0]);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            JsonReader jsonReader = new JsonReader(inputStreamReader);


            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String token = jsonReader.nextName();
                if (token.equals("Valute")) {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String val = jsonReader.nextName();
                        Log.i("12345", val);
                        String valName = "";
                        String valPrice = "";
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String key = jsonReader.nextName();
                            String value = jsonReader.nextString();
                            if (key.equals("Name")) {
                                valName = value;
                            }
                            if (key.equals("Value")) {
                                valPrice = value;
                            }
                        }
                            data.add(String.format("%s - %s (%s)", valName, valPrice, val));
                            jsonReader.endObject();


                    }
                    jsonReader.endObject();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return adapter;
    }


    private InputStream downloadString(String urlString) throws IOException {


        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setDoInput(true);

        connection.connect();
        return connection.getInputStream();

    }

    @Override
    protected void onPostExecute(ArrayAdapter<String> stringArrayAdapter) {
        super.onPostExecute(stringArrayAdapter);
        stringArrayAdapter.notifyDataSetChanged();
    }
}
