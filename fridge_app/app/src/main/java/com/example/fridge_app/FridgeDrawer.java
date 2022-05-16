package com.example.fridge_app;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FridgeDrawer implements Serializable {
    DrawerMode mode;
    Goods goods;
    float minWeight;
    LocalDate Exdate;
    boolean underWeight = false;

    FridgeDrawer(DrawerMode mode, Goods goods, float minWeight, LocalDate Exdate)
    {
        this.mode = mode;
        this.goods = goods;
        this.minWeight = minWeight;
        this.Exdate = Exdate;
    }

    //如果重量太低回傳True
    public void CheckWeight(float curWeight)
    {
        if (curWeight < minWeight)
        {
            //修改//等Notifier做好要呼叫Notifier
            underWeight = true;
        }
        else underWeight = false;
    }

    public void CheckExpDate(LocalDate curDate)
    {
        //修改//加Notifier
        if(ChronoUnit.DAYS.between(curDate, Exdate) <= 3)
        {
            System.out.println(goods.g_Name + " will expire in " + ChronoUnit.DAYS.between(curDate, Exdate) + " days");
        }
    }
}
