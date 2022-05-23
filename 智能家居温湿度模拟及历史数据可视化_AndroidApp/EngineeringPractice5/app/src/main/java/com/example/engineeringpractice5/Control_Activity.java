package com.example.engineeringpractice5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Control_Activity extends Activity {
    private LinearLayout full_page;
    private float touchDown_X, touchUp_X;
    private ImageButton back_to_home_btn;
    private Button light_btn, dehumidifier_btn, humidifier_btn, curtain_btn;
    private TextView light_status, dehumidifier_status, humidifier_status, curtain_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);

        light_btn = findViewById(R.id.light_btn);
        light_status = findViewById(R.id.light_status);
        light_btn.setOnClickListener(new Switch_OnClickListener());
        dehumidifier_btn = findViewById(R.id.dehumidifier_btn);
        dehumidifier_status = findViewById(R.id.dehumidifier_status);
        dehumidifier_btn.setOnClickListener(new Switch_OnClickListener());
        humidifier_btn = findViewById(R.id.humidifier_btn);
        humidifier_status = findViewById(R.id.humidifier_status);
        humidifier_btn.setOnClickListener(new Switch_OnClickListener());
        curtain_btn = findViewById(R.id.curtain_btn);
        curtain_status = findViewById(R.id.curtain_status);
        curtain_btn.setOnClickListener(new Switch_OnClickListener());

        back_to_home_btn = findViewById(R.id.back_to_home_btn);
        back_to_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Control_Activity.this, Home_Activity.class));
                overridePendingTransition(R.anim.translate_in, R.anim.translate_out);
            }
        });
        full_page = findViewById(R.id.full_page);
        full_page.setOnTouchListener(new SwitchPage_OnTouchListener());
    }

    class Switch_OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Button btn;
            TextView txt;
            switch (v.getId()) {
                case R.id.light_btn:
                    btn = light_btn;
                    txt = light_status;
                    break;
                case R.id.dehumidifier_btn:
                    btn = dehumidifier_btn;
                    txt = dehumidifier_status;
                    break;
                case R.id.humidifier_btn:
                    btn = humidifier_btn;
                    txt = humidifier_status;
                    break;
                case R.id.curtain_btn:
                    btn = curtain_btn;
                    txt = curtain_status;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
            if (btn.getText().equals(getResources().getString(R.string.open))) {
                btn.setText(R.string.close);
                txt.setText(R.string.open);
            } else {
                btn.setText(R.string.open);
                txt.setText(R.string.close);
            }

        }
    }

    class SwitchPage_OnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                touchDown_X = event.getX();
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                touchUp_X = event.getX();
                if (touchDown_X - touchUp_X > 200) {
                    startActivity(new Intent(Control_Activity.this, Home_Activity.class));
                    overridePendingTransition(R.anim.translate_in, R.anim.translate_out);
                    return true;
                }
            }
            return true;
        }
    }
}
