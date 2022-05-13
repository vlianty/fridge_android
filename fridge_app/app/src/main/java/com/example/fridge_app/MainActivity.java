package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNewOrder,changeProgram, btnProgress, btnSettings, btnContactService, btnMaintenance;
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

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });





    }
}