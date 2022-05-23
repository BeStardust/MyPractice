package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView txt, resultTXT;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        editText = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.button);
        resultTXT = (TextView) findViewById(R.id.resultTXT);
        button.setOnClickListener(new LoginClick());

    }

    private class LoginClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String password;
            password=editText.getText().toString();
            if (password.equals("123")){
                resultTXT.setText("LoginSuccess");
            }
            else {
                resultTXT.setText("LoginError");
            }
        }
    }

}