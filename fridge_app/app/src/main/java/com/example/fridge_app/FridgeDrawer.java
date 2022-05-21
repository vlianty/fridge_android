package com.example.fridge_app;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import android.util.Log;

public class FridgeDrawer implements Serializable {
    DrawerMode mode;
    Goods goods;
    float minWeight;
    LocalDate Exdate;
    WeightSensor weightSensor = new WeightSensor();

    FridgeDrawer(DrawerMode mode, Goods goods, float minWeight, LocalDate Exdate)
    {
        this.mode = mode;
        this.goods = goods;
        this.minWeight = minWeight;
        this.Exdate = Exdate;
    }

    //如果重量太低回傳True
    public void CheckWeight()
    {
        if (weightSensor.getWeight() < minWeight)
        {
            //修改//等Notifier做好要呼叫Notifier
            Log.d("test",goods.g_Name + " is under weight");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void CheckExpDate(LocalDate curDate)
    {
        //修改//加Notifier
        if(ChronoUnit.DAYS.between(curDate, Exdate) <= 3)
        {
            System.out.println(goods.g_Name + " will expire in " + ChronoUnit.DAYS.between(curDate, Exdate) + " days");
        }
    }

    public double getWeight()
    {
        return weightSensor.getWeight();
    }
}
