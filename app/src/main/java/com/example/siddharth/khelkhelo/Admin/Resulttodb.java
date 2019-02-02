package com.example.siddharth.khelkhelo.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.siddharth.khelkhelo.R;
import com.example.siddharth.khelkhelo.imagetoschedule.Display;
import com.example.siddharth.khelkhelo.imagetoschedule.ImageToDB;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by siddharth on 15/6/18.
 */

public class Resulttodb extends AppCompatActivity implements View.OnClickListener{
    private Button uploadButton, btnselectpic,btnselectpic2,next;
    private EditText matchno,team1name,team2name,team1url,team2url,team1run,team2run,team1rr,team2rr,team1over,team2over,matchbetween,series,toss,motm,result,date,time,stadium,umpires,referee,weather;
    private ImageView imageview,imageView2;
    private Bitmap bitmap;
    private String KEY_MATCHNUMBER = "matchnumber";
    private String KEY_TEAM1NAME = "team1name";
    private String KEY_TEAM2NAME = "team2name";
    private String KEY_TEAM1IMAGE = "team1image";
    private String KEY_TEAM2IMAGE = "team2image";
    private String KEY_TEAM1RUN = "team1run";
    private String KEY_TEAM2RUN = "team2run";
    private String KEY_TEAM1RR = "team1rr";
    private String KEY_TEAM2RR = "team2rr";
    private String KEY_TEAM1OVER = "team1over";
    private String KEY_TEAM2OVER = "team2over";
    private String KEY_MATCHBETWEEN = "matchbetween";
    private String KEY_SERIES = "series";
    private String KEY_TOSS = "toss";
    private String KEY_MOTM = "motm";
    private String KEY_RESULT = "result";
    private String KEY_DATE = "date";
    private String KEY_TIME = "time";
    private String KEY_STADIUM = "stadium";
    private String KEY_UMPIRES = "umpires";
    private String KEY_REFEREE = "referee";
    private String KEY_WEATHER = "weather";

