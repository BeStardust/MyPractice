package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

//AppCompatActivity有标题栏
public class MainActivity extends Activity {
    private TextView account, passwd;
    private Button shiftBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteStudioService.instance().start(this);

        account = (TextView) findViewById(R.id.account);
        passwd = (TextView) findViewById(R.id.passwd);

        SharedPreferences user = getSharedPreferences("user",MODE_PRIVATE);
        this.account.setText(user.getString("account",""));
        this.passwd.setText(user.getString("passwd",""));
        shiftBtn = (Button) findViewById(R.id.personalPage);
        shiftBtn.setOnClickListener(new shiftClick());
    }

    class shiftClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (account.getText().toString().equals("") == false && account.getText().toString() != null) {
                if (passwd.getText().toString().equals("") == false && passwd.getText().toString() != null) {

                    SharedPreferences user=getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=user.edit();
                    editor.putString("account",account.getText().toString());
                    editor.putString("passwd",passwd.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("accountName", account.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
                else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Tip:");
                    dialog.setMessage("Input Password");

                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You Pressed OK", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    dialog.create().show();
                }
            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Tip:");
                dialog.setMessage("Input Account");

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "You Pressed OK", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.create().show();
            }

        }
    }

}