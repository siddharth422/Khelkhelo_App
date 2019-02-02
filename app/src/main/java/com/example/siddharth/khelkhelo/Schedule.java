package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.siddharth.khelkhelo.Adapters.MyAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.Model_For_Schedule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by siddharth on 19/5/18.
 */

public class Schedule extends AppCompatActivity implements Adapter_For_Schedule.OnItemClickListener{
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/scheduledata.php";
    private RecyclerView recyclerView;
    private Adapter_For_Schedule adapter;
    private ArrayList<Model_For_Schedule> modelClass;
    public static final String DAY = "day";
    public static final String DATE =  "date";
    public static final String TIME = "time";
    public static final String IMAGE1 = "team1image";
    public static final String IMAGE2 =  "team2image";
    public static final String TEAMNAME1 = "team1name";
    public static final String TEAMNAME2 = "team2name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedulematch);
        setTitle("Schedule");
        recyclerView = findViewById(R.id.recyclerView_schedule);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelClass = new ArrayList<>();
        loadData();
    }
    private void loadData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("info",response);
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jObj=jsonArray.getJSONObject(i);

                                Model_For_Schedule mymodel=
                                        new Model_For_Schedule(jObj.getString("day"),jObj.getString("date")
                                                ,jObj.getString("time"),jObj.getString("team1image"),jObj.getString("team1name"),jObj.getString("team2image"),jObj.getString("team2name"));
                                modelClass.add(mymodel);
                            }
                            adapter=new Adapter_For_Schedule(modelClass,Schedule.this);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(Schedule.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(Schedule.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

   @Override
   public void onItemClick(int position) {
        //Bundle bundle=new Bundle();
     //  Intent intent=new Intent(this,DescriptionAct.class);
      // Model_For_Schedule model=modelClass.get(position);
/*   bundle.putString(PHOTO,model.getPhoto());
     bundle.putString(NAME,model.getName());
     bundle.putString(DESCRIPTION,model.getDescription());
*/
        //intent.putExtras(bundle);
    //    intent.putExtra(DAY,model.getDay());
     // intent.putExtra(DATE,model.getDate());
      // intent.putExtra(TIME,model.getTime());
       //intent.putExtra(TEAMNAME1,model.getTeam1name());
      // intent.putExtra(TEAMNAME2,model.getTeam2name());
      // intent.putExtra(IMAGE1,model.getTeam1image());
      // intent.putExtra(IMAGE2,model.getTeam2image());
      // startActivity(intent);
   }
}


