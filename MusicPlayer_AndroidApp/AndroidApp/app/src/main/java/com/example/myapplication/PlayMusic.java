package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;


public class PlayMusic extends Service {
    MediaPlayer playMusic;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        //  playMusic = MediaPlayer.create(this, R.raw.zuixuanminzufeng);
        //  playMusic = MediaPlayer.create(this, Uri.parse("http://192.168.1.106:8080/AndroidProject/music/海底.m4a"));
        //  Toast.makeText(this, "create", Toast.LENGTH_LONG).show();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //      playMusic = MediaPlayer.create(this, Uri.parse("http://192.168.1.106:8080/AndroidProject/music/海底.m4a"));

        if (intent != null) {
//            System.out.println("ff");
//            System.out.println(intent.getExtras().getString("songName"));
            SharedPreferences ipSP = getSharedPreferences("IP_FILE", Context.MODE_PRIVATE);

            String URL = "http://" + ipSP.getString("IP_Address", "") + ":8080/AndroidProject/music/";

            // playMusic = MediaPlayer.create(this, Uri.parse("http://192.168.1.106:8080/AndroidProject/music/" + intent.getExtras().getString("songName")));
            playMusic = MediaPlayer.create(this, Uri.parse(URL + intent.getExtras().getString("songName")));

        }
        playMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playMusic.start();
            }
        });
        playMusic.start();

        //    Toast.makeText(this, "play", Toast.LENGTH_LONG).show();
        // return START_STICKY;
        return super.onStartCommand(intent, Service.START_FLAG_REDELIVERY, startId);
    }

    public void onDestroy() {
        playMusic.release();
        super.onDestroy();
        //    Toast.makeText(this, "pause", Toast.LENGTH_LONG).show();
    }
}
