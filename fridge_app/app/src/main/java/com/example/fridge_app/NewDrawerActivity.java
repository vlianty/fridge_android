package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NewDrawerActivity extends AppCompatActivity {

    Button editbtn;
    Button [][] drawerButton = new Button[3][2];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drawer);
//        editbtn = findViewById(R.id.editbtn);

        //把View map進陣列
        drawerButton[0][0] = findViewById(R.id.drawer00);
        drawerButton[0][1] = findViewById(R.id.drawer01);
        drawerButton[1][0] = findViewById(R.id.drawer10);
        drawerButton[1][1] = findViewById(R.id.drawer11);
        drawerButton[2][0] = findViewById(R.id.drawer20);
        drawerButton[2][1] = findViewById(R.id.drawer21);

        //把主畫面送進來的controller存起來
        controller ctrl = (controller) getIntent().getSerializableExtra("ctrl");
        Log.d("test",ctrl.fd[0][0].goods.g_Name);

//        editbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), EditDrawerActivity.class);
//                startActivity(intent);
//                //Log.d("test", "123");
//            }
//        });

        drawerButton[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Drawer1Activity.class);
                intent.putExtra("i",0);
                intent.putExtra("j",0);
                startActivity(intent);
            }
        });

        drawerButton[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Drawer1Activity.class);
                intent.putExtra("i",0);
                intent.putExtra("j",1);
                startActivity(intent);
            }
        });

    }
}

