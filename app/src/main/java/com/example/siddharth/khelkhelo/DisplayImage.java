package com.example.siddharth.khelkhelo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.siddharth.khelkhelo.Modelclasses.ModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DisplayImage extends AppCompatActivity
        implements MyAdapter.OnItemClickListener{
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/data.php";
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<ModelClass> modelClass;
    public static final String PHOTO = "photo";
    public static final String NAME =  "name";
    public static final String DESCRIPTION = "description";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayimage);
        setTitle("Teams");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(DisplayImage.this,2));
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

                                ModelClass mymodel=
                           new ModelClass(jObj.getString("photo"),jObj.getString("name")
                                         ,jObj.getString("description"));
                                modelClass.add(mymodel);
                            }
                            adapter=new MyAdapter(modelClass,DisplayImage.this);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(DisplayImage.this);
                           } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("info",String.valueOf(error));
                        Toast.makeText(DisplayImage.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
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
/*   bundle.putString(PHOTO,model.getPhoto());
     bundle.putString(NAME,model.getName());
     bundle.putString(DESCRIPTION,model.getDescription());
*/
 // intent.putExtras(bundle);
  // intent.putExtra(PHOTO,model.getPhoto());
    //intent.putExtra(NAME,model.getName());
    //intent.putExtra(DESCRIPTION,model.getDescription());
    //startActivity(intent);
    }
}
