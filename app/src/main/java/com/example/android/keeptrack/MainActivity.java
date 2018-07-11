package com.example.android.keeptrack;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://progress-checker.herokuapp.com/";

    ListView listView;

    List<Unit> unitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        unitList = new ArrayList<>();

        loadUnitList();
    }

    private void loadUnitList() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);


                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONArray unitArray = obj.getJSONArray("unit");

                            for (int i = 0; i < unitArray.length(); i++) {
                                JSONObject UnitObject = unitArray.getJSONObject(i);

                                Unit unit = new Unit(UnitObject.getString("name"),
                                        UnitObject.getString("faculty"),
                                        UnitObject.getString("year"),
                                        UnitObject.getString("semester"),
                                        UnitObject.getString("lecturer"));
                                unitList.add(unit);
                            }

                            ListViewAdapter adapter = new ListViewAdapter(unitList, getApplicationContext());

                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);
    }
}