    private int PICK_IMAGE_REQUEST = 1;
    private static final String UPLOAD_URL ="https://siddharthsoni020.000webhostapp.com/resulttodb.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_insert_db);
        init();
        uploadButton.setOnClickListener(this);
       // btnselectpic.setOnClickListener(this);
       // btnselectpic2.setOnClickListener(this);
       // next.setOnClickListener(this);
    }
    public void uploadImageToDB()
    {
        if (team1name.getText().toString().length() <= 0 || team2name.getText().toString().length()<=0)
        {
            team1name.setError("Please Enter Name !");
            team2name.setError("Please Enter Name !");
        }
//        else if (bitmap==null)
//        {
//            Toast.makeText(getApplicationContext(),"Please Upload Image",
//                    Toast.LENGTH_SHORT).show();
//        }
        else {
            uploadImage();
        }

    }

    private void uploadImage() {
        //Showing the progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,
                "Uploading...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.i("info",s);
                        //Disimissing the progress dialog
                        loading.dismiss();
                        //Showing toast message of the response
                        Toast.makeText(getApplicationContext(),s , Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        Log.i("info",volleyError.toString());
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(getApplicationContext(),
                                volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Converting Bitmap to String
               // String team1image = getStringImage(bitmap);
               // String team2image=getStringImage(bitmap);

                //Getting Image Name
                String team1n = team1name.getText().toString().trim();
                String team2n = team2name.getText().toString().trim();
                String team1u = team1url.getText().toString().trim();
                String team2u = team2url.getText().toString().trim();
                String matchbwn = matchbetween.getText().toString().trim();
                String matchno1 = matchno.getText().toString().trim();
                String team1r = team1run.getText().toString().trim();
                String team2r = team2run.getText().toString().trim();
                String team1rr1 = team1rr.getText().toString().trim();
                String team2rr1 = team2rr.getText().toString().trim();
                String series1 = series.getText().toString().trim();
                String toss1 = toss.getText().toString().trim();
                String motm1 = motm.getText().toString().trim();
                String result1 = result.getText().toString().trim();
                String referee1 = referee.getText().toString().trim();
                String date1 = date.getText().toString().trim();
                String time1 = time.getText().toString().trim();
                String stadium1 = stadium.getText().toString().trim();
                String umpires1 = umpires.getText().toString().trim();
                String weather1 = weather.getText().toString().trim();
                String team1o = team1over.getText().toString().trim();
                String team2o = team2over.getText().toString().trim();

                //Getting Description

                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_MATCHNUMBER, matchno1);
                params.put(KEY_TEAM1NAME, team1n);
                params.put(KEY_TEAM2NAME, team2n);
                params.put(KEY_TEAM1IMAGE, team1u);
                params.put(KEY_TEAM2IMAGE, team2u);
                params.put(KEY_TEAM1RUN, team1r);
                params.put(KEY_TEAM2RUN, team2r);

                params.put(KEY_TEAM1RR, team1rr1);
                params.put(KEY_TEAM2RR, team2rr1);
                params.put(KEY_TEAM1OVER, team1o);
                params.put(KEY_TEAM2OVER, team2o);
                params.put(KEY_MATCHBETWEEN, matchbwn);
                params.put(KEY_SERIES, series1);
                params.put(KEY_TOSS, toss1);

                params.put(KEY_MOTM, motm1);
                params.put(KEY_RESULT, result1);
                params.put(KEY_DATE, date1);
                params.put(KEY_TIME, time1);
                params.put(KEY_STADIUM, stadium1);
                params.put(KEY_UMPIRES, umpires1);
                params.put(KEY_REFEREE, referee1);
                params.put(KEY_WEATHER, weather1);
                //returning parameters
                return params;
            }
        };

        //Creating a Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    private String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public void selectImage()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                PICK_IMAGE_REQUEST);
    }


    private void init() {
        uploadButton = (Button)findViewById(R.id.save);
      // btnselectpic2=findViewById(R.id.button_selectpic2);
       // btnselectpic = (Button)findViewById(R.id.button_selectpic);
       // next = (Button)findViewById(R.id.next);
     //   itemageview = (ImageView)findViewById(R.id.imageView_pic);
        team1name = (EditText)findViewById(R.id.team1name);
        team2name=findViewById(R.id.team2_name);
        team1url = (EditText)findViewById(R.id.team1url);
        team2url=findViewById(R.id.team2url);
        team1rr = (EditText)findViewById(R.id.rr1);
        team2rr=findViewById(R.id.rr2);
        team1run = (EditText)findViewById(R.id.team1_run);
        team2run=findViewById(R.id.team2_run);
        matchno = (EditText)findViewById(R.id.match_no);
        matchbetween=findViewById(R.id.match_Teams);
        series = (EditText)findViewById(R.id.series);
        toss=findViewById(R.id.toss);
        motm = (EditText)findViewById(R.id.motm);
        result=findViewById(R.id.result);
        date = (EditText)findViewById(R.id.date);
        time=findViewById(R.id.Time);
        stadium = (EditText)findViewById(R.id.stadium);
        umpires=findViewById(R.id.umpires);
        referee = (EditText)findViewById(R.id.referes);
        weather=findViewById(R.id.weather);
        team1over = (EditText)findViewById(R.id.team1over);
        team2over=findViewById(R.id.team2over);

    }

    @Override
    public void onClick(View v) {
        if(v==btnselectpic)
        {
            selectImage();
        }
        if (v==btnselectpic2)
        {
            selectImage();
        }
        if(v==uploadButton)
        {
            uploadImageToDB();
        }
        if(v==next)
        {
            startActivity(new Intent(Resulttodb.this,Display.class));
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST &&
                resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                imageview.setVisibility(View.VISIBLE);
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),
                        filePath);
                //Setting the Bitmap to ImageView
                imageview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

