package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Adapters.MyAdpter;
import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Team;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Siddharth on 01-May-18.
 */

public class Result extends AppCompatActivity {
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/mydata.php ";
    private RecyclerView recyclerView;
    private MyAdpter adpter;
    private ArrayList<Model_For_Team> modelForTeams;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamnames);
        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(Result.this,2));
        modelForTeams = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("info", response);
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jobj = jsonArray.getJSONObject(i);
                        Model_For_Team modelForTeam = new Model_For_Team(jobj.getString("image_desc"), jobj.getString("image_url"));
                        modelForTeams.add(modelForTeam);
                    }
                    adpter = new MyAdpter(modelForTeams, Result.this);
                    recyclerView.setAdapter(adpter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info", String.valueOf(error));
                        Toast.makeText(Result.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
