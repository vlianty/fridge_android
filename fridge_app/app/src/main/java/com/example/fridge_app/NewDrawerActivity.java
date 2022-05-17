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
    controller ctrl;



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
        ctrl = (controller) getIntent().getSerializableExtra("ctrl");

        if(ctrl.fd[0][0] != null)   Log.d("test",ctrl.fd[0][0].goods.g_Name);
        else Log.d("test","ctrl.fd[0][0] == null");



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
                intent.putExtra("ctrl",ctrl);
                startActivity(intent);
            }
        });

        drawerButton[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Drawer1Activity.class);
                intent.putExtra("i",0);
                intent.putExtra("j",1);
                intent.putExtra("ctrl",ctrl);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("test", "refreash");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                if(ctrl.fd[i][j] != null)   drawerButton[i][j].setText(ctrl.fd[i][j].goods.g_Name + "\n" + "N/A" + ".g");
                else    drawerButton[i][j].setText("Empty");
            }
        }
    }
}

