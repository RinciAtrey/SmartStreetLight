package com.app.smartstreetlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView act1, act2;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act1= findViewById(R.id.act1);
        act2= findViewById(R.id.act2);
        search=findViewById(R.id.search);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.purple));

        String[] fromstation= getResources().getStringArray(R.array.fromstation);
        String[] tostation= getResources().getStringArray(R.array.tostation);

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, fromstation);
        act1.setAdapter(adapter1);


        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tostation);
        act2.setAdapter(adapter2);






        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    String dest1= act1.getText().toString();
                    String dest2= act2.getText().toString();

                    if(dest1.isEmpty()&& dest2.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please select the stations.", Toast.LENGTH_SHORT).show();
                    }

                    else if(dest1.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please select the stations.", Toast.LENGTH_SHORT).show();

                    }
                    else if(dest2.isEmpty()){
                        Toast.makeText(MainActivity.this, "Please select the stations.", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Intent i = new Intent(getApplicationContext(), MicroController_activity.class);
                        i.putExtra("dest1", dest1);
                        i.putExtra("dest2", dest2);
                        startActivity(i);

                        Intent broadcastIntent = new Intent("custom-event-name");
                        broadcastIntent.putExtra("dest1", dest1);
                        broadcastIntent.putExtra("dest2", dest2);
                        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcastIntent);

                    }


            }
        });









    }
}