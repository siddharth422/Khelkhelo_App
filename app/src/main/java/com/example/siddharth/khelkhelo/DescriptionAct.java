package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.siddharth.khelkhelo.Adapters.PlayerAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.Model;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



//import static com.example.abhinay.imagetoserver.DisplayImage.DESCRIPTION;
//import static com.example.abhinay.imagetoserver.DisplayImage.IMAGES;

/**
 * Created by Abhinay on 4/16/2018.
 */

public class DescriptionAct extends AppCompatActivity   {

    public static final String PHOTO = "photo";
    public static final String NAME =  "name";
    public static final String TEAM = "team";
    public static final String CITY = "fromcity";
    public static final String AGE =  "age";
    public static final String DOB = "dob";
    public static final String BATTINGSTYLE = "battingstyle";
    public static final String BOLINGSTYLE =  "bowlingstyle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerinfo);
        Intent intent = getIntent();
        String photo = intent.getStringExtra(PHOTO);
        String name = intent.getStringExtra(NAME);
        String fromcity = intent.getStringExtra(CITY);
        String age = intent.getStringExtra(AGE);
        String dob = intent.getStringExtra(DOB);
        String battingstyle = intent.getStringExtra(BATTINGSTYLE);
        String bowlingstyle = intent.getStringExtra(BOLINGSTYLE);
        ImageView imageView = findViewById(R.id.imageinfo);
        TextView textView = findViewById(R.id.nameinfo);
        TextView textView1 = findViewById(R.id.fromteaminfo);
        TextView textView2 = findViewById(R.id.ageinfo);
        TextView textView3 = findViewById(R.id.dateinfo);
        TextView textView4 = findViewById(R.id.battinginfo);
        TextView textView5 = findViewById(R.id.bowlinginfo);
        Picasso.with(this).load(photo).fit().centerInside().into(imageView);
        textView.setText(name);
        textView1.setText(fromcity);
        textView2.setText(age);
        textView3.setText(dob);
        textView4.setText(battingstyle);
        textView5.setText(bowlingstyle);



    }}