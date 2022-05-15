package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    Button btnNewOrder,changeProgram, btnProgress, btnSettings, btnContactService, btnMaintenance, btndrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewOrder = findViewById(R.id.btnNewOrder);
        changeProgram = findViewById(R.id.changeProgram);
        btnProgress = findViewById(R.id.btnProgress);
        btnSettings = findViewById(R.id.btnSettings);
        btnSettings = findViewById(R.id.btnSettings);
        btnContactService = findViewById(R.id.btnContactService);
        btnMaintenance = findViewById(R.id.btnMaintenance);
        btndrawer = findViewById(R.id.btndrawer);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });

        changeProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangeProgramActivity.class);
                startActivity(intent);
            }
        });

        btndrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewDrawerActivity.class);
                startActivity(intent);
                //Log.d("test", "123");
            }
        });

        btnNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                startActivity(intent);
            }
        });

    }
}