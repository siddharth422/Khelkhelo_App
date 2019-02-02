package com.example.siddharth.khelkhelo;

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
import com.example.siddharth.khelkhelo.Admin.Resulttodb;
import com.example.siddharth.khelkhelo.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by siddharth on 18/6/18.
 */

public class ScheduleUpload extends AppCompatActivity  implements View.OnClickListener{
    private Button uploadButton, btnselectpic,btnselectpic2,next;
    private EditText day,date,time,team1name,team2name,team1image,team2image;
    private ImageView imageview,imageView2;
    private Bitmap bitmap;
    private String KEY_DAY = "day";
    private String KEY_DATE = "date";
    private String KEY_TIME = "time";
    private String KEY_IMAGE1 = "team1image";
    private String KEY_T1NAME = "team1name";
    private String KEY_IMAGE2 = "team2image";
    private String KEY_T2NAME = "team2name";

    private int PICK_IMAGE_REQUEST = 1;
    private static final String UPLOAD_URL ="https://siddharthsoni020.000webhostapp.com/schedule.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduleupload);
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
                String team1image1 =team1image.getText().toString().trim();
                String team2image1=team2image.getText().toString().trim();

                //Getting Image Name
                String day1 = day.getText().toString().trim();
                String date1 = date.getText().toString().trim();
                String time1 = time.getText().toString().trim();
                String team1name1 = team1name.getText().toString().trim();
                String team2name1 = team2name.getText().toString().trim();



                //Creating parameters
                Map<String,String> params = new Hashtable<String, String>();

                //Adding parameters
                params.put(KEY_DAY, day1);
                params.put(KEY_DATE, date1);
                params.put(KEY_TIME, time1);
                params.put(KEY_IMAGE1, team1image1);
                params.put(KEY_IMAGE2, team2image1);
                params.put(KEY_T1NAME, team1name1);
                params.put(KEY_T2NAME, team2name1);
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
        uploadButton = (Button)findViewById(R.id.savebtn);
        // btnselectpic2=findViewById(R.id.button_selectpic2);
        // btnselectpic = (Button)findViewById(R.id.button_selectpic);
        // next = (Button)findViewById(R.id.next);
        //   itemageview = (ImageView)findViewById(R.id.imageView_pic);
        date = (EditText)findViewById(R.id.match_Date_schedule);
        day=findViewById(R.id.day_schedule);
        time = (EditText)findViewById(R.id.time_schedule);
        team1name=findViewById(R.id.team1name_schedule);
        team2name = (EditText)findViewById(R.id.team2_name_schedule);
        team1image=findViewById(R.id.team1url_schedule);
        team2image=findViewById(R.id.team2url_schedule);

    }

    @Override
    public void onClick(View v) {

        if(v==uploadButton)
        {
            uploadImageToDB();
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


