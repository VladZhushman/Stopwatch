package com.example.vlad.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private int seconds = 0;
    private  boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }


    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }



    public void onClickStop(View view) {
        running = false;
    }

    public void onClickStart(View view) {
        running = true;
    }

    private void runTimer() {
        final TextView textView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format("%d:%02d:%02d", hours, minutes, sec);
                textView.setText(time);
                if (running) seconds++;
                handler.postDelayed(this,1000);
            }
        });




    }
}
