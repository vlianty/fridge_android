package com.example.fridge_app;

import androidx.core.app.NotificationCompat;

public class NotificationSender{
    public static NotificationCompat.Builder builder;
    public String GoodName = "大高麗菜";

    public  String AltLowStockTitle()
    {
        return "低庫存警告!";
    }
    public  String AltLowStockText()
    {
        return "該補貨囉";
    }
    public  String ExpTitle()
    {
        return "到期通知!";
    }
    public  String  ExpText()
    {
        return GoodName + "即將到期!!!";
    }
    public  String WrongTempTitle()
    {
        return "溫度異常!";
    }
    public  String  WrongTempText()
    {
        return "快去確認一下冰箱的狀況!!";
    }
    public  String WarnComponentTitle()
    {
        return "零件異常!";
    }
    public  String  WarnComponentText()
    {
        return "有零件壞掉了，快聯繫客服!";
    }



}