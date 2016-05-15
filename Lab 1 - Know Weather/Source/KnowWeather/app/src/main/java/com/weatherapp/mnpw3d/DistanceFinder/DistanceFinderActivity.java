package com.weatherapp.mnpw3d.DistanceFinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.weatherapp.mnpw3d.knowweather.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DistanceFinderActivity extends AppCompatActivity {

    TextView startingText;
    TextView endingText;
    TextView distanceText;
    TextView durationText;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*cityNameText = (TextView) findViewById(R.id.city_name);
        countryNameText = (TextView)findViewById(R.id.country_name);
        temperature = (TextView)findViewById(R.id.temperature);*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

  /*  private void hideKeyboard(View editableView) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editableView.getWindowToken(), 0);
    }*/
    public void back(View v)
    {
        Intent intent = new Intent(DistanceFinderActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void getWeather(View v) {
        EditText start = (EditText) findViewById(R.id.starting_point);
        String startingPoint = start.getText().toString();
        EditText end = (EditText) findViewById(R.id.ending_point);
        String endingCity = end.getText().toString();
        startingText = (TextView)findViewById(R.id.textview_starting);
        endingText = (TextView)findViewById(R.id.textview_ending);
        distanceText = (TextView)findViewById(R.id.textview_distance);
        durationText = (TextView)findViewById(R.id.textview_duration);
       // String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=44db6a862fba0b067b1930da0d769e98";
        String url1 = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+startingPoint
                +"&destinations="+endingCity+"&language=en-EN&key=AIzaSyB4jqIMw1fDy33xkKO0JMkRrVBEDefH4EE";
        final String response = "";
        OkHttpClient httpClient = new OkHttpClient();

        try {

            Request request = new Request.Builder()
                    .url(url1)
                    .build();

            httpClient.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final JSONObject jsonResult;
                    final String result = response.body().string();

                    try {
                        jsonResult = new JSONObject(result);
                        JSONArray destinationArray = jsonResult.getJSONArray("destination_addresses");
                        final String destination = destinationArray.getString(0);
                        JSONArray originArray = jsonResult.getJSONArray("origin_addresses");
                        final String origin = originArray.getString(0);
                        JSONArray rows = jsonResult.getJSONArray("rows"); // get rows
                        JSONObject row =rows.getJSONObject(0); // get particular row
                        JSONArray elementArray = row.getJSONArray("elements"); // get elements
                        JSONObject element = elementArray.getJSONObject(0);
                        JSONObject distanceObject = element.getJSONObject("distance");
                        final String distance = distanceObject.getString("text");
                        JSONObject durationObject = element.getJSONObject("duration");
                        final String duration = durationObject.getString("text");
                        Log.d("Distae",distance);
                        Log.d("Time",duration);
                        Log.d("CITY",destination);
                        Log.d("Origin",origin);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
       /*                         hideKeyboard(cityName);*/
                                startingText.setText("Starting Point : " + origin);
                                startingText.setVisibility(View.VISIBLE);
                                endingText.setText("Ending Point : " + destination);
                                endingText.setVisibility(View.VISIBLE);
                                distanceText.setText("Distance (Km) :" + distance);
                                distanceText.setVisibility(View.VISIBLE);
                                durationText.setText("Duration (Hour) :" + duration);
                                durationText.setVisibility(View.VISIBLE);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });


        } catch (Exception ex) {
           // cityNameText.setText(ex.getMessage());

        }

    }

}


