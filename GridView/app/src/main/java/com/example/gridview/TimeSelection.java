package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;

public class TimeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selection);
        doWork();
    }
    public void doWork()
    {
        Button b1 = (Button)findViewById(R.id.btnDateTimePicker);
        Button b2 = (Button)findViewById(R.id.btnChronometer);
        Button b4 = (Button)findViewById(R.id.btnAnalogLock);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker dtp = new DatePicker(TimeSelection.this);
                ((LinearLayout)findViewById(R.id.myLayout)).addView(dtp);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chronometer chronometer = new Chronometer(TimeSelection.this);
                ((LinearLayout)findViewById(R.id.myLayout)).addView(chronometer);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalogClock analogClock = new AnalogClock(TimeSelection.this);
                ((LinearLayout)findViewById(R.id.myLayout)).addView(analogClock);
            }
        });
    }
}
