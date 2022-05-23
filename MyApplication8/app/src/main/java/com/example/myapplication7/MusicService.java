package com.example.myapplication7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;


public class MusicService extends Service {
    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"正在准备...",Toast.LENGTH_LONG).show();
        player=MediaPlayer.create(this,R.raw.zuixuanminzufeng);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this,"正在播放",Toast.LENGTH_LONG).show();
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
        Toast.makeText(this,"正在停止",Toast.LENGTH_LONG);
    }
}
