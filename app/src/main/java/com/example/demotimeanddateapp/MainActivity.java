package com.example.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                if (minute < 10){
                    String output = String.format("%d:0%d",hour,minute);
                    tvDisplay.setText("Time is "+output);

                }
                else {
                    tvDisplay.setText("Time is " + hour + ":" + minute);
                }


            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int day = dp.getDayOfMonth();
            int month = dp.getMonth()+1;
            int year = dp.getYear();

            String output = String.format("%d/%d/%d",day,month,year) ;

            if (month < 10){
                output = String.format("%d/0%d/%d",day,month,year) ;
            } else if (day <10) {
                output = String.format("0%d/%d/%d",day,month,year) ;
            }

            if(month < 10 && day < 10){
                output = String.format("0%d/0%d/%d",day,month,year) ;
            }
            tvDisplay.setText("Date is "+output);
            }

        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2020,00,01);
                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);
            }
        });
    }
}