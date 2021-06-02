package com.example.tahababar.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int multiple = 1;
    ListView myListView = findViewById(R.id.myListView);
    ArrayList<Integer> multiples = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar mySeekBar = findViewById(R.id.mySeekBar);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(multiple);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                multiple = progress;
                generate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void generate(){
        ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, multiples);

        for (int i = 0; i < 20; i++)
        {
            int answer = i * multiple;
            multiples.add(answer);
        }
        myListView.setAdapter(myArrayAdapter);
    }


}
