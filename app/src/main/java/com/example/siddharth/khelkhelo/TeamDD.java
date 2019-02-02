package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.example.siddharth.khelkhelo.Adapters.Adapter_DD;
import com.example.siddharth.khelkhelo.Adapters.PlayerAdapter;
import com.example.siddharth.khelkhelo.Modelclasses.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by siddharth on 18/5/18.
 */

public class TeamDD extends AppCompatActivity  implements Adapter_DD.OnItemClickListener{
private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/DD.php";
private RecyclerView recyclerView;
private Adapter_DD adapter;
private ArrayList<Model> modelClass;
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
        setContentView(R.layout.team_csk);
        setTitle("DD");
        recyclerView = findViewById(R.id.recycle_view_csk);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(TeamDD.this,2));
        modelClass = new ArrayList<>();
        loadData();
        }
private void loadData() {

final ProgressDialog progressDialog;
    progressDialog = new ProgressDialog(this);
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

        Model mymodel=
        new Model(jObj.getString("photo"),jObj.getString("name")
        ,jObj.getString("team"),jObj.getString("fromcity"),jObj.getString("age"),jObj.getString("dob"),jObj.getString("battingstyle"),jObj.getString("bowlingstyle"));
        modelClass.add(mymodel);
        }
        adapter=new Adapter_DD(modelClass,TeamDD.this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(TeamDD.this);
        } catch (JSONException e) {
        e.printStackTrace();
        }

        }
        },
        new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        Log.i("info",String.valueOf(error));
        Toast.makeText(TeamDD.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
        }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        }



@Override
public void onItemClick(int position) {
        //Bundle bundle=new Bundle();
        Intent intent=new Intent(this,DescriptionAct.class);
        Model model=modelClass.get(position);
/*   bundle.putString(PHOTO,model.getPhoto());
     bundle.putString(NAME,model.getName());
     bundle.putString(DESCRIPTION,model.getDescription());
*/
        // intent.putExtras(bundle);
        intent.putExtra(PHOTO,model.getPhoto());
        intent.putExtra(NAME,model.getName());
        intent.putExtra(TEAM,model.getTeam());
        intent.putExtra(CITY,model.getFromcity());
        intent.putExtra(AGE,model.getAge());
        intent.putExtra(DOB,model.getDob());
        intent.putExtra(BATTINGSTYLE,model.getBattingstyle());
        intent.putExtra(BOLINGSTYLE,model.getBowlingstyle());
        startActivity(intent);
        }
        }
