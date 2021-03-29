/*
package com.example.pixaflip;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class DisplayReport extends AppCompatActivity implements DataListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        new FetchDataBackgroundTask(DisplayReport.this,this).execute();


    }

    @Override
    public void onDatachange(final List<CovidData> covidDataList) {
        Log.e(DisplayReport.class.getSimpleName(),"list size "+covidDataList.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter(covidDataList);
            }
        });

    }

    private void setAdapter(List<CovidData> covidDataList) {
        RecyclerView recyclerView = findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(covidDataList,this));
    }
}
*/