package com.jianhou.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablesListView;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 1; j <= 100; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);

        int max = 20;
        int startingPos = 10;
        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(startingPos);

        generateTimesTable(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min){
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }

                Log.i("SeekBar Value", Integer.toString(timesTableNumber));

                generateTimesTable(timesTableNumber);



            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
