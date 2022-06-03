package com.example.fridge_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

public class NewDrawerActivity extends AppCompatActivity {

    Button [][] drawerButton = new Button[3][2];
    Button b_432, b_847, b_846, b_433;
    controller ctrl;
    AppCompatActivity app = this;
    WeightSensor weightSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drawer);
        ctrl = controller.getInstance();
        //把View map進陣列
        drawerButton[0][0] = findViewById(R.id.drawer00);
        drawerButton[0][1] = findViewById(R.id.drawer01);
        drawerButton[1][0] = findViewById(R.id.drawer10);
        drawerButton[1][1] = findViewById(R.id.drawer11);
        drawerButton[2][0] = findViewById(R.id.drawer20);
        drawerButton[2][1] = findViewById(R.id.drawer21);

        b_432 = findViewById(R.id.button432);
        b_433 = findViewById(R.id.button433);
        b_846 = findViewById(R.id.button846);
        b_847 = findViewById(R.id.button847);

        //weightSensor = ctrl.fd[0][0].getWeightSensor();


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

        drawerButton[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Drawer1Activity.class);
                intent.putExtra("i",1);
                intent.putExtra("j",1);
                startActivity(intent);
            }
        });

        //寫四個button來刷新重量432-847(6)-433，去呼叫weightsensor，然後再呼叫確認重量
        b_432.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.fd[1][1].getWeightSensor().setWeight(432);
                drawerButton[1][1].setText(ctrl.getG_Name(1, 1) + "\n" + (int)ctrl.fd[1][1].getWeight() + "g");
            }
        });
        b_433.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.fd[1][1].getWeightSensor().setWeight(433);
                drawerButton[1][1].setText(ctrl.getG_Name(1, 1) + "\n" + (int)ctrl.fd[1][1].getWeight() + "g");
                ctrl.fd[1][1].CheckWeight(app);
            }
        });
        b_846.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.fd[1][1].getWeightSensor().setWeight(846);
                drawerButton[1][1].setText(ctrl.getG_Name(1, 1) + "\n" + (int)ctrl.fd[1][1].getWeight() + "g");
            }
        });
        b_847.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctrl.fd[1][1].getWeightSensor().setWeight(847);
                drawerButton[1][1].setText(ctrl.getG_Name(1, 1) + "\n" + (int)ctrl.fd[1][1].getWeight() + "g");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onResume()
    {
        super.onResume();
        //刷新重量跟名稱
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if(ctrl.fd[i][j] != null)
                {
                    drawerButton[i][j].setText(ctrl.getG_Name(i,j) + "\n" + "N/A.g");
                }
                else    drawerButton[i][j].setText("Empty");
            }
        }

        //目前只有一個weightsensor所以只改第一格//just for demonstrate
        if(ctrl.fd[0][0] != null)
        {
            drawerButton[0][0].setText(ctrl.getG_Name(0, 0) + "\n" + ctrl.fd[0][0].getWeight() + "g");
            //ctrl.fd[0][0].CheckWeight(this);
            ctrl.fd[0][0].CheckExpDate(this, LocalDate.now());
        }
        if(ctrl.fd[0][1] != null)
        {
            ctrl.fd[0][1].CheckExpDate(this, LocalDate.now());
        }

        if(ctrl.fd[1][1] != null)
        {
            drawerButton[1][1].setText(ctrl.getG_Name(1, 1) + "\n" + (int)ctrl.fd[1][1].getWeight() + "g");
        }

        //目前只有一個weightsensor所以只改第一格//just for demonstrate
    }
}

