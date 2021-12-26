package com.example.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ModuleInfo;
import android.net.Network;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mymovies.data.Movie;
import com.example.mymovies.utils.JSONUtils;
import com.example.mymovies.utils.NetworkUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPosters;
    private MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPosters = findViewById(R.id.recyclerViewPosters);
        recyclerViewPosters.setLayoutManager(new GridLayoutManager(this,2));
        movieAdapter = new MovieAdapter();
        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(NetworkUtils.POPULARITY,1);
        ArrayList<Movie> movies = JSONUtils.getMoviesFromJSON(jsonObject);
        movieAdapter.setMovies(movies);
        recyclerViewPosters.setAdapter(movieAdapter);


//        JSONObject jsonObject = NetworkUtils.getJSONFromNetwork(NetworkUtils.POPULARITY, 5);
//        ArrayList<Movie> movies = JSONUtils.getMoviesFromJSON(jsonObject);
//        StringBuilder builder = new StringBuilder();
//        for (Movie movie : movies){
//            builder.append(movie.getTitle()).append("\n");
//        }
//        Log.i("MyResult", builder.toString());






    }

}