package com.example.fridge_app;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import android.util.Log;

public class FridgeDrawer implements Serializable {
    private DrawerMode mode;
    private Goods goods;
    private float minWeight;
    private LocalDate Exdate;
    private WeightSensor weightSensor = new WeightSensor();
    private NotificationSender notificationSender = new NotificationSender();

    FridgeDrawer(DrawerMode mode, Goods goods, float minWeight, LocalDate Exdate)
    {
        this.mode = mode;
        this.goods = goods;
        this.minWeight = minWeight;
        this.Exdate = Exdate;
    }

    //如果重量太低回傳True
    public void CheckWeight(AppCompatActivity app)
    {
        if (weightSensor.getWeight() < minWeight)
        {
            //修改//等Notifier做好要呼叫Notifier
            notificationSender.AlertLowStock(app, goods.g_Name);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void CheckExpDate(AppCompatActivity app, LocalDate curDate)
    {
        //修改//加Notifier
        if(ChronoUnit.DAYS.between(curDate, Exdate) <= 3)
        {
            notificationSender.AlertExp(app, goods.g_Name);
        }
    }

    public double getWeight()
    {
        return weightSensor.getWeight();
    }

    public String getG_Name() {
        return goods.g_Name;
    }

    public float getG_minWeight() {
        return minWeight;
    }

    public LocalDate getG_ExDate() {
        return Exdate;
    }

    public GoodsType getG_Type() {
        return goods.g_Type;
    }

    public WeightSensor getWeightSensor() {
        return weightSensor;
    }
}
