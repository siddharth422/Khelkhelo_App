package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Adapters.*;
import com.example.siddharth.khelkhelo.Adapters.MyAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.*;
import com.example.siddharth.khelkhelo.Modelclasses.ModelClass;
import com.example.siddharth.khelkhelo.Scorecard.Adapter_For_bowling;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by siddharth on 8/6/18.
 */

public class BattingScore extends AppCompatActivity implements Adapter_For_battingscore.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener{
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/battingscore.php";
    private static final String URL_DATA_B = "https://siddharthsoni020.000webhostapp.com/bowlingdata.php";
    private RecyclerView recyclerView,recyclerView2;
    private Adapter_For_battingscore adapter;
    private Adapter_For_bowling adapterB;
    private ArrayList<Model_BattingScore> modelClass;
    private ArrayList<Model_for_Bowling> modelClass2;
    public static final String TEAM1NAME =  "team1name";
    public static final String TEAM2NAME =  "team2name";
    public static final String DATE = "date";
    private SwipeRefreshLayout swipeRefreshLayout;
    String  date,team,team2;
    TextView textView,matchdate;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoredcard);
        setTitle("Scored");
        recyclerView = findViewById(R.id.recycle_view_batting);
        recyclerView2=findViewById(R.id.recycle_view_bowling);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelClass = new ArrayList<>();
        modelClass2=new ArrayList<>();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
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
                                        bowlingdata();

                                    }
                                }
        );

//
        Intent intent = getIntent();
         team = intent.getStringExtra(TEAM1NAME);
       date = intent.getStringExtra(DATE);
       team2=intent.getStringExtra(TEAM2NAME);
      //  textView=findViewById(R.id.team);
        matchdate=findViewById(R.id.date_match);
      //  textView.setText(team);
        matchdate.setText(date);
    //    sharedPreferences=getSharedPreferences("pref",MODE_PRIVATE);

     //   loadData();
       // bowlingdata();

    }

    private void bowlingdata() {
        swipeRefreshLayout.setRefreshing(true);
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_DATA_B,
                new Response.Listener<String>() {
                    @Override


                    public void onResponse(String response) {
                        Log.i("info",response);
                     //   progressDialog.dismiss();
                        try {

                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jObj=jsonArray.getJSONObject(i);
                                if (team2.equals(jObj.getString("team")) && date.equals(jObj.getString("date")))
                                {
                                    Model_for_Bowling mymodel=
                                            new Model_for_Bowling(jObj.getString("bowlername"),jObj.getString("over"),jObj.getString("madin"),jObj.getString("run"),jObj.getString("wicket")
                                                    ,jObj.getString("er"),jObj.getString("team"),jObj.getString("date"));
                                    modelClass2.add(mymodel);
                                }
                            }
                            adapterB=new Adapter_For_bowling(modelClass2,BattingScore.this);
                            recyclerView2.setAdapter(adapterB);
                            swipeRefreshLayout.setRefreshing(false);
                          //  adapterB.setOnItemClickListener(BattingScore.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(BattingScore.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);





    }

    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);



     //   final ProgressDialog progressDialog = new ProgressDialog(this);
       // progressDialog.setMessage("Loading...");
       // progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override


                    public void onResponse(String response) {
                        Log.i("info",response);
         //               progressDialog.dismiss();
                        try {

                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jObj=jsonArray.getJSONObject(i);
                               if (team.equals(jObj.getString("team")) && date.equals(jObj.getString("date")))
                               {
                                Model_BattingScore mymodel=
                                        new Model_BattingScore(jObj.getString("player_name"),jObj.getString("run"),jObj.getString("balls"),jObj.getString("fours"),jObj.getString("six")
                                                ,jObj.getString("sr"),jObj.getString("team"),jObj.getString("date"));
                                modelClass.add(mymodel);
                                }
                            }
                            adapter=new Adapter_For_battingscore(modelClass,BattingScore.this);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(BattingScore.this);
                            swipeRefreshLayout.setRefreshing(false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(BattingScore.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onItemClick(int position) {
        //Bundle bundle=new Bundle();
        // Intent intent=new Intent(this,DescriptionAct.class);
        //ModelClass model=modelClass.get(position);
/*        bundle.putString(PHOTO,model.getPhoto());
          bundle.putString(NAME,model.getName());
          bundle.putString(DESCRIPTION,model.getDescription());
*///      intent.putExtras(bundle);
        // intent.putExtra(PHOTO,model.getPhoto());
        //intent.putExtra(NAME,model.getName());
        //intent.putExtra(DESCRIPTION,model.getDescription());
        //startActivity(intent);
    }

    @Override
    public void onRefresh() {
        modelClass.clear();
        modelClass2.clear();
        adapter.notifyDataSetChanged();
        adapterB.notifyDataSetChanged();
        loadData();
        bowlingdata();


    }
}

