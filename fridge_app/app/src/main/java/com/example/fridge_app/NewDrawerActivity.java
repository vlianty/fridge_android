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
    controller ctrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_drawer);

        //把View map進陣列
        drawerButton[0][0] = findViewById(R.id.drawer00);
        drawerButton[0][1] = findViewById(R.id.drawer01);
        drawerButton[1][0] = findViewById(R.id.drawer10);
        drawerButton[1][1] = findViewById(R.id.drawer11);
        drawerButton[2][0] = findViewById(R.id.drawer20);
        drawerButton[2][1] = findViewById(R.id.drawer21);

        ctrl = controller.getInstance();


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
            ctrl.fd[0][0].CheckWeight(this);
            ctrl.fd[0][0].CheckExpDate(this, LocalDate.now());
        }
        if(ctrl.fd[0][1] != null)
        {
            ctrl.fd[0][1].CheckExpDate(this, LocalDate.now());
        }
        //目前只有一個weightsensor所以只改第一格//just for demonstrate
    }
}

