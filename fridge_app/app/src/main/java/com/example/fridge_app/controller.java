package com.example.fridge_app;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.io.Serializable;

public class controller implements Serializable {
    private static controller instance;
    public static controller getInstance()
    {
        if(instance == null) {
            instance = new controller(new FridgeDrawer[3][2]);
        }
        return instance;
    }

    //View//////////////////////////////////////////////////////////////

    //Model//////////////////////////////////////////////////////////
    static public FridgeDrawer[][] fd;
    private TemperatureSensor temperatureSensor = new TemperatureSensor();
    private NotificationSender notificationSender = new NotificationSender();


    private controller(FridgeDrawer[][] fd){
        this.fd = fd;
    }

    //設定格子
    public void setDrawer(int id, GoodsType tmp, String img, String name, float minWeight, LocalDate ld, int i, int j) {
        Goods goods = new Goods(id,tmp,img,name);
        FridgeDrawer fd = new FridgeDrawer(null,goods,minWeight,ld);
        this.fd[i][j] = fd;
    }

    //清除格子
    public void deleDrawer(int i, int j)
    {
        fd[i][j] = null;
    }

    //取得所有格子
    public FridgeDrawer[][] getDrawer()
    {
        return fd;
    }

    //檢查重量
    public void CheckAllWeight(AppCompatActivity app)
    {
        for (int i = 0; i < fd.length; i++)
        {
            for (int j = 0; j < fd[0].length;j++)
            {
                if(fd[i][j] != null)
                {
                    fd[i][j].CheckWeight(app);
                }
            }
        }
    }

    //交換位置
    public void SwapDrawerPosition(int i, int j, int x, int y)
    {
        FridgeDrawer temp = fd[i][j];
        fd[i][j] = fd[x][y];
        fd[x][y] = temp;
    }

    //比對到期日 可能每天呼叫一次
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkExpDate()
    {
        /*for (int i = 0; i < fd.length; i++)
        {
            for (int j = 0; j < fd[0].length;j++)
            {

            }
        }*/
    }

    //確認溫度
    public void checkTemp(AppCompatActivity app)
    {
        if(temperatureSensor.getCelsius() > 11)
        {
            notificationSender.WrongTemp(app);
        }
    }

    public String getG_Name(int i, int j) {
        return fd[i][j].getG_Name();
    }

    public float getG_minWeight(int i, int j) {
        return  fd[i][j].getG_minWeight();
    }

    public LocalDate getG_ExDate(int i, int j) {
        return fd[i][j].getG_ExDate();
    }

    public GoodsType getG_Type(int i, int j) {
        return fd[i][j].getG_Type();
    }

}
