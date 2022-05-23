package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button btnReduce, btnAdd;
    ImageView img;
    Button pre, next;
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img3,
            R.drawable.img6,
            R.drawable.img7
    };
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar);
        btnReduce = (Button) findViewById(R.id.reduce);
        btnAdd = (Button) findViewById(R.id.add);
        btnReduce.setOnClickListener(new ClickReduce());
        btnAdd.setOnClickListener(new ClickAdd());
        img = (ImageView) findViewById(R.id.img);
        pre = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);
        pre.setOnClickListener(new ClickChangePic());
        next.setOnClickListener(new ClickChangePic());
    }

    class ClickReduce implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            progressBar.incrementProgressBy(-5);
        }
    }

    class ClickAdd implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            progressBar.incrementProgressBy(5);
        }
    }

    class ClickChangePic implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v == pre) {
                if (index > 0 && index < imgs.length) {
                    index--;
                } else {
                    index = imgs.length - 1;
                }
            }
            if (v == next) {
                if (index >= 0 && index < imgs.length - 1) {
                    index++;

                } else {
                    index = 0;
                }
            }
            img.setImageResource(imgs[index]);
            System.out.println(index);
        }
    }

}
