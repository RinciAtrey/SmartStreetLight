package com.app.smartstreetlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

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

        String[] fromstation= getResources().getStringArray(R.array.fromstation);
        String[] tostation= getResources().getStringArray(R.array.tostation);

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, fromstation);
        act1.setAdapter(adapter1);


        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tostation);
        act2.setAdapter(adapter2);
        String act1_value= act1.getText().toString();


        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), all_poles.class);
                startActivity(i);
            }
        });




    }
}