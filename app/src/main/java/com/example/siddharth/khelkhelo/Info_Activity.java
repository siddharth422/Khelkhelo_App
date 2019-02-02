package com.example.siddharth.khelkhelo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by siddharth on 3/6/18.
 */

public class Info_Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String MATCHNO = "matchnumber";
    public static final String TEAM1NAME =  "team1name";
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
    public static final String TIME =  "time";
    public static final String STADIUM = "stadium";
    public static final String UMPIRES = "umpires";
    public static final String REFEREE =  "referee";
    public static final String WEATHER = "weather";
    String team1name,team2name,date;
    public TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,
            t8,t9,t10,t11,t12,t13,t14,t15,t16,t18,t17,t19,t20,score,score2;
    String csk="CSK",srh="SRH",bag="BAGLADESH",dd="DD",king="KXIP",kkr="KKR",mi="MI",rcb="RCB",rr="RR";
String india="INDIA";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.info);
        setTitle("Score Card");
      //  share();
        score=findViewById(R.id.scorecard);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent=new Intent(Info_Activity.this,BattingScore.class);




                startActivity(intent);*/
                startActivity(new Intent(Info_Activity.this,BattingScore.class).putExtra("team1name",team1name).putExtra("date",date).putExtra("team2name",team2name));
            }
       });
        score2=findViewById(R.id.scorecard2);
        score2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Info_Activity.this,BattingScore_two.class);
               intent.putExtra("team2name",team2name);
               intent.putExtra("date",date);
               intent.putExtra("team1name",team1name);
                startActivity(intent);
             //   startActivity(new Intent(Info_Activity.this,BattingScore_two.class).putExtra("team2name",team2name).putExtra("date",date));

            }
        });


        Intent intent = getIntent();
         team1name = intent.getStringExtra(TEAM1NAME);
         team2name = intent.getStringExtra(TEAM2NAME);
        //  String team1image = bundle.getString("TEAM1IMAGE");
        // String team2image = bundle.getString("TEAM2IMAGE");
        String match = intent.getStringExtra(MATCHBETWEEN);
        String series = intent.getStringExtra(SERIES);
        String toss = intent.getStringExtra(TOSS);
        String motm = intent.getStringExtra(MOTM);
        String result = intent.getStringExtra(RESULT);
         date = intent.getStringExtra(DATE);
        String time = intent.getStringExtra(TIME);
        String stadium = intent.getStringExtra(STADIUM);
        String umpire = intent.getStringExtra(UMPIRES);
        String referee = intent.getStringExtra(REFEREE);
        String weather = intent.getStringExtra(WEATHER);
        textView=findViewById(R.id.team1nameinfo);
        textView2=findViewById(R.id.team2nameinfo);
        textView3=findViewById(R.id.matchbtwn);
        textView4=findViewById(R.id.series);
        textView5=findViewById(R.id.toss);
        textView6=findViewById(R.id.motm);
        textView7=findViewById(R.id.resultinfo);
        t8=findViewById(R.id.date);
        t9=findViewById(R.id.time);
        t10=findViewById(R.id.stadium);
        t11=findViewById(R.id.umpires);
        t12=findViewById(R.id.referee);
        t13=findViewById(R.id.weather);
        textView.setText(team1name);
        textView2.setText(team2name);
        textView3.setText(match);
        textView4.setText(series);
        textView5.setText(toss);
        textView6.setText(motm);
        textView7.setText(result);
        t8.setText(date);
        t9.setText(time);
        t10.setText(stadium);
        t11.setText(umpire);
        t12.setText(referee);
        t13.setText(weather);
        t14=findViewById(R.id.team1nameinfo);
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csk.equals(team1name)||srh.equals(team1name)||rr.equals(team1name)||rcb.equals(team1name)||mi.equals(team1name)||king.equals(team1name)|kkr.equals(team1name)|dd.equals(team1name)||
                        bag.equals(team1name))
                {
                    if (csk.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_CSK.class);
                        startActivity(intent);

                    }else if (srh.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_SRH.class);
                        startActivity(intent);
                    }else if (rr.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_RR.class);
                        startActivity(intent);
                    }else if (rcb.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_RCB.class);
                        startActivity(intent);
                    }else if (dd.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,TeamDD.class);
                        startActivity(intent);
                    }else if (king.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_KINGS.class);
                        startActivity(intent);
                    }else if (kkr.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_KKR.class);
                        startActivity(intent);
                    }else if (mi.equals(team1name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_MI.class);
                        startActivity(intent);
                    }
                }else {

                    Toast.makeText(getApplicationContext(),"Team Not Found",
                            Toast.LENGTH_SHORT).show();


                }

            }
        });

        t15=findViewById(R.id.team2nameinfo);
        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csk.equals(team2name)||srh.equals(team2name)||rr.equals(team2name)||rcb.equals(team2name)||mi.equals(team2name)||king.equals(team2name)|kkr.equals(team2name)|dd.equals(team2name)||
                        bag.equals(team2name))
                {
                    if (csk.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_CSK.class);
                        startActivity(intent);

                    }else if (srh.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_SRH.class);
                        startActivity(intent);
                    }else if (rr.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_RR.class);
                        startActivity(intent);
                    }else if (rcb.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_RCB.class);
                        startActivity(intent);
                    }else if (dd.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,TeamDD.class);
                        startActivity(intent);
                    }else if (king.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_KINGS.class);
                        startActivity(intent);
                    }else if (kkr.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_KKR.class);
                        startActivity(intent);
                    }else if (mi.equals(team2name))
                    {
                        Intent intent=new Intent(Info_Activity.this,Team_MI.class);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Please Upload Image",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

//    private void share() {
//
//        SharedPreferences pref=getSharedPreferences("pref",MODE_PRIVATE);
//        SharedPreferences.Editor editor=pref.edit();
//        editor.putString("team1name", String.valueOf(textView));
//        editor.putString("date", String.valueOf(t8));
//        editor.commit();
//    }

    @Override
    public void onClick(View v) {
        if (v==score)
        {



        }
    }
}
