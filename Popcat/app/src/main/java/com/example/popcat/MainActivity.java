package com.example.popcat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPopCat;
    TextView tvCount;
    Long count = 0L;
    Button btReset;
    Vibrator vibrator;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPopCat = findViewById(R.id.imgPopcat);
        tvCount = findViewById(R.id.tvCount);
        btReset = findViewById(R.id.button);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        imgPopCat.setOnTouchListener((view, motionEvent) -> {
            switch(motionEvent.getAction()){
                case (MotionEvent.ACTION_DOWN):
                    this.imgPopCat.setImageResource(R.drawable.opencat);
                    count++;
                    this.tvCount.setText(count.toString());
                    vibrator.vibrate(50);
                    return true;
                case (MotionEvent.ACTION_UP):
                    this.imgPopCat.setImageResource(R.drawable.closecat);
                    return true;
            }
            return false;
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0L;
                tvCount.setText(count.toString());
            }
        });



    }
}