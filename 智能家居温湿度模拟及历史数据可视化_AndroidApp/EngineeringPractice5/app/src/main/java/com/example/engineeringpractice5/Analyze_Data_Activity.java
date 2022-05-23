package com.example.engineeringpractice5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Analyze_Data_Activity extends Activity {
    Button tempBtn, humBtn;
    ImageButton home_page_btn;
    private LinearLayout full_page_layout;
    private float touchDown_X, touchUp_X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analyze_data);
        home_page_btn = findViewById(R.id.home_page_btn);
        home_page_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analyze_Data_Activity.this, Home_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        tempBtn = findViewById(R.id.temp_btn);
        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analyze_Data_Activity.this, Temp_History_Data_Activity.class);
                startActivity(intent);
            }
        });
        humBtn = findViewById(R.id.hum_btn);
        humBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analyze_Data_Activity.this, Hum_History_Data_Activity.class));
            }
        });
        full_page_layout = findViewById(R.id.full_page);
        full_page_layout.setOnTouchListener(new SwitchPage_OnTouchListener());
    }

    class SwitchPage_OnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                touchDown_X = event.getX();
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                touchUp_X = event.getX();
                if (touchUp_X - touchDown_X > 200) {
                    startActivity(new Intent(Analyze_Data_Activity.this, Home_Activity.class));
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    return true;
                }
            }
            return true;
        }
    }
}
