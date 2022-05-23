package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//将指定的资源xml文件加载到对应的activity中
        txt=(TextView) findViewById(R.id.testView1);
        btn=(Button) findViewById(R.id.button1);
        btn.setOnClickListener((new mClick()));
    }
    class mClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            MainActivity.this.setTitle("改变标题");
//          txt.setText(R.string.newStr);
            int Black=0xffcccccc;
            txt.setText("eee");
            txt.setTextColor(Color.YELLOW);
            txt.setBackgroundColor(Black);
        }
    }
}