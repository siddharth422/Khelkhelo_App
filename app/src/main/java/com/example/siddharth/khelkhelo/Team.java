package com.example.siddharth.khelkhelo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Siddharth on 11-May-18.
 */

public class Team extends AppCompatActivity {
private CardView rr,csk,srh,rcb,mi,dd,kings,kkr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_team);
        setTitle("Teams");
        csk=findViewById(R.id.teamcsk);
        csk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_CSK.class);
                startActivity(intent);
            }
        });

        rr=findViewById(R.id.teamrr);
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_RR.class);
                startActivity(intent);
            }
        });
        srh=findViewById(R.id.teamsrh);
        srh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_SRH.class);
                startActivity(intent);
            }
        });
        mi=findViewById(R.id.teammi);
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_MI.class);
                startActivity(intent);
            }
        });
        dd=findViewById(R.id.teamdd);
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,TeamDD.class);
                startActivity(intent);
            }
        });
        rcb=findViewById(R.id.teamrcb);
        rcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_RCB.class);
                startActivity(intent);
            }
        });
        kkr=findViewById(R.id.teamkkr);
        kkr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_KKR.class);
                startActivity(intent);
            }
        });
        kings=findViewById(R.id.teamkxi);
        kings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Team.this,Team_KINGS.class);
                startActivity(intent);
            }
        });

    }
}
