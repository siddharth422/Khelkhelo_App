package com.example.siddharth.khelkhelo.Paymentgatway;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.siddharth.khelkhelo.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

/**
 * Created by siddharth on 18/5/18.
 */

public class Payment extends AppCompatActivity implements PaymentResultListener {
    private static final String TAG=Payment.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentgatway);


        Checkout.preload(getApplicationContext());

        Button button=findViewById(R.id.btn_pay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }


        });
    }

    private void startPayment() {
        final Activity activity=this;

        final Checkout co=new Checkout();

        try{
            JSONObject options=new JSONObject();
            options.put("name","Razorpay Corp");
            options.put("description", "Demoing Charges");
            options.put("image","");
            options.put("currency","INR");
            options.put("amount", "15000");

            JSONObject preFill= new JSONObject();
            preFill.put("email", "siddharthverma1995@gmail.com");
            preFill.put("contact","8233670422");
            options.put("prefill", preFill);

            co.open(activity,options);
        }catch ( Exception e ){
            Toast.makeText(activity,"Error in Payment"+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        try{
            Toast.makeText(this,"Payment Successfull:"+s,Toast.LENGTH_SHORT).show();
        }catch ( Exception e )
        {
            Log.e(TAG,"Exception In OnPayment Successfull");
        }

    }
    @SuppressWarnings("unused")
    @Override
    public void onPaymentError(int code, String response) {

        try{
            Toast.makeText(this,"payment Faild"+code+""+response,Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(this,Payment.class);
            PendingIntent pIntent =PendingIntent.getActivities(this,(int) System.currentTimeMillis(), new Intent[]{intent},0);
            Notification.Builder noti= new Notification.Builder(this)
                    .setContentTitle("New mail from"+"Razorpay.com")
                    .setContentText("Transaction Compile").setSmallIcon(R.drawable.ic_launcher)
                    .setContentIntent(pIntent);
            NotificationManager notificationManager=(NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0,noti.build());

        }
        catch ( Exception e ){
            Log.e(TAG,"Exception In OnPayment Successfull");
        }

    }
}

