package com.example.engineeringpractice5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Home_Activity extends Activity {
    private ImageButton about_btn;
    private ImageButton control_page_btn, analyze_data_btn;
    private float touchUp_X, touchDown_X;
    private LinearLayout full_page_layout;
    private TextView temperature, temp_advise, humidity, hum_advise;

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                int arr[] = (int[]) msg.obj;
                if (arr[0] == 1) {
                    temp_advise.setText("室温过高");
                } else if (arr[0] == -1) {
                    temp_advise.setText("室温过低");
                } else {
                    temp_advise.setText("室温适宜");
                }
                if (arr[1] == 1) {
                    hum_advise.setText("湿度过高");
                } else if (arr[1] == -1) {
                    hum_advise.setText("湿度过低");
                } else {
                    hum_advise.setText("湿度适宜");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        about_btn=findViewById(R.id.about_btn);
        about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Home_Activity.this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle("关于作者");
                builder.setMessage("\n  学号:2019124049\n  姓名:吴转体\n  专业:物联网工程");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        temperature = findViewById(R.id.temperature);
        temp_advise = findViewById(R.id.temp_advise);
        humidity = findViewById(R.id.humidity);
        hum_advise = findViewById(R.id.hum_advise);

        setVersion();
//        Runnable_Get_Data runnable_get_data = new Runnable_Get_Data();
//        thread = new Thread(runnable_get_data);
//        thread.start();
        getData();


        //new Thread(runnable_get_data).start();

//        try {
//            URL url = new URL("http://" + getSharedPreferences("IP_FILE", MODE_PRIVATE).getString("IP_Address", "") + ":8080/EP5/servlet/Temp_and_Hum_REAL");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setConnectTimeout(5000);
//            connection.setRequestMethod("POST");
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            //接收
//            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder builder = new StringBuilder();
//            for (String s = buffer.readLine(); s != null; s = buffer.readLine()) {
//                builder.append(s);
//            }
//            System.out.println(builder);
//            buffer.close();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        control_page_btn = findViewById(R.id.control_page_btn);
        control_page_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, Control_Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
        analyze_data_btn = findViewById(R.id.analyze_data_btn);
        analyze_data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Activity.this, Analyze_Data_Activity.class));
                overridePendingTransition(R.anim.translate_in, R.anim.translate_out);
            }
        });
        full_page_layout = findViewById(R.id.full_page);
        full_page_layout.setOnTouchListener(new SwitchPage_OnTouchListener());
    }


    private void setVersion() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());
    }

    private void getData() {
        new Thread(new Runnable_Get_Data()).start();
    }

    class Runnable_Get_Data implements Runnable {
        @Override
        public void run() {
            while (true) {

                try {
                    URL url = new URL("http://" + getSharedPreferences("IP_FILE", MODE_PRIVATE).getString("IP_Address", "") + ":8080/EP5/servlet/Temp_and_Hum_REAL");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    connection.setDoInput(true);
                    //接收
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    for (String s = buffer.readLine(); s != null; s = buffer.readLine()) {
                        builder.append(s);
                    }
                    JSONObject data = new JSONObject(String.valueOf(builder));

                    temperature.setText(String.valueOf(data.getDouble("temp")) + " ℃");

                    //                    if (data.getInt("temp_advise") == 1) {
//                        System.out.println("1");
//                        temp_advise.setText("室温过高");
//                    } else if (data.getInt("temp_advise") == -1) {
//                        System.out.println("-1");
//                        temp_advise.setText("室温过低");
//                    } else {
//                        System.out.println("0");
//                        temp_advise.setText("室温适宜");
//                    }
                    humidity.setText(String.valueOf(data.getDouble("hum")) + " %");
//                    if (data.getInt("hum_advise") == 1) {
//                        hum_advise.setText("湿度过高");
//                    } else if (data.getInt("hum_advise") == -1) {
//                        hum_advise.setText("湿度过低");
//                    } else {
//                        hum_advise.setText("湿度适宜");
//                    }
                    Message msg = new Message();
                    msg.what = 1;
                    int arr[] = new int[2];
                    arr[0] = data.getInt("temp_advise");
                    arr[1] = data.getInt("hum_advise");
                    msg.obj = arr;
                    handler.sendMessage(msg);

                    buffer.close();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
                    startActivity(new Intent(Home_Activity.this, Analyze_Data_Activity.class));
                    overridePendingTransition(R.anim.translate_in, R.anim.translate_out);
                    return true;
                }
                if (touchUp_X - touchDown_X > 200) {
                    startActivity(new Intent(Home_Activity.this, Control_Activity.class));
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                }
            }
            return true;
        }
    }
}
