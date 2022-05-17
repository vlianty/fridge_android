package com.example.fridge_app;
import java.time.LocalDate;
import java.io.Serializable;

public class controller implements Serializable {

    //View//////////////////////////////////////////////////////////////

    //Model//////////////////////////////////////////////////////////
    static public FridgeDrawer[][] fd;


    controller(FridgeDrawer[][] fd){
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
        for (int i = 0; i < fd.length; i++)
        {
            for (int j = 0; j < fd[0].length;j++)
            {
                if(fd[i][j] != null)
                {
                    //修改//等WeightSensor做好要改成變數
                    fd[i][j].CheckWeight(10);
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
