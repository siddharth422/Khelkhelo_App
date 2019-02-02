package com.example.siddharth.khelkhelo.Home;

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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Adapters.Adapter_DD;
import com.example.siddharth.khelkhelo.BattingScore;
import com.example.siddharth.khelkhelo.DescriptionAct;
import com.example.siddharth.khelkhelo.Info_Activity;
import com.example.siddharth.khelkhelo.Modelclasses.Model;
import com.example.siddharth.khelkhelo.R;
import com.example.siddharth.khelkhelo.Scored;
import com.example.siddharth.khelkhelo.Tab_For_Score;
import com.example.siddharth.khelkhelo.TeamDD;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by siddharth on 29/5/18.
 */

public class DisplayScored extends AppCompatActivity implements Adapter_for_Scored.OnItemClickListener,SwipeRefreshLayout.OnRefreshListener{
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/scoreddata.php";
    private RecyclerView recyclerView;
    private Button scored;
    private Adapter_for_Scored adapter;

    private ArrayList<Model_for_homescoreboard> modelClass;


    public static final String MATCHNO = "matchnumber";
    public static final String TEAM1NAME =  "team1name";
    public static final String TEAM1NAME2 =  "team1name";
    public static final String TEAM2NAME = "team2name";
    public static final String TEAM1IMAGE = "team1image";
    public static final String TEAM2IMAGE =  "team2image";
    public static final String TEAM1RUN = "team1run";
    public static final String TEAM2RUN = "team2run";
    public static final String TEAM1RR =  "team1rr";
    public static final String TEAM2RR = "team2rr";
    public static final String TEAM1OVER =  "team1over";
    public static final String TEAM2OVER = "team2over";
    public static final String MATCHBETWEEN = "matchbetween";
    public static final String SERIES =  "series";
    public static final String TOSS = "toss";
    public static final String MOTM = "motm";
    public static final String RESULT =  "result";
    public static final String DATE = "date";
    public static final String DATE2 = "date";
    public static final String TIME =  "time";
    public static final String STADIUM = "stadium";
    public static final String UMPIRES = "umpires";
    public static final String REFEREE =  "referee";
    public static final String WEATHER = "weather";
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("Results");
        recyclerView = findViewById(R.id.recyclerView_result);
        recyclerView.setHasFixedSize(true);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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


      //  loadData();
    }
    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);

        final String tm=TEAM1NAME;
        final String dt=DATE;

        //final ProgressDialog progressDialog;
       // progressDialog = new ProgressDialog(this);
       // progressDialog.setMessage("Loading...");
       // progressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("info",response);
                        //progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jObj=jsonArray.getJSONObject(i);

                                Model_for_homescoreboard mymodel=
                                        new Model_for_homescoreboard(jObj.getString("matchnumber"),
                                                jObj.getString("team1name")
                                                ,jObj.getString("team2name"),   jObj.getString("team1image")
                                                ,jObj.getString("team2image"),  jObj.getString("team1run")
                                                ,jObj.getString("team2run"),    jObj.getString("team1rr")
                                                ,jObj.getString("team2rr"),     jObj.getString("team1over")
                                                ,jObj.getString("team2over"),   jObj.getString("matchbetween")
                                                ,jObj.getString("series"),      jObj.getString("toss")
                                                ,jObj.getString("motm"),        jObj.getString("result")
                                                ,jObj.getString("date"),        jObj.getString("time")
                                                ,jObj.getString("stadium"),     jObj.getString("umpires")
                                                ,jObj.getString("referee"),     jObj.getString("weather"));
                                modelClass.add(mymodel);
                            }



                            adapter=new Adapter_for_Scored(modelClass,DisplayScored.this);
                            recyclerView.setAdapter(adapter);

                            adapter.setOnItemClickListener(DisplayScored.this);
                            swipeRefreshLayout.setRefreshing(false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        SharedPreferences pref =getSharedPreferences("pref",MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("TEAM1NAME",tm);
                        editor.putString("DATE",dt);
                        editor.commit();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(DisplayScored.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    @Override
    public void onItemClick(int position) {
        //Bundle bundle=new Bundle();
        Intent intent=new Intent(this,Info_Activity.class);
        //Intent intent1=new Intent(this,BattingScore.class);
        //Intent intent1=new Intent(this, BattingScore.class);


        Model_for_homescoreboard model=modelClass.get(position);
/*   bundle.putString(PHOTO,model.getPhoto());
     bundle.putString(NAME,model.getName());
     bundle.putString(DESCRIPTION,model.getDescription());
*/
        // intent.putExtras(bundle);
        intent.putExtra(TEAM1NAME2,model.getTeam1name());
        intent.putExtra(MATCHNO,model.getMatchnumber());
        intent.putExtra(TEAM1NAME,model.getTeam1name());
        intent.putExtra(TEAM2NAME,model.getTeam2name());
        intent.putExtra(TEAM1IMAGE,model.getTeam1image());
        intent.putExtra(TEAM2IMAGE,model.getTeam2image());
        intent.putExtra(TEAM1RUN,model.getTeam1run());
        intent.putExtra(TEAM2RUN,model.getTeam2run());
        intent.putExtra(TEAM1RR,model.getTeam1rr());
        intent.putExtra(TEAM2RR,model.getTeam2rr());
        intent.putExtra(TEAM1OVER,model.getTeam1over());
        intent.putExtra(TEAM2OVER,model.getTeam2over());
        intent.putExtra(MATCHBETWEEN,model.getMatchbetween());
        intent.putExtra(SERIES,model.getSeries());
        intent.putExtra(TOSS,model.getToss());
        intent.putExtra(MOTM,model.getMotm());
        intent.putExtra(RESULT,model.getResult());
        intent.putExtra(DATE,model.getDate());
        intent.putExtra(DATE2,model.getDate());
        intent.putExtra(TIME,model.getTime());
        intent.putExtra(STADIUM,model.getStadium());
        intent.putExtra(UMPIRES,model.getUmpires());
        intent.putExtra(REFEREE,model.getReferee());
        intent.putExtra(WEATHER,model.getWeather());
        startActivity(intent);
       // startActivity(intent1);
    }

    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        modelClass.clear();
        adapter.notifyDataSetChanged();
        loadData();

    }
}
