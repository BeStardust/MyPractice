package com.example.engineeringpractice5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Temp_Sector_Graph_Activity extends Activity {
    ImageButton back_btn;
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_sector_graph);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Temp_Sector_Graph_Activity.this,Temp_History_Data_Activity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });

        web_view = findViewById(R.id.WebViewContent);
        web_view.setBackgroundColor(Color.TRANSPARENT);
        SharedPreferences sp = getSharedPreferences("IP_FILE", MODE_PRIVATE);
        web_view.loadUrl("http://" + sp.getString("IP_Address", "") + ":8080/EP5/tempSectorGraph.html");
        web_view.getSettings().setJavaScriptEnabled(true);
        //滚动条
        web_view.setVerticalScrollBarEnabled(false);
        web_view.setHorizontalScrollBarEnabled(false);
        web_view.setOverScrollMode(View.OVER_SCROLL_NEVER);
        web_view.setOnScrollChangeListener(new View.OnScrollChangeListener() {//监听滑动
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                webview.scrollTo(oldScrollX,scrollY);//只改变Y值，即限制左右滑动
//                webview.scrollTo(ScrollX,oldscrollY);//只改变X值，即限制上下滑动
                //   web_view.scrollTo(oldScrollX,oldScrollY);//不改变值，即限制滑动
                //以上三种选一即可
                web_view.scrollTo(0, 0);
            }
        });


    }
}
