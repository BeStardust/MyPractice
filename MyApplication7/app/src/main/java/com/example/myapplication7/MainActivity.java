package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwdEdit;
    private Button loginBtn;
  //  static boolean loginFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit = findViewById(R.id.accountEdit);
        passwdEdit = findViewById(R.id.passwdEdit);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new LoginClick());

    }

    class LoginClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String URL = "http://192.168.1.114:8080/AndroidProject/servlet/LoginServlet";
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            try {
                JSONObject loginData = new JSONObject();
                if (!accountEdit.getText().toString().equals("") && accountEdit.getText().toString() != null) {
                    if (!passwdEdit.getText().toString().equals("") && passwdEdit.getText().toString() != null) {
                        loginData.put("account", accountEdit.getText().toString()).put("passwd", passwdEdit.getText().toString());
                    }
                }
                JsonObjectRequest jORequest = new JsonObjectRequest(Request.Method.POST, URL, loginData, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                          //   System.out.println(response.getBoolean("result"));
                           // loginFlag = response.getBoolean("result");
                            if (response.getBoolean("result")) {
                                Intent intent = new Intent(MainActivity.this, home.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Login Denied", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Log.e("TAG", error.getMessage(), error);
                    }
                });
                requestQueue.add(jORequest);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}