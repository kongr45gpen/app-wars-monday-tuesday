package com.examplev.kongr45gpen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class YesNameActivity extends AppCompatActivity {
    private static final String TAG = "YesNameActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_name);


        Log.e(TAG, "Welcome to YesNameActivity!");

        SeekBar bar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView = (TextView) findViewById(R.id.textView);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0) {
                    textView.setText("======== WELCOME TO APP WARS ========" +
                            "\n\n We hope you have a great time!\n" +
                            "Contact us at +30 699999999 if you have any issues");
                } else if(progress == 1) {
                    textView.setText("======= SCHEDULE =======" +
                            "\n\n 03:00-09:00: Sleep" +
                            "\n 09:00-13:00: Boring lectures" +
                            "\n 13:00-03:00: ENDLESS FUN");
                } else if(progress == 2) {
                    textView.setText("======= WORKSHOPS ======" +
                            "\n\n Workshops will take place at the ECE" +
                            " department");
                } else {
                    textView.setText("Thank you for participating!");
                }
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
