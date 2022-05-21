package com.example.fridge_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import java.time.LocalDate;


public class MainActivity extends AppCompatActivity {

    Button btnNewOrder,changeProgram, btnProgress, btnSettings, btnContactService, btnMaintenance, btndrawer;
    public static controller ctrl;
    private String CHANNEL_ID = "Coder";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //檢查手機版本是否支援通知，若支援則新增channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, "DemoCode", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannel(channel);
        }

        Button btDefault;
        btDefault = findViewById(R.id.notification);
        btDefault.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationSender ns = new NotificationSender();
                ns.builder = new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.carrot)
                        .setContentTitle(ns.WarnComponentTitle()) //通知的title，NotificationSender有可以切換的文字
                        .setContentText(ns.WarnComponentText())//通知的內文，因為還不知道要在哪判斷，所以先這樣寫
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE);
                NotificationManagerCompat notificationManagerCompat
                        = NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(1,NotificationSender.builder.build());

            }
        });


        btnNewOrder = findViewById(R.id.btnNewOrder);
        changeProgram = findViewById(R.id.changeProgram);
        btnProgress = findViewById(R.id.btnProgress);
        btnSettings = findViewById(R.id.btnSettings);
        btnSettings = findViewById(R.id.btnSettings);
        btnContactService = findViewById(R.id.btnContactService);
        btnMaintenance = findViewById(R.id.btnMaintenance);
        btndrawer = findViewById(R.id.btndrawer);

        //Controller
        FridgeDrawer[][] fridgeDrawer = new FridgeDrawer[3][2];
        ctrl = new controller(fridgeDrawer);
        //ctrl.setDrawer(0,0,new FridgeDrawer(DrawerMode.Defrost,new Goods(1,GoodsType.Cooked,null,"Apple Pie"),100,LocalDate.now()));
        //Log.d("test",ctrl.fd[0][0].goods.g_Name);

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
                intent.putExtra("ctrl",ctrl);
                startActivity(intent);
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