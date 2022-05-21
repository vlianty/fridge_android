package com.example.fridge_app;
import android.os.Build;

import androidx.annotation.RequiresApi;

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


    private controller(FridgeDrawer[][] fd){
        this.fd = fd;
    }

    //設定格子
    public void setDrawer(int i, int j, FridgeDrawer fridegeDrawer) {
        fd[i][j] = fridegeDrawer;
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
    public void CheckAllWeight()
    {
        /*for (int i = 0; i < fd.length; i++)
        {
            for (int j = 0; j < fd[0].length;j++)
            {
                if(fd[i][j] != null)
                {
                    //修改//等WeightSensor做好要改成變數
                    fd[i][j].CheckWeight(10);
                }
            }
        }*/
        if(fd[0][0] != null)
        {

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
        for (int i = 0; i < fd.length; i++)
        {
            for (int j = 0; j < fd[0].length;j++)
            {
                if(fd[i][j] != null) fd[i][j].CheckExpDate(LocalDate.now());
            }
        }
    }

}
