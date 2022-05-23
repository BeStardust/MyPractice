package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;


public class SecondActivity extends AppCompatActivity {
    DBConnection helper;
    private Button createDB, deleteDB;
    //   private boolean createDBflag = false;
    private Button addBtn, deleteBtn;
    static EditText idEdit, nameEdit;
    private Button openDbBtn, closeDbBtn, prePieceBtn, nextPieceBtn, updateBtn;
    SQLiteDatabase database;
    Cursor cursor;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView accountName = (TextView) findViewById(R.id.helloSecond);
        Bundle bundle = this.getIntent().getExtras();
        accountName.setText(bundle.getString("accountName"));

        SQLiteStudioService.instance().start(this);
        createDB = findViewById(R.id.CreateDB);
        createDB.setOnClickListener(new myClick());
        deleteDB = findViewById(R.id.DeleteDB);
        deleteDB.setOnClickListener(new myClick());

        idEdit = findViewById(R.id.IdEdit);
        nameEdit = findViewById(R.id.NameEdit);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new ClickEvents());
        deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new ClickEvents());
        openDbBtn = findViewById(R.id.openBtn);
        openDbBtn.setOnClickListener(new ClickEvents());
        closeDbBtn = findViewById(R.id.closeBtn);
        prePieceBtn = findViewById(R.id.preBtn);
        prePieceBtn.setOnClickListener(new ClickEvents());
        nextPieceBtn = findViewById(R.id.nextBtn);
        nextPieceBtn.setOnClickListener(new ClickEvents());
        updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new ClickEvents());
    }

    class ClickEvents implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v == addBtn) {
                ContentValues values = new ContentValues();
                values.put("ID", SecondActivity.idEdit.getText().toString());
                values.put("USER_NAME", SecondActivity.nameEdit.getText().toString());
                SQLiteDatabase db = helper.getWritableDatabase();
                db.insert("Users", null, values);
                db.close();
                idEdit.setText("");
                nameEdit.setText("");
                Toast.makeText(SecondActivity.this, "添加成功", Toast.LENGTH_LONG).show();
            }
            if (v == deleteBtn) {
                int position=cursor.getPosition();
                SQLiteDatabase db=helper.getWritableDatabase();
                String where="ID="+cursor.getString(0);
                db.delete("Users",where,null);
                db.close();
                Toast.makeText(SecondActivity.this,"删除成功",Toast.LENGTH_LONG).show();
//                database = openOrCreateDatabase("UserID.db", Context.MODE_PRIVATE, null);
//                cursor = database.query("Users", null, null, null, null, null, null);
//                cursor.moveToPosition(position);
//                datashow();
                onClick(openDbBtn);
                if (position>=cursor.getCount()){
                    cursor.moveToPosition(position-1);
                }
                else {
                    cursor.moveToPosition(position);
                }
                datashow();
            }
            if (v == openDbBtn) {
                database = openOrCreateDatabase("UserID.db", Context.MODE_PRIVATE, null);
                cursor = database.query("Users", null, null, null, null, null, null);
                cursor.moveToNext();
                datashow();

            }
            if (v == closeDbBtn) {
                cursor.close();
                Toast.makeText(SecondActivity.this, "正在关闭数据库", Toast.LENGTH_LONG).show();
                datashow();
            }
            if (v == prePieceBtn) {
                if (!cursor.isFirst()) {
                    cursor.moveToPrevious();
                }
                datashow();
            }
            if (v == nextPieceBtn) {
                if (!cursor.isLast()) {
                    cursor.moveToNext();
                }
                datashow();
            }
            if (v == updateBtn) {
                String where = "ID=" + cursor.getString(0);

                ContentValues values = new ContentValues();
                values.put("ID", SecondActivity.idEdit.getText().toString());
                values.put("USER_NAME", SecondActivity.nameEdit.getText().toString());
                SQLiteDatabase db = helper.getWritableDatabase();
                db.update("Users", values, where, null);
                db.close();
                int position = cursor.getPosition();
                database = openOrCreateDatabase("UserID.db", Context.MODE_PRIVATE, null);
                cursor = database.query("Users", null, null, null, null, null, null);
                cursor.moveToPosition(position);
                datashow();
            }
        }


        private void datashow() {
            idEdit.setText(cursor.getString(0));
            nameEdit.setText(cursor.getString(1));
        }
    }


    class myClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == createDB) {
                //if (createDBflag == false) {
                // DBcreate dbCreate = new DBcreate();
                helper = new DBConnection(SecondActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                //      createDBflag = true;
                Toast.makeText(SecondActivity.this, "创建成功", Toast.LENGTH_LONG).show();
                //  } else {
                //     Toast.makeText(SecondActivity.this, "已创建，无须重复创建", Toast.LENGTH_LONG).show();
                // }
            }
            if (v == deleteDB) {
                //               if (createDBflag == true) {
                deleteDatabase("UserID.db");
                //        createDBflag = false;
                Toast.makeText(SecondActivity.this, "删除成功", Toast.LENGTH_LONG).show();
//                } else {
//
//                    Toast.makeText(SecondActivity.this, "未创建数据库", Toast.LENGTH_LONG).show();
//                }

            }

        }
    }


}