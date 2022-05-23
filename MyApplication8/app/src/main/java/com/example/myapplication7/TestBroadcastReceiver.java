package com.example.myapplication7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("2");
        MainActivity.broadcastMsg.setText(intent.getExtras().getString("msg"));
    }
}
