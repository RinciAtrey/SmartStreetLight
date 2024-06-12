package com.app.smartstreetlight;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class poles_information_activity extends AppCompatActivity {

    DatabaseReference databaseReferenceLDR1,databaseReferenceLDR2 ;


    TextView sv_1, sv_2;
    private ImageView iv_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poles_information);
        iv_back=findViewById(R.id.iv_back);
        sv_1=findViewById(R.id.sv_1);
        sv_2=findViewById(R.id.sv_2);
        databaseReferenceLDR1 = FirebaseDatabase.getInstance().getReference("LDR1");
         databaseReferenceLDR2 = FirebaseDatabase.getInstance().getReference("LDR2");

        getWindow().setStatusBarColor(ContextCompat.getColor(poles_information_activity.this,R.color.purple));


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        databaseReferenceLDR1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                Map map = (Map)dataSnapshot.getValue();
                assert map != null;
                sv_1.setText(map.get("sensorValue").toString());
                //String val= map.get("sensorValue").toString();
                //sv_2.setText(map.get("sensorValue1").toString());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        databaseReferenceLDR2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                assert map != null;
                sv_2.setText(map.get("sensorValue").toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle error
            }
        });









    }
}