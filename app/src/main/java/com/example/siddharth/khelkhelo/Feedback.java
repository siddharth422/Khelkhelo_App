package com.example.siddharth.khelkhelo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by siddharth on 22/5/18.
 */

public class Feedback extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public String concern_array[];
    public Spinner choose_concern;
    public String concern;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_feedback);
        setTitle("Feedback");
        final EditText name = (EditText) findViewById(R.id.editText1);
        final EditText addy = (EditText) findViewById(R.id.editText2);
        final EditText cell = (EditText) findViewById(R.id.editText3);
        final EditText questions = (EditText) findViewById(R.id.editText4);
        choose_concern=findViewById(R.id.ConcernSpinner);

        Button email = (Button) findViewById(R.id.button30);

        concern_array=getResources().getStringArray(R.array.concern_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(Feedback.this, android.R.layout.simple_list_item_1, concern_array);

        choose_concern.setAdapter(adapter);
        choose_concern.setOnItemSelectedListener(this);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(android.content.Intent.ACTION_SEND);

                email.setType("plain/text");


                email.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"siddharthsoni020@gmail.com"});
                email.putExtra(android.content.Intent.EXTRA_SUBJECT, concern.trim());
                email.putExtra(android.content.Intent.EXTRA_TEXT,
                        "Name:  "+name.getText().toString()+'\n'+"Address:  "+addy.getText().toString()+'\n'+"Phone:  "+cell.getText().toString()+'\n'+'\n'+questions.getText().toString()+'\n'+'\n'+"Sent from the Cricket App, Join Us At Khelkhelo ");



                startActivity(Intent.createChooser(email, "Send mail..."));

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        choose_concern.setSelection(position);
        concern = choose_concern.getAdapter().getItem(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

