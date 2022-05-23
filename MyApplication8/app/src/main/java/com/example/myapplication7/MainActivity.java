package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button playMusicBtn, stopMusicBtn;
    static TextView broadcastMsg;
    private Button sendBroadcastBtn;
    private EditText editEmail;
    private Button sendEmailBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playMusicBtn = findViewById(R.id.playMusicBtn);
        playMusicBtn.setOnClickListener(new MusicListener());
        stopMusicBtn = findViewById(R.id.stopMusicBtn);
        stopMusicBtn.setOnClickListener(new MusicListener());
        broadcastMsg = findViewById(R.id.broadcastMsg);
        sendBroadcastBtn = findViewById(R.id.sendBroadcast);
        sendBroadcastBtn.setOnClickListener(new BroadcastListener());
        editEmail = findViewById(R.id.emailEdit);
        sendEmailBtn = findViewById(R.id.sendEmail);
        sendEmailBtn.setOnClickListener(new EmailSendListener());
    }

    class MusicListener implements View.OnClickListener {
        Intent intent = new Intent(MainActivity.this, MusicService.class);

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.playMusicBtn:
                    MainActivity.this.startService(intent);
                    break;
                case R.id.stopMusicBtn:
                    MainActivity.this.stopService(intent);
                    break;
            }
        }
    }

    class BroadcastListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setPackage("com.example.myapplication7");
            intent.setAction("broadcast");
            Bundle bundle = new Bundle();
            bundle.putString("msg", "Welcome");
            intent.putExtras(bundle);

            sendBroadcast(intent);
            System.out.println("1");
        }
    }

    class EmailSendListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Uri uri=Uri.parse("mailto:wu.zt@foxmail.com");
            Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
            startActivity(intent);
        }
    }
}