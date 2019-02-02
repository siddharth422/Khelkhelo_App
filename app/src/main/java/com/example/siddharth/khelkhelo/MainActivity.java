package com.example.siddharth.khelkhelo;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.Account.Login_Activity;
import com.example.siddharth.khelkhelo.Admin.Resulttodb;
import com.example.siddharth.khelkhelo.Home.DisplayScored;
import com.example.siddharth.khelkhelo.Home.Model_for_homescoreboard;
import com.example.siddharth.khelkhelo.Paymentgatway.Payment;
import com.example.siddharth.khelkhelo.vedio.Vedio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String URL_DATA = "https://siddharthsoni020.000webhostapp.com/scoreddata2.php";
    private RecyclerView recyclerView;
    private Adapter_for_Scored_Home adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<Model_for_homescoreboard> modelClass;

    Button team,result,venue,pointtable,vedio,photo,standing,archive,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view_home);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelClass = new ArrayList<>();
        loadData();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Feedback.class);
                startActivity(intent);
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
        result=findViewById(R.id.resultbtn);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DisplayScored.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        team=findViewById(R.id.team_button);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Team.class);
                startActivity(intent);
            }
        });
        pointtable=findViewById(R.id.pointtable);
        pointtable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PointTable.class);
                startActivity(intent);

            }
        });
        venue=findViewById(R.id.venuebtn);
        venue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Venue.class);
                startActivity(intent);

            }
        });
//        vedio=findViewById(R.id.videobtn);
//        vedio.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Vedio.class);
//                startActivity(intent);
//
//            }
//        });
        photo=findViewById(R.id.photobtn);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Photo.class);
                startActivity(intent);

            }
        });
//        archive=findViewById(R.id.archivebtn);
//        archive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Archive.class);
//                startActivity(intent);
//
//            }
//        });
// score=findViewById(R.id.headerbtn);
// score.setOnClickListener(new View.OnClickListener() {
//     @Override
//     public void onClick(View v) {
//         Intent intent=new Intent(MainActivity.this,Tab_For_Score.class);
//         startActivity(intent);
//
//     }
// });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onRefresh() {
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
        swipeRefreshLayout.setRefreshing(true);
        modelClass.clear();
        adapter.notifyDataSetChanged();
        loadData();

//
//            }
//        });

    }


    private void loadData() {
        swipeRefreshLayout.setRefreshing(true);

       // final ProgressDialog progressDialog;
     //   progressDialog = new ProgressDialog(this);
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

                                Model_for_homescoreboard mymodel=
                                        new Model_for_homescoreboard(jObj.getString("matchnumber"),jObj.getString("team1name")
                                                ,jObj.getString("team2name"),jObj.getString("team1image"),jObj.getString("team2image"),jObj.getString("team1run"),jObj.getString("team2run"),jObj.getString("team1rr"),jObj.getString("team2rr"),jObj.getString("team1over")
                                                ,jObj.getString("team2over"),jObj.getString("matchbetween"),jObj.getString("series"),jObj.getString("toss"),jObj.getString("motm"),jObj.getString("result"),jObj.getString("date"),jObj.getString("time")
                                                ,jObj.getString("stadium"),jObj.getString("umpires"),jObj.getString("referee"),jObj.getString("weather"));
                                modelClass.add(mymodel);
                            }
                            adapter=new Adapter_for_Scored_Home(modelClass,MainActivity.this);
                            recyclerView.setAdapter(adapter);
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
                        Toast.makeText(MainActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder adb= new AlertDialog.Builder(this);
            adb.setTitle("Do You Want To Exit");
            adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            adb.setNegativeButton("no",null);
            adb.create().show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager=getFragmentManager();

        if (id == R.id.nav_home) {
            Intent intent=new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
            //fragmentManager.beginTransaction().replace(R.id.frame,new Home()).commit();

            // Handle the camera action
        } else if (id == R.id.nav_Teams) {
            Intent intent=new Intent(MainActivity.this,DisplayImage.class);
            startActivity(intent);

            // fragmentManager.beginTransaction().replace(R.id.frame,new Team()).commit();

        } else if (id == R.id.nav_schedule) {
           // fragmentManager.beginTransaction().replace(R.id.frame,new Fragment_Venues()).commit();

            Intent intent=new Intent(MainActivity.this,Schedule.class);
            startActivity(intent);

        } else if (id == R.id.nav_result) {
            Intent intent=new Intent(MainActivity.this,DisplayScored.class);
            startActivity(intent);



        }  else if (id == R.id.nav_registerteams) {
            Intent intent=new Intent(MainActivity.this,Login_Activity.class);
            startActivity(intent);



        }else if (id == R.id.nav_rateaap) {


        }
        else if (id == R.id.nav_feedback) {
            Intent intent=new Intent(MainActivity.this,Feedback.class);
            startActivity(intent);


        }else if (id == R.id.nav_aboutapp) {
            Intent intent=new Intent(MainActivity.this,AboutApp.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_payment) {
            Intent intent=new Intent(MainActivity.this, Payment.class);
            startActivity(intent);



        }
        else if (id == R.id.resultupload) {
            Intent intent=new Intent(MainActivity.this, Resulttodb.class);
            startActivity(intent);



        }
        else if (id == R.id.image_upload) {
            Intent intent=new Intent(MainActivity.this, ScheduleUpload.class);
            startActivity(intent);



        }
        else if (id == R.id.imageupload) {
            Intent intent=new Intent(MainActivity.this, Imagetophoto.class);
            startActivity(intent);



        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
