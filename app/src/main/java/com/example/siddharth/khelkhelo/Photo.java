package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.media.ExifInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ClearCacheRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Adapters.*;
import com.example.siddharth.khelkhelo.Modelclasses.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by siddharth on 17/5/18.
 */

public class Photo extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{
    private  String URL_DATA = "https://siddharthsoni020.000webhostapp.com/photodata.php";
    private RecyclerView recyclerView;
    String url;
    private Adapter_for_photo adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<com.example.siddharth.khelkhelo.Modelclasses.ModelClass> modelClass;
    public static final String PHOTO = "photo";
    public static final String NAME =  "name";
    public static final String DESCRIPTION = "description";
    private int offSet = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        setTitle("Photo");
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        recyclerView = findViewById(R.id.recycle_view_photo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(Photo.this,2));
        modelClass = new ArrayList<>();

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light)
        );
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public final void  run() {
                                        if (swipeRefreshLayout !=null) {
                                            swipeRefreshLayout.setRefreshing(true);


                                        }

                                        loadData();
                                    }
                                }
        );

    }


    @Override
    public  void onRefresh() {
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
                modelClass.clear();
                adapter.notifyDataSetChanged();
                loadData();


//            }
//        });








    }
    private void  loadData() {
      swipeRefreshLayout.setRefreshing(true);


     //   final ProgressDialog progressDialog = new ProgressDialog(this);
       // progressDialog.setMessage("Loading...");
       // progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("info",response);
                      //  progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jObj=jsonArray.getJSONObject(i);

                                com.example.siddharth.khelkhelo.Modelclasses.ModelClass mymodel=
                                        new com.example.siddharth.khelkhelo.Modelclasses.ModelClass(jObj.getString("photo"),jObj.getString("name")
                                                ,jObj.getString("description"));
                                modelClass.add(mymodel);
                            }
                            adapter=new Adapter_for_photo(modelClass,Photo.this);
                            recyclerView.setAdapter(adapter);
                            swipeRefreshLayout.setRefreshing(false);

                           // adapter.setOnItemClickListener(Photo.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(Photo.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                                        }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



}
