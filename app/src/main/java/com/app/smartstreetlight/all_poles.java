package com.app.smartstreetlight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.Adapters.Recyclerview_Adapter;
import com.app.Models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class all_poles extends AppCompatActivity {
    RecyclerView recyclerView;
    Recyclerview_Adapter recyclerviewAdapter;
    private List<DataModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_poles);


        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        mList = new ArrayList<>();

        List<String> nestedList1 = new ArrayList<>();
        nestedList1.add("Status: ON");
        nestedList1.add("Defect: No defects found");



        mList.add(new DataModel(nestedList1 , "S1"));
        mList.add(new DataModel( nestedList1,"S2"));
        mList.add(new DataModel( nestedList1,"S3"));
        mList.add(new DataModel(nestedList1 ,"S4"));
        mList.add(new DataModel(nestedList1,"S5"));
        mList.add(new DataModel(nestedList1,"S6"));
        mList.add(new DataModel(nestedList1,"S7"));
        mList.add(new DataModel(nestedList1,"S8"));
        mList.add(new DataModel(nestedList1,"S9"));
        mList.add(new DataModel(nestedList1,"S10"));

        recyclerviewAdapter = new Recyclerview_Adapter(mList);
        recyclerView.setAdapter(recyclerviewAdapter);








    }
}