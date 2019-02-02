package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Siddharth on 03-May-18.
 */

public class ResultDisplay extends AppCompatActivity {
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/resultdata.php ";
    private RecyclerView recyclerView;
    private ResultAdapter adpter;
    private ArrayList<Model_For_Result> modelForResults;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("Result");
        recyclerView = findViewById(R.id.recyclerView_result);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelForResults = new ArrayList<>();
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
                        Model_For_Result modelForResult = new Model_For_Result(jobj.getString("fistteamname"), jobj.getString("secondteamname"),jobj
                        .getString("runone"),jobj.getString("runsecond"),jobj.getString("wonby"),jobj
                        .getString("description"));
                        modelForResults.add(modelForResult);
                    }
                    adpter = new ResultAdapter(modelForResults, ResultDisplay.this);
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
                        Toast.makeText(ResultDisplay.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
