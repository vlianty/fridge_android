package com.example.fridge_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationSender{
    public static NotificationCompat.Builder builder;
    private String CHANNEL_ID = "Coder";

    public void AlertLowStock(AppCompatActivity m, String GoodName )
    {

        builder = new NotificationCompat.Builder(m,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.btn_star_big_on)
                .setContentTitle("Low on stock!")
                .setContentText("It's time to replenish the "+ GoodName +"  supply.")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat notificationManagerCompat
                = NotificationManagerCompat.from(m);
        notificationManagerCompat.notify(1,NotificationSender.builder.build());
    }
    public void AlertExp(AppCompatActivity m, String GoodName)
    {

        builder = new NotificationCompat.Builder(m,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.btn_star_big_on)
                .setContentTitle("到期通知!")
                .setContentText(GoodName + "即將到期!!!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat notificationManagerCompat
                = NotificationManagerCompat.from(m);
        notificationManagerCompat.notify(1,NotificationSender.builder.build());
    }
    public void WrongTemp(AppCompatActivity m)
    {

        builder = new NotificationCompat.Builder(m,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("溫度異常!")
                .setContentText("快去確認一下冰箱的狀況!!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat notificationManagerCompat
                = NotificationManagerCompat.from(m);
        notificationManagerCompat.notify(1,NotificationSender.builder.build());
    }
    public void WarnComponent(AppCompatActivity m)
    {

        builder = new NotificationCompat.Builder(m,CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("零件異常!")
                .setContentText("有零件壞掉了，快聯繫客服!")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);
        NotificationManagerCompat notificationManagerCompat
                = NotificationManagerCompat.from(m);
        notificationManagerCompat.notify(1,NotificationSender.builder.build());
    }



}