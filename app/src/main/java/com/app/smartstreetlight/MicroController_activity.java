package com.app.smartstreetlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.content.BroadcastReceiver;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MicroController_activity extends AppCompatActivity {
    private TextView textView, textView2, textView3, textView4, textView5, tv_activity;
    private TextView tv_dest1, tv_dest2;
    private ImageView iv_back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_controller);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        tv_activity = findViewById(R.id.tv_activity);
        tv_dest1 = findViewById(R.id.tv_dest1);
        tv_dest2 = findViewById(R.id.tv_dest2);
        iv_back = findViewById(R.id.iv_back);

        tv_activity.setText("MicroControllers available");
        tv_activity.setTextSize(18);
        getWindow().setStatusBarColor(ContextCompat.getColor(MicroController_activity.this, R.color.purple));

        String dest1 = getIntent().getStringExtra("dest1");
        String dest2 = getIntent().getStringExtra("dest2");

        // Use the data as needed
        tv_dest1.setText(dest1);
        tv_dest2.setText(dest2);


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), poles_information_activity.class);
                i.putExtra("dest1", dest1);
                i.putExtra("dest2", dest2);
                startActivity(i);

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), poles_information_activity.class);
                i.putExtra("dest1", dest1);
                i.putExtra("dest2", dest2);
                startActivity(i);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), poles_information_activity.class);
                i.putExtra("dest1", dest1);
                i.putExtra("dest2", dest2);
                startActivity(i);

            }
        });


        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), poles_information_activity.class);
                i.putExtra("dest1", dest1);
                i.putExtra("dest2", dest2);
                startActivity(i);

            }
        });


        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), poles_information_activity.class);
                i.putExtra("dest1", dest1);
                i.putExtra("dest2", dest2);
                startActivity(i);

            }
        });


    }
}