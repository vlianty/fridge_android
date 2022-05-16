package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Drawer1Activity extends AppCompatActivity {

    Button editbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer1);
        editbtn = findViewById(R.id.editbtn);

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditDrawerActivity.class);
                startActivity(intent);
                //Log.d("test", "123");
            }
        });
    }
}

//商品細節切到編輯