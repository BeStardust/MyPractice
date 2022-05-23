package com.example.myapplication;


//Activity没有标题栏


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView accountName = (TextView) findViewById(R.id.helloSecond);
        Bundle bundle = this.getIntent().getExtras();
        accountName.setText(bundle.getString("accountName"));
        registerForContextMenu(accountName);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("TEST");
        menu.add(0,Menu.FIRST,0,"test1");
        menu.add(0,Menu.FIRST+1,0,"test2");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(1, 1, 1, "test1");
        menu.add(1, 2, 2, "test2");
        menu.add(1, 3, 3, "test3");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}