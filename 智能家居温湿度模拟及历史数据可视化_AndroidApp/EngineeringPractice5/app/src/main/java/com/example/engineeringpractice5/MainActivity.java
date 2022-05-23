package com.example.engineeringpractice5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {
    private Button loginBtn;
    private TextView account;
    private TextView passwd;
    //  static boolean loginFlag = false;
    String ip_Address = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = (TextView) findViewById(R.id.account);
        account.setText("first");//
        passwd = (TextView) findViewById(R.id.passwd);
        passwd.setText("aaa");//
        loginBtn = (Button) findViewById(R.id.Login);
        loginBtn.setOnClickListener(new LoginClick());
        EditText ipEdit = findViewById(R.id.ip);
        SharedPreferences sp = getSharedPreferences("IP_FILE", Context.MODE_PRIVATE);
        ipEdit.setText(sp.getString("IP_Address", ""));
        ip_Address = sp.getString("IP_Address", "");
        Button ip_submit_Btn = findViewById(R.id.ip_submit_btn);
        ip_submit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_Address = ((EditText) findViewById(R.id.ip)).getText().toString();
                SharedPreferences ipSP = getSharedPreferences("IP_FILE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = ipSP.edit();
                editor.putString("IP_Address", ip_Address);
                editor.commit();
                Toast.makeText(MainActivity.this, "IP已提交", Toast.LENGTH_LONG).show();
            }
        });

    }

    class LoginClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (account.getText().toString().equals("") == false && account.getText().toString() != null) {
                if (passwd.getText().toString().equals("") == false && passwd.getText().toString() != null) {

//                    String URL = "http://192.168.1.106:8080/EP5/servlet/LoginServlet";
                    String URL = "http://" + ip_Address + ":8080/EP5/servlet/LoginServlet";
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    try {
                        JSONObject loginData = new JSONObject();
                        if (!account.getText().toString().equals("") && account.getText().toString() != null) {
                            if (!passwd.getText().toString().equals("") && passwd.getText().toString() != null) {
                                loginData.put("account", account.getText().toString()).put("passwd", passwd.getText().toString());
                            }
                        }
                        JsonObjectRequest jORequest = new JsonObjectRequest(Request.Method.POST, URL, loginData, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
//                                     System.out.println(response.getBoolean("result"));
                                    //   loginFlag = response.getBoolean("result");
                                    if (response.getBoolean("result")) {

                                          Intent intent = new Intent(MainActivity.this, Home_Activity.class);
//                                        Bundle bundle = new Bundle();
//                                        bundle.putString("account", account.getText().toString());
//                                        intent.putExtras(bundle);

                                         startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Login Denied", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Toast.makeText(MainActivity.this, "Login Denied", Toast.LENGTH_LONG).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //   Log.e("TAG", error.getMessage(), error);
                                Toast.makeText(MainActivity.this, "Login Denied", Toast.LENGTH_LONG).show();
                            }
                        });
                        requestQueue.add(jORequest);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Login Deniedfirst", Toast.LENGTH_LONG).show();
                    }

                } else {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Tip:");
                    dialog.setMessage("No Password!");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    dialog.create().show();
                }

            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Tip:");
                dialog.setMessage("No Account!");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.create().show();
            }

        }
    }
}